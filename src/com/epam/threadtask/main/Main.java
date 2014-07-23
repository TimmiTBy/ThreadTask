package com.epam.threadtask.main;

import com.epam.threadtask.entity.Car;
import com.epam.threadtask.entity.Parking;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.util.ArrayList;

public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class);

    static {
        new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
    }

    public static final int PARKINGS_IN_AREA = 3;
    public static final int CARS_IN_AREA = 6;


    public static void main(String[] args) {

        ArrayList<Parking> parkings = new ArrayList<Parking>();
        for (int i = 0; i < PARKINGS_IN_AREA; i++) {
            String parkName = "Parking № " + String.valueOf(i);
            parkings.add(new Parking(parkName));
        }

        for (int i = 1; i < CARS_IN_AREA; i++) {
            String carName = "car №" + i;
            new Car(carName, parkings).start();

        }


    }

}
