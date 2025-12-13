package com.aayush;

import com.aayush.dto.Bill;
import com.aayush.dto.ExitResponse;
import com.aayush.dto.PaymentReceipt;
import com.aayush.factory.TicketFactory;
import com.aayush.model.*;
import com.aayush.service.BillingService;
import com.aayush.service.PaymentService;
import com.aayush.service.SpotFinder;
import com.aayush.strategy.allocation.NearestSpotStrategy;
import com.sun.jdi.request.DuplicateRequestException;

import java.time.LocalDateTime;
import java.util.*;

public class ParkingLot {
    private final List<Floor> floorList;
    private final SpotFinder spotFinder;
    private final BillingService billingService;
    private final PaymentService paymentService;
    private final Map<UUID, Ticket> ticketHashMap;
    private final Map<String, UUID> licencePlateToTicketMap;
    ;

    public ParkingLot(List<Floor> floorList, SpotFinder spotFinder, BillingService billingService,
                      PaymentService paymentService) {
        this.floorList = List.copyOf(floorList);
        this.spotFinder = spotFinder;
        this.billingService = billingService;
        this.paymentService = paymentService;
        ticketHashMap = new HashMap<>();
        licencePlateToTicketMap = new HashMap<>();
    }

    public Ticket parkVehicle(Vehicle vehicle) throws Exception {
        String licencePlate = vehicle.getLicencePlate();
        if (licencePlateToTicketMap.containsKey(licencePlate)) {
            throw new DuplicateRequestException("Vehicle already parked");
        }
        String allocatedSpotId = null;
        Floor allocatedFloor = null;
        for (Floor floor : floorList) {
            Map<SpotType, Set<String>> availableSpots = floor.getAvailableSpots();
            allocatedSpotId = spotFinder.findSpot(vehicle.getAllowedSpotType(), availableSpots);
            if (allocatedSpotId != null) {
                allocatedFloor = floor;
                break;
            }
        }
        if (allocatedSpotId == null) {
            throw new Exception("");
        }
        boolean allocated = false;
        try {
            allocatedFloor.markOccupied(allocatedSpotId);
            allocated = true;
            ParkingSpot spot = allocatedFloor.getSpotById(allocatedSpotId);
            Ticket ticket = TicketFactory.createTicket(licencePlate,
                    vehicle.getVehicleType(),
                    allocatedFloor,
                    spot.getSpotId(),
                    spot.getSpotType());
            ticketHashMap.put(ticket.getTicketId(), ticket);
            licencePlateToTicketMap.put(licencePlate, ticket.getTicketId());
            return ticket;
        } catch (Exception e) {
            if (allocated)
                allocatedFloor.markAvailable(allocatedSpotId);   // rollback
            throw e;
        }
    }

    public ExitResponse exitVehicle(UUID ticketId) {
        if (ticketId == null) throw new IllegalArgumentException("ticketId cannot be null");
        if (!ticketHashMap.containsKey(ticketId)) {
            throw new IllegalArgumentException("ticketId Invalid or already exited");
        }
        Ticket ticket = ticketHashMap.get(ticketId);
        String spotId = ticket.getSpotId();
        ticket.getFloor().markAvailable(spotId);

        LocalDateTime exitTime = LocalDateTime.now();
        Bill bill = billingService.generateBill(ticket, exitTime);

        PaymentReceipt paymentReceipt = paymentService.payBill(bill);
        ticketHashMap.remove(ticketId);
        licencePlateToTicketMap.remove(ticket.getLicencePlate());
        return new ExitResponse(ticket, bill, paymentReceipt);


    }
}
