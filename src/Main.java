

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
  ArrayList<Integer> orders = new ArrayList<>();
  private String MARIOSORDERS = "C:/gitrepos/MarioProjekt/src/orders.txt";
  private LocalDateTime localedatetime = LocalDateTime.now();


  public static void main(String[] args) {
    System.out.println(new File("orders").getAbsolutePath());
    MenuCard menuCard = new MenuCard();
    new Main().run();
  }

  void run() {
    boolean progess;
    Menu menu = new Menu("Choose option", "choose option", new String[]{
        "1.Display Menu",
        "2.Start Order",
        "3.Display Orders",
        "4. load order",
        "5.End order"});

    progess = true;
    while (progess) {
      menu.printMenu();
      int menuOption = menu.readChoice();
      MenuCard menuCard = new MenuCard();
      switch (menuOption) {
        case 1:
          menuCard.printMenu();
          break;
        case 2:
          enterOrder();
          break;
        case 4:
          loadList1();
          break;
        case 5:
          progess = false;
          break;
        default:
          System.out.println("Error");
      }
    }
  }

    void displayMenu() {
      System.out.println("\nDisplay Menu");
      for (int i = 0; i < orders.size(); i++) {
        System.out.println("#" + i + ": " + orders.get(i));
      }
    }

  public ArrayList<Integer> getOrders() {
    return orders;
  }

  public void setOrders(ArrayList<Integer> orders) {
    this.orders = orders;
  }

  void enterOrder(){
    Scanner scan = new Scanner(System.in);
      System.out.println("Enter the number of the pizza you wanna order TEST");
      int number = scan.nextInt();
      while (number != 0)
      {
        orders.add(number);
        number = scan.nextInt();
      }
      System.out.println(orders);
      try {
        PrintStream outFile = new PrintStream(new File(MARIOSORDERS));
        for (int i = 0; i < orders.size(); i++) {
          outFile.println(orders.get(i));

        }
        outFile.println("\n" + localedatetime);
      }
      catch (InputMismatchException | FileNotFoundException e) {
        System.out.println("IO" + e);
      }
    }

  void loadList1(){
    ArrayList<Integer> ordersFromFile = new ArrayList<>();
    try {
      Scanner filereader = new Scanner(new File(MARIOSORDERS));
      while(filereader.hasNext()){
        String f = filereader.nextLine();
        ordersFromFile.add(Integer.valueOf(f));
      }
      orders = ordersFromFile;
      System.out.println("loaded");
    } catch (InputMismatchException | FileNotFoundException e){
      System.out.println("IO" + e);
    }
  }
  }

