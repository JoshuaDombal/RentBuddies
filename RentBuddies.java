
import java.util.*;
import java.io.*;
import java.util.Scanner;

public class RentBuddies {

  public static void main(String args[]) {

      Roomate roomate;


      Scanner scan = new Scanner(System.in);

      System.out.println("Please enter your name");
      String name = scan.nextLine();

      System.out.println("Would you like to add a house?");
      String answer = scan.nextLine();

      if (answer.equals("Yes")) {
        //LinkedList<Roomate> members = new LinkedList<Roomate>();
        int numMembers = 0;

        System.out.println("Enter the name of your house:");
        String houseName = scan.nextLine();

        System.out.println("Thank you");

        System.out.println("Please list the name of the members: ");

        String[] members = scan.nextLine().split("\\s+");

        House house = new House(houseName, numMembers);
        roomate = new Roomate(name, 0, house);
        house.addMember(roomate);

        // Adds each member to the house
        for (String member : members) {
          Roomate rm = new Roomate(member, 0, house);
          house.addMember(rm);
        }

        // Add members individually
        /*
        System.out.println("How many members would you like to add?");
        numMembers = scan.nextInt();

        for (int i = 0; i < numMembers; i++) {
          System.out.println("Enter the name a house member: ");
          members.add(scan.next());
        }
        */






      } else {

        return;
      }

      while (true) {

        System.out.println("Which action would you like to perform: ");
        System.out.println("1.) Request a payment");

        System.out.println("2.) Check who you owe");

        System.out.println("3.) Remove a payment");

        String choice = scan.nextLine();

        if (choice.equals("1")) {
            System.out.println("What is the payment for: ");
            scan = new Scanner(System.in);
            String type = scan.nextLine();

            System.out.println("Who would you like to request to pay for this: ");
            String[] who = scan.nextLine().split("\\s+");

            System.out.println("What is the amount of the payment: ");
            double amount = scan.nextDouble();



            //double amountPerPerson = roomate.requestPayment(payment, amount, who);

            roomate.requestPayment(type, who, amount);

            System.out.println("Each person owes: $" + amount/who.length + " for " + type);



        } else if (choice.equals("2")) {
            LinkedList<Roomate> whoYouOwe = roomate.getRoomatesToPay();
            int size = whoYouOwe.size();
            if (size == 0) {
                System.out.println("No one owes you anything");
                System.out.println("");
            } else {
                for (Roomate r: whoYouOwe) {
                    System.out.println(r.getName() + " owes you");
                }
            }

        } else if (choice.equals("3")) {
            LinkedList<Payment> payments = roomate.getPaymentsIamOwed();
            int size = payments.size();

            if (size == 0) {
                System.out.println("You have no payments that you are owed");
            } else {
                for (int i = 0; i < size; i++) {
                    Payment payment = payments.get(i);
                    System.out.println("Payment " + (i+1) + ": " + payment.getPersonOwed().getName() + " owes you $" + payment.getAmount() + " for " + payment.getType());
                }

                System.out.println("Which payment would you like to remove?");
                int num = scan.nextInt() - 1;

                roomate.removePayment(payments.get(num));
            }


        }
          else {
          System.out.println(" ... ");
        }

        choice = " ";

      }




  }


}
