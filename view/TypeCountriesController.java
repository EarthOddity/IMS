package view;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Country;
import model.Row;
import model.Table;

import java.util.ArrayList;

public class TypeCountriesController {

  @FXML
  private Button bSave;

  @FXML
  private TextField country2TF;

  @FXML
  private TextField country1TF;

  @FXML
  private TextField country3TF;

  @FXML
  private TextField country4TF;

  @FXML
  private TextField country5TF;

  @FXML
  private Label labelCountry1;

  @FXML
  private Label labelCountry2;

  @FXML
  private Label labelCountry3;

  @FXML
  private Label labelCountry4;

  @FXML
  private Label labelCountry5;

  private ViewHandler viewHandler;
  private Table model;
  private ObservableList<Row> listRows;



  public void init(ViewHandler viewHandler, Table model)
  {
    this.viewHandler = viewHandler;
    this.model = model;

  }

  @FXML public void bSaveClick()
  {
    ArrayList<Country> countries = new ArrayList<>();
    if (!country1TF.getText().equals(""))
    {
      countries.add(new Country(country1TF.getText()));
    }
    if (!country2TF.getText().equals(""))
    {
      countries.add(new Country(country2TF.getText()));
    }
    if (!country3TF.getText().equals(""))
    {
      countries.add(new Country(country3TF.getText()));
    }
    if (!country4TF.getText().equals(""))
    {
      countries.add(new Country(country4TF.getText()));
    }
    if (!country5TF.getText().equals(""))
    {
      countries.add(new Country(country5TF.getText()));
    }
    model.setCountries(countries);
    viewHandler.setMAScreen(model);
    viewHandler.openView(ViewHandler.GENERATE_MA_TABLE);
  }



}
