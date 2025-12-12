package com.aayush;
import com.aayush.model.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Vehicle truck1 = new Car("HR49123456");
        System.out.println(truck1.getLicencePlate()+" "+truck1.getAllowedSpotType());
        Floor f1 = new Floor("f1");
        f1.addSpot(SpotType.MEDIUM);
        System.out.println(f1.getAvailableSpots());
        f1.markOccupied("1");
        System.out.println(f1.getAvailableSpots());
        f1.markAvailable("1");
        System.out.println(f1.getAvailableSpots());
    }
}