package com.epam.threadtask.entity;

import org.apache.log4j.Logger;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Parking {


    private static final Logger LOG = Logger.getLogger(Parking.class);

    public final int PARKING_PLACES = 3;

    private String name;

    private Semaphore semaphore;

    public Parking(String name) {
        this.name = name;
        semaphore = new Semaphore(PARKING_PLACES);
    }

    public boolean tryPark(Car car, long waitTime) {
        boolean result = false;

        try {
            if (semaphore.tryAcquire(waitTime, TimeUnit.MILLISECONDS)) {

               result = true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return result;
    }

    public void leave(Car car) {
        semaphore.release();
        LOG.info(car.getCarName()+ " left parking");
    }

    public String getName() {
        return name;
    }
}
