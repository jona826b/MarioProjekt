
import MarioProjekt.src.Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
  ArrayList<Pizza> orders;

  public static void main(String[] args) {
    MenuCard menuCard = new MenuCard();
    System.out.println(Arrays.toString(new MenuCard[]{menuCard}));

    new Main().run();
  }

  void run() {
    boolean progess;
    Menu menu = new Menu("Choose option", "choose option", new String[]{
        "1.Display Menu",
        "2.Start Order",
        "3.Display Orders",
        "4.End order"});

    progess = true;
    while (progess) {
      menu.printMenu();
      int menuOption = menu.readChoice();

      switch (menuOption) {
        case 1:
          displayMenu();
          break;
        case 2:
          enterOrder();
          break;
        case 4:
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
    void enterOrder(){
    int number;
    Pizza pizza;
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter the number of the pizza you wanna order");
      number = scan.nextInt();

      pizza = new Pizza();

      orders.add(pizza);
    }
  }

