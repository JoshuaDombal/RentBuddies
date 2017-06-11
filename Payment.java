

public class Payment {

  private Roomate personWhoOwes;
  private String type;
  private double amountOwed;



  public Payment(Roomate person, String type, double amount) {
    this.personWhoOwes = person;
    this.type = type;
    this.amountOwed = amount;
  }

  // Returns type of payment
  public String getType() {
    return type;
  }

  // Returns the amount owed on the payment
  public double getAmount() {
    return amountOwed;
  }

  public Roomate getPersonOwed() {
    return personWhoOwes;
  }
}
