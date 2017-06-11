

import java.util.*;

public class Roomate {

  private String name;
  private int amountOwed;
  private House house;
  private LinkedList<Roomate> roomatesToPay;
  private LinkedList<Payment> owesMe;
  private LinkedList<Payment> iOwe;


  public Roomate(String name, int amountOwed, House house) {
    this.name = name;
    this.amountOwed = amountOwed;
    this.house = house;
    roomatesToPay = new LinkedList<Roomate>();
    owesMe = new LinkedList<Payment>();
    iOwe = new LinkedList<Payment>();
  }

  public Roomate(String name, House house) {
    this.name = name;
    this.house = house;
    this.amountOwed = 0;
  }

  public void heOwes(int amount) {
    this.amountOwed += amount;
  }

  public void hePaid(int paid) {
    this.amountOwed -= paid;
  }


  // Allows member to request roomates to help pay for something
  public void requestPayment(String type, String[] who, double amount) {
    double amountPerPerson = amount/(who.length);

    int len = who.length;
    for (int i = 0; i < len; i++) {
      Roomate currentRoomate;
      currentRoomate = house.getRoomate(who[i]);

      Payment payment = new Payment(currentRoomate, type, amountPerPerson);
      owesMe.add(payment);
    }

    // NEEDS TO SEND TO EACH MEMBER

  }

  public void removePayment(Payment payment) {
      int size = owesMe.size();
      for (int i = 0; i < size; i++) {
          if (owesMe.get(i) == payment) {
              owesMe.remove(i);
              return;
          }
      }
  }

  //


  public String getName() {
    return this.name;
  }

  public LinkedList<Payment> getPaymentsIamOwed() {
      return this.owesMe;
  }

  public LinkedList<Payment> getPaymentsIOwed() {
      return this.iOwe;
  }

  public LinkedList<Roomate> getRoomatesToPay() {
      return this.roomatesToPay;
  }

  /*
  public Payment getPaymentIowe(String payment) {
      //if (owesMe.size() == 0) {
      //}
    int length = owesMe.size();
    int i = 0;
      while(i < length) {
          if ()
      }
  }
*/

/*
  public Payment getPaymentIAmOwed(String payment) {
      //if (iOwe.size() == 0) {
      //}
      int length = iOwe.size();
      int i = 0;
      while(i < length) {
          if ()
      }
  }
*/

  //public LinkedList<String>

}
