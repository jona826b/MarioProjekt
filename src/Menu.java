
import java.util.Scanner;

public class Menu {
  private String menuHeader;
  private String leadText;
  private String[] menuitems;

  public Menu(String menuHeader, String leadText, String[] menuitems) {
    this.menuHeader = menuHeader;
    this.leadText = leadText;
    this.menuitems = menuitems;
  }
  public void printMenu(){
    String printString = menuHeader +"\n";

    for (int i= 0; i < menuitems.length; i++)
      printString += menuitems[i] + "\n";
    System.out.println("\n" + printString);
  }

  public int readChoice(){
    Scanner scan = new Scanner(System.in);
    boolean validChoice = false;
    int choice = -1;

    while(!validChoice){
      System.out.println(leadText);
      if (scan.hasNextInt()){
        choice = scan.nextInt();
        validChoice = true;
      } else {
        scan.nextLine();
      }
    }
    return choice;
  }
}
