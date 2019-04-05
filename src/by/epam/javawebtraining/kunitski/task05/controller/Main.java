package by.epam.javawebtraining.kunitski.task05.controller;

import by.epam.javawebtraining.kunitski.task05.model.resource.City;
import by.epam.javawebtraining.kunitski.task05.model.thread.Car;
import by.epam.javawebtraining.kunitski.task05.model.resource.Parking;
import by.epam.javawebtraining.kunitski.task05.model.resource.ParkingPlace;
import by.epam.javawebtraining.kunitski.task05.util.CarGenerator;
import by.epam.javawebtraining.kunitski.task05.util.CityGenerator;
import by.epam.javawebtraining.kunitski.task05.util.ParkingPlaceGenerator;
import by.epam.javawebtraining.kunitski.task05.view.LogPrinter;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;

public class Main {

  public static void main(String[] args) {

    LogPrinter.LOGGER.info("Start main thread!");

    Queue<ParkingPlace> list = ParkingPlaceGenerator.createParkingPlaces();
    City city = CityGenerator.cityGenerator();
    Car[] cars = CarGenerator.createCars(city);

    Executor executor = Executors.newFixedThreadPool(CarGenerator.CAR_COUNT);

    for (Car c : cars) {
      executor.execute(c);
    }

    ((ExecutorService) executor).shutdown();

    LogPrinter.LOGGER.info("Finish main thread!");
  }

}
