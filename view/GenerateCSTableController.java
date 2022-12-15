package view;

import model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class GenerateCSTableController {

  @FXML
  private Button bAddFact;

  @FXML
  private Button bAddFactor;

  @FXML
  private Button bAddPoints;

  @FXML
  private Button bAddWeight;

  @FXML
  private Button bCompareCountries;

  @FXML
  private Button bGetWeightedPoints;

  @FXML
  private TableColumn<Country, Integer> countries;

  @FXML
  private TableColumn<Country, String> country1;

  @FXML
  private TableColumn<Country, String> country2;

  @FXML
  private TableColumn<Country, String> country3;

  @FXML
  private TableColumn<Country, String> country4;

  @FXML
  private TableColumn<Country, String> country5;

  @FXML
  private TableColumn<Row, String> fact1;

  @FXML
  private TableColumn<Row, String> fact2;

  @FXML
  private TableColumn<Row, String> fact3;

  @FXML
  private TableColumn<Row, String> fact4;

  @FXML
  private TableColumn<Row, String> fact5;

  @FXML
  private TextField factTextField;

  @FXML
  private TableColumn<Row, String> factor;

  @FXML
  private TextField factorTextField;

  @FXML
  private Label labelFact;

  @FXML
  private Label labelFactor;

  @FXML
  private Label labelMA;

  @FXML
  private Label labelPoints;

  @FXML
  private Label labelWeight;

  @FXML
  private TableColumn<Row, String> points1;

  @FXML
  private TableColumn<Row, String> points2;

  @FXML
  private TableColumn<Row, String> points3;

  @FXML
  private TableColumn<Row, String> points4;

  @FXML
  private TableColumn<Row, String> points5;

  @FXML
  private TextField pointsTextField;

  @FXML
  private AnchorPane tablePane;

  @FXML
  private TableColumn<Row, String> weight;

  @FXML
  private TextField weightTextField;

  @FXML
  private TableColumn<Row, String> weightedPoints1;

  @FXML
  private TableColumn<Row, String> weightedPoints2;

  @FXML
  private TableColumn<Row, String> weightedPoints3;

  @FXML
  private TableColumn<Row, String> weightedPoints4;

  @FXML
  private TableColumn<Row, String> weightedPoints5;

  @FXML private TableView<Row> tableCS;

  private ViewHandler viewHandler;
  private Table model;
  private ObservableList<Row> listRows;



  public void init(ViewHandler viewHandler, Table model)
  {
    this.viewHandler = viewHandler;
    this.model = model;
    bAddWeight.setVisible(false);
    bAddFact.setVisible(false);
    bAddPoints.setVisible(false);
    listRows =  FXCollections.observableArrayList();
    generateRows(false);
    factor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFactor()));
    weight.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getWeight()));
    if(model.getNumberOfCountries() >= 1)
    {
      fact1.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCountries().get(0).getFact()));
      points1.setCellValueFactory(cellData -> new SimpleStringProperty((cellData.getValue().getCountries().get(0).getPoints())));
      weightedPoints1.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCountries().get(0).getWeightedPoints()));
      country1.setText(model.getCountry(0).getCountry());
    }
    if(model.getNumberOfCountries() >= 2)
    {
      fact2.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCountries().get(1).getFact()));
      points2.setCellValueFactory(cellData -> new SimpleStringProperty((cellData.getValue().getCountries().get(1).getPoints())));
      weightedPoints2.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCountries().get(1).getWeightedPoints()));
      country2.setText(model.getCountry(1).getCountry());
    }
    if(model.getNumberOfCountries() >= 3)
    {
      fact3.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCountries().get(2).getFact()));
      points3.setCellValueFactory(cellData -> new SimpleStringProperty((cellData.getValue().getCountries().get(2).getPoints())));
      weightedPoints3.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCountries().get(2).getWeightedPoints()));
      country3.setText(model.getCountry(2).getCountry());
    }
    if(model.getNumberOfCountries() >= 4)
    {
      fact4.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCountries().get(3).getFact()));
      points4.setCellValueFactory(cellData -> new SimpleStringProperty((cellData.getValue().getCountries().get(3).getPoints())));
      weightedPoints4.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCountries().get(3).getWeightedPoints()));
      country4.setText(model.getCountry(3).getCountry());
    }
    if(model.getNumberOfCountries() >= 5)
    {
      fact5.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCountries().get(4).getFact()));
      points5.setCellValueFactory(cellData -> new SimpleStringProperty((cellData.getValue().getCountries().get(4).getPoints())));
      weightedPoints5.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCountries().get(4).getWeightedPoints()));
      country5.setText(model.getCountry(4).getCountry());
    }
    tableCS.setItems(listRows);

  }

  @FXML public void bAddFactorButtonClick()
  {
    model.addFactor(new Factor(setFactorName()));
    generateRows(false);
    bAddFactor.setVisible(false);
    bAddWeight.setVisible(true);
    bAddFact.setVisible(false);
    bAddPoints.setVisible(false);
    factorTextField.clear();
  }

  @FXML public void bAddWeightButtonClick()
  {
    model.addAllWeights();
    if(model.checkTotalWeight(Double.parseDouble(weightTextField.getText())))
    {
      model.setWeight(Double.parseDouble(weightTextField.getText()), (model.getNumberOfFactors() - 1));
      generateRows(false);
      bAddFactor.setVisible(false);
      bAddWeight.setVisible(false);
      bAddFact.setVisible(true);
      bAddPoints.setVisible(false);
      weightTextField.clear();
    }
  }

  public void bAddFactButtonClick()
  {
    boolean go = true;
    for(int i = 0; i < model.getNumberOfCountries(); i++)
    {
      if(model.getCountry(i).getSizeOfFact() < model.getNumberOfFactors() && go)
      {
        model.getCountry(i).setFact(factTextField.getText());
        go = false;
      }
    }
    generateRows(false);
    bAddFactor.setVisible(false);
    bAddWeight.setVisible(false);
    bAddFact.setVisible(false);
    bAddPoints.setVisible(true);
    factTextField.clear();
  }

  public void bAddPointsButtonClick()
  {
    boolean go = true;
    for(int i = 0; i < model.getNumberOfCountries(); i++)
    {
      if(model.getCountry(i).getSizeOfPoints() < model.getNumberOfFactors() && go)
      {
        model.getCountry(i).setPoints(Double.parseDouble(pointsTextField.getText()));
        go = false;
      }
    }
    generateRows(false);
    if(model.getCountry(model.getNumberOfCountries()-1).getSizeOfPoints() == model.getNumberOfFactors()){
      bAddFactor.setVisible(true);
      bAddFact.setVisible(false);
    }
    else{
      bAddFactor.setVisible(false);
      bAddFact.setVisible(true);
    }
    bAddWeight.setVisible(false);
    bAddPoints.setVisible(false);
    pointsTextField.clear();
  }

  @FXML public String setFactorName()
  {
    String factorName = factorTextField.getText();
    return factorName;
  }


  public void generateRows(boolean finalRow){
    listRows.clear();
    String weight;
    for(int i = 0; i < model.getNumberOfFactors(); i++)
    {
      if (model.getWeight(i) == 0)
      {
        weight = "";
      }
      else
      {
        weight = String.valueOf(model.getWeight(i));
      }
      ArrayList<CountryToShow> countryToShows = new ArrayList<>();
      for(int iCountry = 0; iCountry < model.getNumberOfCountries(); iCountry++)
      {
        countryToShows.add(new CountryToShow());
        if (model.getCountry(iCountry).getSizeOfPoints() >= (i+1))
        {
          countryToShows.get(iCountry).setPoints(String.valueOf(model.getCountry(iCountry).getPoints(i)));
        }
        if (model.getCountry(iCountry).getSizeOfFact() >= (i+1))
        {
          countryToShows.get(iCountry).setFact(model.getCountry(iCountry).getFact(i));
        }
        if (model.getCountry(iCountry).getSizeOfFact() >= (i+1) && model.getCountry(iCountry).getSizeOfPoints() >= (i+1))
        {
          countryToShows.get(iCountry).setWeightedPoints(String.valueOf(model.getCountry(iCountry).getWeightedPoints(model.getWeight(i), i)));
        }
      }
      listRows.add(new Row(weight, model.getFactor(i).getFactorName(), countryToShows));
    }
    if(finalRow)
    {
      ArrayList<CountryToShow> countryToShows = new ArrayList<>();
      int i1;
      for (i1 = 0; i1 < model.getNumberOfCountries(); i1++)
      {
        CountryToShow country = new CountryToShow();
        country.setWeightedPoints(String.valueOf(model.getWeightedPointsForCountry(i1)));
        countryToShows.add(country);

      }
      listRows.add(new Row(null, "Total", countryToShows));
    }

  }

  public void bGenerateEndResultClick()
  {
    viewHandler.openView(ViewHandler.MACS_GRAPH);
  }

  public void bGetWeightedPointsButtonClick()
  {
    if (model.addAllWeights() == 100.0)
    {
      generateRows(true);
    }
  }





}
