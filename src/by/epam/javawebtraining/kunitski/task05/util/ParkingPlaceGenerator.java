package by.epam.javawebtraining.kunitski.task05.util;

import by.epam.javawebtraining.kunitski.task05.model.resource.Parking;
import by.epam.javawebtraining.kunitski.task05.model.resource.ParkingPlace;
import java.util.LinkedList;
import java.util.Queue;

public class ParkingPlaceGenerator {

//  private static final int MAX_PARKING_PLACE_NUMBER = 5;

  public static Queue<ParkingPlace> createParkingPlaces(){

    Queue<ParkingPlace> list = new LinkedList<>();

    for (int i = 1; i <= Parking.PARKING_SIZE; i++) {
      list.add(new ParkingPlace(i));
    }

    return list;
  }
}
