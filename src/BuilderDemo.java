/*
Class <code>Builder</code> implements an example of the Behavioral Design Pattern Builder pattern.

Please note that the comments in this file and the structure are not good java practices.
The usage of the java-sources are to demonstrate the Builder pattern and not java coding.
Used are:
= Type ---- Name ------------ Implements ---------
* Class     BuilderDemo       Demo usage of the Builder Pattern.
* Class     MealDirector      Director which embeds the instance of the Builder
* Class     MealBuilder       Abstract Builder called by the BuilderDemo
* Class     KidsMealBuilder   Implemented Builder for Kid meals.
* Class     AdultMealBuilder  Implemented Builder for Adult meals.
* Class     Meal              PoJo for the build-result 'meal'.
*
*
* The example uses a simplified (unrealistic).
*
* All classes are placed in this single file for simplicity and ease of usage.
*
* See the documentation on https://www.harmfrielink.nl/wiki/index.php/Builder_(Pattern)
*/


/**
 * The Demo for calling the Client-Classes that implements the Builder pattern.
 */
public class BuilderDemo {
   public static void main(String[] args) {
      // Placeholder for the Director.
      MealDirector director = new MealDirector();

      // PlaceHolder for the builder
      MealBuilder builder = null;

      boolean isKid = false;

      if (isKid) {
         builder = new KidsMealBuilder();
      } else {
         builder = new AdultMealBuilder();
      }

      // Gets the correct meal.
      Meal meal = director.createMeal(builder);

      System.out.printf("%s\n", meal.toString());
   }  // main
}  // class BuilderDemo

/**
 * Class <code>Builder</code> defines the abstract class.
 */
abstract class MealBuilder {
   // Placeholder for the meal.
   protected Meal meal = new Meal();

   /** Builds the Drink. */
   public abstract void buildDrink();

   /** Builds the Main-dish.  */
   public abstract void buildMain();
   public abstract void buildDessert();
   public abstract Meal getMeal();
}  // MealBuilder

/**
 * Class <code>KidsMealBuilder</code> implements the MealBuilder for kid-meals.
 */
class KidsMealBuilder extends MealBuilder {
   public void buildDrink() {
      // add drinks to the meal
      meal.setDrink("Yoghi-drink");
   }

   public void buildMain() {
      // add main part of the meal
      meal.setMain("Fish and Chips");
   }

   public void buildDessert() {
      // add dessert part to the meal
      meal.setDessert("Ice-cream");
   }
   public Meal getMeal() {
      return meal;
   }
}  // class KidsMealBuilder

/**
 * Class <code>AdultMealBuilder</code> implements the MealBuilder for adult-meals.
 */
class AdultMealBuilder extends MealBuilder {

   public void buildDrink(){
      // add drinks to the meal
      meal.setDrink("Red wine");
   }

   public void buildMain(){
      // add main part of the meal
      meal.setMain("Ris de Veau");
   }

   public void buildDessert(){
      // add dessert part to the meal
      meal.setDessert("Panna Cotta");
   }
   public Meal getMeal() {
      return meal;
   }
}  // class AdultMealBuilder

/**
 * Director
 */
class MealDirector {
   /**
    * Creates the meal
    * @param  builder Instance of the Builder
    * @return         Instance of the PoJo class containing the build-data.
    */
   public Meal createMeal(MealBuilder builder) {
      builder.buildDrink();
      builder.buildMain();
      builder.buildDessert();
      return builder.getMeal();
   }
}  // Class MealDirector

/**
 * Class <code>Meal</code> implements the PoJo for the meal assembly.
 */
class Meal {
   private String drink;
   private String main;
   private String dessert;

   public void setDrink(String newDrink) {
      drink = newDrink;
   }  // setDrink

   public void setMain(String newMain) {
      main = newMain;
   }  // setMain

   public void setDessert(String newDessert) {
      dessert = newDessert;
   }  // setDessert

   public String toString() {
      return String.format("Drink: %s, Main: %s, Dessert: %s",
         drink, main, dessert);
   }  // toString
}  // class Meal
