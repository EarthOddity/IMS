package model;

import java.util.ArrayList;

public class Table
{
  private ArrayList<Factor> factors;
  private ArrayList<Country> countries;
  private ArrayList<Double> weight;
  private ArrayList<Row> rows;
  private double totalWeight;

  public Table()
  {
    countries= new ArrayList<>();
    factors = new ArrayList<>();
    weight = new ArrayList<>();
    rows = new ArrayList<>();
  }


  public int getNumberOfCountries()
  {
    return countries.size();
  }

  public void setCountry(Country name)
  {
    countries.add(name);
  }

  public Country getCountry(int index)
  {
    return countries.get(index);
  }

  public void setWeight(double weight, int index)
  {
    this.weight.set(index, weight);
  }


  public double getWeight(int index)
  {
    return weight.get(index);
  }

  public void addFactor(Factor factor)
  {
    for(int i = 0; i < countries.size(); i++)
    {
      countries.get(i).setNumberOfFactors();
    }
    weight.add(0.0);
    factors.add(factor);
  }

  public int getNumberOfFactors()
  {
    return factors.size();
  }

  public Factor getFactor(int index)
  {
    return factors.get(index);
  }


  public double getWeightedPointsForCountry(int index)
  {
    double sum = 0;
    for(int i = 0; i < factors.size(); i++)
    {
      sum+=countries.get(index).getWeightedPoints(weight.get(i), i);
    }
    return sum;
  }


  public int getNumberOfRows()
  {
    return rows.size();
  }

  public double addAllWeights()
  {
    double sum=0;
      for (int i = 0; i < weight.size(); i++)
      {
        sum += getWeight(i);
      }
    this.totalWeight = sum;
    return sum;
  }

  public double getTotalWeight()
  {
    return totalWeight;
  }

  public boolean checkTotalWeight(double totalWeight)
  {
    return (this.totalWeight+totalWeight <= 100);
  }

  public void setCountries(ArrayList<Country> countries)
  {
    this.countries = countries;
  }

}
