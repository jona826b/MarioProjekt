import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
  int orderNr;
  ArrayList<Integer> pizzas;
  String localdatetime;

  public Order(int orderNr, ArrayList<Integer> pizzas, String now) {
    this.orderNr = orderNr;
    this.pizzas = pizzas;
    this.localdatetime = now;
  }
  public String toString(){
    StringBuilder s = new StringBuilder();
    s.append(orderNr);
    s.append(",");
    s.append(localdatetime);
    for (int i = 0; i < pizzas.size(); i++){
      s.append(",");
      s.append(pizzas.get(i));
    }
    // 1, 1 jan, 2, 3
    return s.toString();
  }


  public void createOrder(){

  }

  }



