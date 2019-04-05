package by.epam.javawebtraining.kunitski.task05.model.thread;

import by.epam.javawebtraining.kunitski.task05.model.resource.City;
import by.epam.javawebtraining.kunitski.task05.model.resource.Parking;
import by.epam.javawebtraining.kunitski.task05.model.resource.ParkingPlace;
import by.epam.javawebtraining.kunitski.task05.util.CityGenerator;
import by.epam.javawebtraining.kunitski.task05.view.LogPrinter;

public class Car implements Runnable {

  private long waitingTime;    //in millisecond
  private long stayingTime;    //in millisecond
  private boolean reading = false;
  //  private Parking parking;
  private City city;
  private Thread thread;

  public Car(City city, long waitingTime, long stayingTime) {
//    this.parking = parking;
    this.city = city;
    this.waitingTime = waitingTime;
    this.stayingTime = stayingTime;
    thread = new Thread(this);
//    thread.start();
  }

  public long getWaitingTime() {
    return waitingTime;
  }

  public void setWaitingTime(long waitingTime) {
    if (waitingTime > 0) {
      this.waitingTime = waitingTime;
    }
  }

  public long getStayingTime() {
    return stayingTime;
  }

  public void setStayingTime(long parkingTime) {
    if (parkingTime > 0) {
      this.stayingTime = parkingTime;
    }
  }

  public boolean isReading() {
    return reading;
  }

  public Thread getThread() {
    return thread;
  }

  @Override
  public void run() {

    ParkingPlace parkingPlace = null;

    for (Parking parking : city.getParkingList()) {
      try {

        parkingPlace = parking.entry(waitingTime);

        if (parkingPlace != null) {
          reading = true;

          LogPrinter.LOGGER.info("Car #"
                  + thread.getId()
                  + " entered into the parking - " + parking.getName() + " and got place #"
                  + parkingPlace.getParkingPlaceNumber() + ".");

          parkingPlace.carStaying(stayingTime);
        } else {
          LogPrinter.LOGGER.info("Car #" + thread.getId()
                  + " waiting time out. Parking " + parking.getName()
                  + " has not a free space.  This car move to another parking.");
        }

      } finally {
        if (parkingPlace != null) {
          reading = false;

          LogPrinter.LOGGER.info("Car #" + thread.getId() + " released parking place #"
            + parkingPlace.getParkingPlaceNumber() + " and exit from the parking " + parking.getName() + "!");

          parking.exit(parkingPlace);
          break;
        }
      }
    }
  }

}
