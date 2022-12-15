package model;

import java.util.ArrayList;

public class Country
{
  private String name;
  private ArrayList<Double> points;
  private ArrayList<String> fact;
  private ArrayList<Double> weightedPoints;
  private int numberOfFactors;
  private int test;



  public Country(String name)
  {
    points = new ArrayList<>();
    fact = new ArrayList<>();
    weightedPoints = new ArrayList<>();
    this.name = name;
    this.numberOfFactors = 0;
  }

  public int getSizeOfPoints(){
    return points.size();
  }

  public int getSizeOfFact(){
    return fact.size();
  }


  public void setCountry(String name)
  {
    this.name = name;
  }

  public String getCountry()
  {
    return name;
  }

  public void setFact(String fact)
  {
      this.fact.add(fact);
  }

  public void setNumberOfFactors()
  {
    this.numberOfFactors++;
  }

  public String getFact(int index)
  {
    return fact.get(index);
  }

  public void setPoints(double points)
  {
      this.points.add(points);
  }

  public double getPoints(int index)
  {
    return points.get(index);
  }

  public boolean checkPoints(int index)
  {
    return (points.get(index) <= 5 && points.get(index) >=0);
  }

  public double calculateWeightedPoints(double weight, double points)
  {
    return (weight/100)*points;
  }

  public double getWeightedPoints(double weight, int index)
  {
    return calculateWeightedPoints(weight, getPoints(index));
  }

  public double sumWeightedPoints(double weight)
  {
    int sum = 0;
    for(int i=0; i < points.size(); i++)
    {
      sum+=getWeightedPoints(weight, i);
    }
    return sum;
  }

  public boolean equals(Object obj)
  {
    if (obj == null )
      return false;
    if (!(obj instanceof Country))
      return false;
    Country other = (Country) obj;
    return numberOfFactors == other.numberOfFactors && name.equals(other.name)
        && fact.equals(other.fact) && weightedPoints.equals(other.weightedPoints);
  }

}
