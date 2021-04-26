
public class Pizza {
  private int num;
  private double price;
  private String toppings;
  private String name;

  public Pizza(int num, String name, String toppings, double price) {
    this.num = num;
    this.price = price;
    this.toppings = toppings;
    this.name = name;

  }

  @Override
  public String toString() {
    return "Pizza:" +
        "num: " + num + ", name: " + name + ", toppings: " + toppings + ", price: " + price + "\n";

  }


}
