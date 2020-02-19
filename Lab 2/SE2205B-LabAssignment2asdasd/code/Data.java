/* Authors: Abdullah Sahapdeen - Id: asahapde - Student Number: 251033977 and Mayank Sood - Id: msood - Student Number: 251000865
   Date Created: November 4, 2019
*/
public class Data{
  double arrivalTime;
  double departureTime;

  public Data(){
    arrivalTime =0;
    departureTime =0;
  }
  public void setArrivalTime(double a){
    arrivalTime = a;
  }
  public void setDepartureTime(double d){
    departureTime = d;
  }
  public double getDepartureTime(){
    return departureTime;
  }
  public double getArrivalTime(){
    return arrivalTime;
  }
}
