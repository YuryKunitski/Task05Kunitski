package by.epam.javawebtraining.kunitski.task05.model.resource;

import by.epam.javawebtraining.kunitski.task05.view.LogPrinter;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Parking {

  public final static int PARKING_SIZE = 5;
  private Semaphore semaphore;
  private Queue<ParkingPlace> parkingList;
  private String name;

  public Parking() {
    semaphore = new Semaphore(PARKING_SIZE, true);
    parkingList = new LinkedList<>();
  }

  public Parking(Queue<ParkingPlace> parkingList, String name) {
    this();
    this.name = name;
    this.parkingList.addAll(parkingList);
  }

  public Queue<ParkingPlace> getParkingList() {
    return parkingList;
  }

  public String getName() {
    return name;
  }

  public ParkingPlace entry(long maxWaitMillis) {
    ParkingPlace currentPlace = null;
    try {
      if (semaphore.tryAcquire(maxWaitMillis, TimeUnit.MILLISECONDS)) {
        currentPlace = parkingList.poll();
      }

    } catch (InterruptedException e) {
      LogPrinter.LOGGER.error(e);
    }
    return currentPlace;

  }

  public void exit(ParkingPlace place) {
    parkingList.add(place);
    semaphore.release();
  }

}
