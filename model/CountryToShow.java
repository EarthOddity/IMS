package model;

public class CountryToShow
{
  private String points;
  private String fact;
  private String weightedPoints;

  public CountryToShow(String points, String fact, String weightedPoints)
  {
    this.points = points;
    this.fact = fact;
    this.weightedPoints = weightedPoints;
  }

  public CountryToShow()
  {

  }

  public void setPoints(String points)
  {
    this.points = points;
  }

  public void setFact(String fact)
  {
    this.fact = fact;
  }

  public void setWeightedPoints(String weightedPoints)
  {
    this.weightedPoints = weightedPoints;
  }

  public String getPoints()
  {
    return points;
  }

  public String getFact()
  {
    return fact;
  }

  public String getWeightedPoints()
  {
    return weightedPoints;
  }
}
