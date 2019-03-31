package by.epam.javawebtraining.kunitski.task05.model.resource;

import by.epam.javawebtraining.kunitski.task05.view.LogPrinter;

import java.util.concurrent.TimeUnit;

public class ParkingPlace {

  private int parkingPlaceNumber;

  public ParkingPlace(int parkingPlaceNumber) {
    this.parkingPlaceNumber = parkingPlaceNumber;
  }

  public int getParkingPlaceNumber() {
    return parkingPlaceNumber;
  }

  public void setParkingPlaceNumber(int parkingPlaceNumber) {
    if (parkingPlaceNumber > 0) {
      this.parkingPlaceNumber = parkingPlaceNumber;
    }
  }

  public void carStaying(long stayingTime) {

    try {
      TimeUnit.MILLISECONDS.sleep(stayingTime);
    } catch (InterruptedException e) {
      LogPrinter.FILE_LOGGER.error(e);
    }
  }

}
