package by.epam.javawebtraining.kunitski.task05.model.resource;

import by.epam.javawebtraining.kunitski.task05.view.LogPrinter;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class City {

  private static City city;
  private List<Parking> parkingList;

  private City(List<Parking> parkingList) {
    this.parkingList = parkingList;
  }

  public static City getInstance(List<Parking> parkingList) {
    if (null == city) {
      city = new City(parkingList);
    }
    return city;
  }

  public List<Parking> getParkingList() {
    return parkingList;
  }

}
