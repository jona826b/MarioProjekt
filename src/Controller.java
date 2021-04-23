import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {
  ArrayList<Order> allOrders = new ArrayList<>();
  //private int numberOfOrders = 0;
  private String MARIOSORDERS = "orders.txt";
  private FileOutputStream outPutFile;
  private LocalDateTime localedatetime = LocalDateTime.now();
  PrintStream outFile;

  void run() {
    loadList();
    File logFile = new File(MARIOSORDERS);
    try {
      logFile.createNewFile();
      outPutFile = new FileOutputStream(logFile, true);
      outFile = new PrintStream(outPutFile);

    } catch (IOException | InputMismatchException e) {
      System.out.println("IO" + e);
    }

    boolean progess;
    Menu menu = new Menu("Choose option", "choose option", new String[]{
        "1.Display Menu",
        "2.Start Order",
        "3.Display Orders",
        "4.Delete Order",
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
        case 3:
          displayOrder();
          break;
        case 4:
          deleteOrder();
          break;
        case 5:
          progess = false;
          break;
        default:
          System.out.println("Error");
      }
    }
  }

  void enterOrder() {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter the number of the pizza you wanna order?");
    System.out.println("End order with 0");

    int number = scan.nextInt();
    ArrayList<Integer> orders = new ArrayList<>();

    if (number <= 14 && number >= 0) {

      while (number != 0) {
        if (number <= 14) {

          orders.add(number);
          number = scan.nextInt();
        } else {
          System.out.println("'" + number + "'" + " Is not a pizza please try again with a number between 1-14");
          number = scan.nextInt();
        }
      }
      //numberOfOrders++;
      Order order = new Order(orders, LocalDateTime.now().toString());
      System.out.println(order);
      allOrders.add(order);
      outFile.println(order);

    }
  }




  void loadList() {

    int numberOfOrders = 0;
    try {
      Scanner filereader = new Scanner(new File(MARIOSORDERS));
      while (filereader.hasNext()) {
        String f = filereader.nextLine();
        String[] split = f.split(",");
        numberOfOrders = Integer.parseInt(split[0]);
        String time = split[1];
        ArrayList<Integer> pizza = new ArrayList<>();
        for (int i = 2; i < split.length; i++){
          pizza.add(Integer.parseInt(split[i]));
        }
        Order order = new Order(numberOfOrders, pizza ,time );

        allOrders.add(order);
        Order.x(numberOfOrders);
      }
      System.out.println("loaded");
    } catch (InputMismatchException | FileNotFoundException e) {
      System.out.println("IO" + e);
    }
  }
  void displayOrder () {
    for (int i = 0; i < allOrders.size(); i++){
      System.out.println(allOrders.get(i));

    }
  }
  void deleteOrder (){
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter order number you want to delete");
    int orderNr = scan.nextInt();
    for (int i = 0; i < allOrders.size(); i++){
      if (orderNr == allOrders.get(i).orderNr){
        allOrders.remove(allOrders.get(i));
        resetLogFile();
        break;
      }
    }

  }
  void resetLogFile(){
    try {
      outPutFile = new FileOutputStream(MARIOSORDERS, false);
      outFile = new PrintStream(outPutFile);

    } catch (IOException | InputMismatchException e) {
      System.out.println("IO" + e);
    }
    for (int i = 0; i < allOrders.size(); i++){
      outFile.println(allOrders.get(i));

    }
  }

}
