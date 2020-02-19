/* Authors: Abdullah Sahapdeen - Id: asahapde - Student Number: 251033977 and Mayank Sood - Id: msood - Student Number: 251000865
   Date Created: November 4, 2019
*/
import java.lang.*;

public class QueueSimulator{
  public enum Event { ARRIVAL, DEPARTURE };
  private double currTime;
  private double arrivalRate;
  private double serviceTime;
  private double timeForNextArrival;
  private double timeForNextDeparture;
  private double totalSimTime;
  LinkedListQueue<Data> buffer = new LinkedListQueue<Data>();
  LinkedListQueue<Data> eventQueue = new LinkedListQueue<Data>();
  private Event e;

  public double getRandTime(double arrivalRate){
    double num, time1, max=1, min=0, randNUM;
    randNUM= Math.random();
    time1= (-1/arrivalRate) * (Math.log(1-randNUM));
    //System.out.println(time1);
    return time1;
  }

  public QueueSimulator(double aR, double servT, double simT){
    arrivalRate = aR;
    serviceTime = servT;
    totalSimTime = simT;
    timeForNextDeparture = serviceTime + timeForNextArrival;
  }

  public double calcAverageWaitingTime(){
    // (1/arrivalRate)*((arrivalRate/(1/serviceTime))+((0.5*Math.pow((arrivalRate/(1/serviceTime)),2))/(1-(arrivalRate/(1/serviceTime)))))
    double totalTime = 0;
    int n = eventQueue.size();

    for(int i = 0; i < n; i++){
      Data d = new Data();
      d = eventQueue.dequeue();
      totalTime += d.getDepartureTime() - d.getArrivalTime();
    }
    return (totalTime/n);
  }

  public double runSimulation(){
    currTime = 0;
    while(currTime<totalSimTime){
      if(buffer.isEmpty()){
        e = Event.ARRIVAL;
        currTime = timeForNextArrival;
      }
      if (timeForNextArrival < timeForNextDeparture){
        e = Event.ARRIVAL;
        currTime = timeForNextArrival;
      }
      else{
        e = Event.DEPARTURE;
        currTime = timeForNextDeparture;
      }
      if(e==Event.ARRIVAL){
        Data d = new Data();
        d.setArrivalTime(currTime);
        buffer.enqueue(d);
        timeForNextArrival = currTime + getRandTime(arrivalRate);
      }
      else if(e==Event.DEPARTURE){
        Data d = buffer.dequeue();
        d.setDepartureTime(currTime);
        eventQueue.enqueue(d);
        if (!buffer.isEmpty())
          timeForNextDeparture = currTime + serviceTime;
        else
          timeForNextDeparture = timeForNextArrival + serviceTime;
      }
    }
    return calcAverageWaitingTime();
  }
}
