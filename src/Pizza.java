
public class Pizza {
private int num;
private double price;
private String ingredients;
private String name;

public Pizza(int num, String name, String ingredients, double price){
  this.num = num;
  this.price = price;
  this.ingredients = ingredients;
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
  return ingredients;
  }
  public String getName(){
  return name;
  }

}
