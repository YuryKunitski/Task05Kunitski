package by.epam.javawebtraining.kunitski.task05.util;

import by.epam.javawebtraining.kunitski.task05.model.resource.City;
import by.epam.javawebtraining.kunitski.task05.model.resource.Parking;
import by.epam.javawebtraining.kunitski.task05.model.resource.ParkingPlace;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CityGenerator {


  public static City cityGenerator(){

    Queue<ParkingPlace> queue = ParkingPlaceGenerator.createParkingPlaces();

    List<Parking> parkingList = new ArrayList<>();
    parkingList.add(new Parking(queue,"PARK_1"));
    parkingList.add(new Parking(queue, "PARK_2"));
    parkingList.add(new Parking(queue, "PARK_3"));

    return City.getInstance(parkingList);
  }
}
