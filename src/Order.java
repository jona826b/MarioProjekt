import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
  private static int orderNrGenerator = 0;
  int orderNr;
  ArrayList<Integer> pizzas;
  String localdatetime;

  public Order(ArrayList<Integer> pizzas, String now) {
    orderNrGenerator++;
    this.orderNr = orderNrGenerator;
    this.pizzas = pizzas;
    this.localdatetime = now;
  }

  public Order(int orderNr, ArrayList<Integer> pizzas, String now) {
    this.orderNr = orderNr;
    this.pizzas = pizzas;
    this.localdatetime = now;
  }

  public static void orderNumGenerator(int n) {
    orderNrGenerator = n;
  }

  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append(orderNr);
    s.append(",");
    s.append(localdatetime);
    for (int i = 0; i < pizzas.size(); i++) {
      s.append(",");
      s.append(pizzas.get(i));
    }
    return s.toString();
  }

}



