package model;

public class TableTest
{
  public static void main(String[] args)
  {
    Country country1 = new Country("Spain");
    Country country2 = new Country("Slovakia");

    Factor factor = new Factor("Market size: ");
    Factor factor2 = new Factor("GDP growth: ");

    Table table = new Table();

    table.setCountry(country1);
    table.setCountry(country2);
    table.addFactor(factor);
    table.addFactor(factor2);
    table.setWeight(15,0);
    table.setWeight(10, 1);
    table.getCountry(0).setFact ( "300");
    table.getCountry(0).setFact( "5000");
    table.getCountry(1).setFact( "400");
    table.getCountry(1).setFact( "800");
    table.getCountry(0).setPoints(3);
    table.getCountry(0).setPoints(2);
    table.getCountry(1).setPoints(3);
    table.getCountry(1).setPoints(5);


    System.out.println("The weighted points for " + country1.getCountry() +  " are: " + table.getWeightedPointsForCountry(0));
    System.out.println("The weighted points for " + country2.getCountry() +  " are: " + table.getWeightedPointsForCountry(1));
    System.out.println(country1.getCountry() + " has " + country1.getPoints(0) + " points for " + country1.getFact(0));


  }
}
