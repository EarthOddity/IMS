package model;

import java.util.ArrayList;

public class Row
{

  private String weight;
  private String factor;
  private ArrayList<CountryToShow> countries;
  private double weightedPoints;

  public double getWeightedPoints()
  {
    return weightedPoints;
  }

  public void setWeightedPoints(double weightedPoints)
  {
    this.weightedPoints = weightedPoints;
  }

  public ArrayList<CountryToShow> getCountries()
  {
    return countries;
  }

  public void setCountries(ArrayList<CountryToShow> countries)
  {
    this.countries = countries;
  }

  public String getWeight()
  {
    return weight;
  }

  public void setWeight(String weight)
  {
    this.weight = weight;
  }

  public String getFactor()
  {
    return factor;
  }

  public Row(String weight, String factor, ArrayList<CountryToShow> countries)
  {
    this.weight = weight;
    this.factor = factor;
    this.countries = countries;
    this.weightedPoints = weightedPoints;
  }




}
