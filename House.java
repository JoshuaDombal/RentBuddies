

import java.util.*;

public class House {

  private String houseName;
  private LinkedList<Roomate> members;
  private int numberOfMembers;


  public House(String houseName, int numberOfMembers) {
    this.houseName = houseName;
    members = new LinkedList<Roomate>();
    this.numberOfMembers = numberOfMembers;
  }

  public void changeHouseName(String newName) {
    this.houseName = newName;
  }

  public void addMember(Roomate name) {
    members.add(name);
    numberOfMembers++;
  }

  public void removeMember(Roomate name) {
    members.remove(name);
  }

  // Returns a roomate object given a name
  public Roomate getRoomate(String name) {
    for (int i = 0; i < numberOfMembers; i++) {
      if (members.get(i).getName().equals(name))
        return members.get(i);
    }
    System.out.println("Roomate not found");
    return null;
  }

  public String getHouseName() {
    return this.houseName;
  }

  public int getNumMembers() {
    return this.numberOfMembers;
  }



}
