package by.epam.javawebtraining.kunitski.task05.model.resource;

import by.epam.javawebtraining.kunitski.task05.view.LogPrinter;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Parking {

  private final static int PARKING_SIZE = 5;
  private final Semaphore semaphore = new Semaphore(PARKING_SIZE, true);
  private final Queue<ParkingPlace> parkingList = new LinkedList<>();

  public Parking(Queue<ParkingPlace> parkingList) {
    this.parkingList.addAll(parkingList);

  }

  public ParkingPlace entry(long maxWaitMillis)  {
    ParkingPlace currentPlace = null;
    try {
      if (semaphore.tryAcquire(maxWaitMillis, TimeUnit.MILLISECONDS)) {
        currentPlace = parkingList.poll();
        return currentPlace;
      }

    } catch (InterruptedException e) {
      LogPrinter.FILE_LOGGER.error(e);
    }
    return currentPlace;

  }

  public void exit(ParkingPlace place) {
    parkingList.add(place);
    semaphore.release();
  }

}
