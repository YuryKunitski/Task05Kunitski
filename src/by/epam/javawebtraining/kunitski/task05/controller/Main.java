package by.epam.javawebtraining.kunitski.task05.controller;

import by.epam.javawebtraining.kunitski.task05.model.thread.Car;
import by.epam.javawebtraining.kunitski.task05.model.resource.Parking;
import by.epam.javawebtraining.kunitski.task05.model.resource.ParkingPlace;
import by.epam.javawebtraining.kunitski.task05.util.CarGenerator;
import by.epam.javawebtraining.kunitski.task05.util.ParkingPlaceGenerator;
import by.epam.javawebtraining.kunitski.task05.view.LogPrinter;

import java.util.LinkedList;

public class Main {

  public static void main(String[] args) {

    LogPrinter.FILE_LOGGER.info("Start main thread!");

    LinkedList<ParkingPlace> list = ParkingPlaceGenerator.createParkingPlaces();

    Parking parking = new Parking(list);

    Car[] cars = CarGenerator.createCars(parking);

    for (Car c : cars){
      try {
        c.getThread().join();
      } catch (InterruptedException e) {
        LogPrinter.FILE_LOGGER.error(e);
      }
    }

    LogPrinter.FILE_LOGGER.info("Finish main thread!");

  }

}
