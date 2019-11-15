import java.util.Arrays;
import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
  }
  public static double [] pricer(Strong []types)
  {
    double []prices=new double[types.length];
    double CATS=15;
    double DOGS = CATS*2;
    double MICE= CATS/3;
    double PONY= CATS*5;
    double SNAKES = MICE*4;
    for(int i=0;i<types.length;++i)
    {
      String animal=types[i];
      switch(animal)
      {
        case "cats":prices[i]=CATS;
                    break;
        case "dogs":prices[i]=DOGS;
                    break;
        case "mice":prices[i]=MICE;
                    break;
        case "pony":prices[i]=PONY;
                    break;
        case "snakes":prices[i]=SNAKES;
                      break;
        
      }
    }
  }
}