package com.aayush;

import com.aayush.dto.PaymentReceipt;
import com.aayush.dto.SpotRateTable;
import com.aayush.dto.VehicleRateTable;
import com.aayush.factory.FloorFactory;
import com.aayush.model.*;
import com.aayush.service.BillingService;
import com.aayush.service.PaymentService;
import com.aayush.service.SpotFinder;
import com.aayush.strategy.allocation.NearestSpotStrategy;
import com.aayush.strategy.billing.CombinedBillingStrategy;
import com.aayush.strategy.payment.UPIPaymentStrategy;

import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        VehicleRateTable vehicleRateTable = new VehicleRateTable(Map.of(VehicleType.BIKE, 10d, VehicleType.CAR, 20d, VehicleType.TRUCK, 30d));
        SpotRateTable spotRateTable = new SpotRateTable(Map.of(SpotType.SMALL, 1d, SpotType.MEDIUM, 1.5d, SpotType.LARGE, 2d));

        SpotFinder spotFinder = new SpotFinder();
        PaymentService paymentService = new PaymentService();
        BillingService billingService = new BillingService();
        spotFinder.setStrategy(new NearestSpotStrategy());
        paymentService.setStrategy(new UPIPaymentStrategy());
        billingService.setStrategy(new CombinedBillingStrategy(vehicleRateTable,spotRateTable,10));

        Floor f1 = FloorFactory.createFloor("f1");
        Floor f2 = FloorFactory.createFloor("f2");
        f1.addSpot(SpotType.SMALL);
        f1.addSpot(SpotType.SMALL);
        f1.addSpot(SpotType.MEDIUM);
        f2.addSpot(SpotType.MEDIUM);
        f2.addSpot(SpotType.MEDIUM);
        f2.addSpot(SpotType.LARGE);
        ParkingLot parkingLot =new ParkingLot(List.of(f1,f2),spotFinder,billingService,paymentService);
        Vehicle car1 = new Car("ka-0101234");
        Vehicle car2 = new Car("la-0201234");
        Vehicle truck1 = new Truck("la-01-00999");
        Vehicle truck2 = new Truck("la-08-1234");
        try {
          Ticket ticket1 =   parkingLot.parkVehicle(car1);
          Ticket ticket2 = parkingLot.parkVehicle(truck1);

          System.out.println(ticket1.getSpotId());
          System.out.println(ticket2.getSpotId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



    }
}