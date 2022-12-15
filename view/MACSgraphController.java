package view;

import javafx.fxml.FXML;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import model.Table;

public class MACSgraphController {

    @FXML
    private NumberAxis csAxis;

    @FXML
    private AnchorPane endResultPane;

    @FXML
    private NumberAxis maAxis;

    @FXML
    private BubbleChart<Number, Number> macsGraph;

  private ViewHandler viewHandler;
  private Table model;



  public void init(ViewHandler viewHandler, Table model)
  {
    this.viewHandler = viewHandler;
    this.model = model;
    maAxis = new NumberAxis();
    csAxis = new NumberAxis();
    macsGraph = new BubbleChart<>(csAxis, maAxis);
    XYChart.Series country1 = new XYChart.Series<>();
    XYChart.Series country2 = new XYChart.Series<>();
    XYChart.Series country3 = new XYChart.Series<>();
    XYChart.Series country4 = new XYChart.Series<>();
    XYChart.Series country5 = new XYChart.Series<>();
    if(model.getNumberOfCountries() >= 1)
    {
      country1.getData().add(model.getWeightedPointsForCountry(0));
      macsGraph.getData().addAll(country1);
    }
    if(model.getNumberOfCountries() >= 2)
    {
      country1.getData().add(model.getWeightedPointsForCountry(0));
      country2.getData().add(model.getWeightedPointsForCountry(1));
      macsGraph.getData().addAll(country1, country2);
    }
    if(model.getNumberOfCountries() >= 3)
    {
      country1.getData().add(model.getWeightedPointsForCountry(0));
      country2.getData().add(model.getWeightedPointsForCountry(1));
      country3.getData().add(model.getWeightedPointsForCountry(2));
      macsGraph.getData().addAll(country1, country2, country3);
    }
    if(model.getNumberOfCountries() >= 4)
    {
      country1.getData().add(model.getWeightedPointsForCountry(0));
      country2.getData().add(model.getWeightedPointsForCountry(1));
      country3.getData().add(model.getWeightedPointsForCountry(2));
      country4.getData().add(model.getWeightedPointsForCountry(3));
      macsGraph.getData().addAll(country1, country2, country3, country4);
    }
    if(model.getNumberOfCountries() >= 5)
    {
      country1.getData().add(model.getWeightedPointsForCountry(0));
      country2.getData().add(model.getWeightedPointsForCountry(1));
      country3.getData().add(model.getWeightedPointsForCountry(2));
      country4.getData().add(model.getWeightedPointsForCountry(3));
      country5.getData().add(model.getWeightedPointsForCountry(4));
      macsGraph.getData().addAll(country1, country2, country3, country4, country5);
    }

  }

}
