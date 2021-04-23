
public class Pizza {
private int num;
private double price;
private String toppings;
private String name;

public Pizza(int num, String name, String toppings, double price){
  this.num = num;
  this.price = price;
  this.toppings = toppings;
  this.name = name;

  }

  public Pizza(int number) {
  }

  public Pizza() {

  }


  public int getNum(){
  return num;
  }
  public double getPrice (){
  return price;
  }
  public String getIngredients(){
  return toppings;
  }
  public String getName(){
  return name;
  }

  @Override
  public String toString() {
    return "Pizza:" +
        "num: " + num + ", name: " + name + ", toppings: " + toppings + ", price: " + price + "\n";

  }


}
