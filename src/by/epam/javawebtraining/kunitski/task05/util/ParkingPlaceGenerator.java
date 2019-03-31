package by.epam.javawebtraining.kunitski.task05.util;

import by.epam.javawebtraining.kunitski.task05.model.resource.ParkingPlace;
import java.util.LinkedList;

public class ParkingPlaceGenerator {

  private static final int MAX_PARKING_PLACE_NUMBER = 5;

  public static LinkedList<ParkingPlace> createParkingPlaces(){

    LinkedList<ParkingPlace> list = new LinkedList<>();

    for (int i = 1; i <= MAX_PARKING_PLACE_NUMBER; i++) {
      list.add(new ParkingPlace(i));
    }

    return list;
  }
}
