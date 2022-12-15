package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Table;

public class CompareCountriesController {

  @FXML
  private Label label1;
  @FXML
  private Label label2;
  @FXML private Label label3;
  @FXML private Label label4;
  @FXML private Label label5;

  private ViewHandler viewHandler;
  private Table model;



  public void init(ViewHandler viewHandler, Table model)
  {
    this.viewHandler = viewHandler;
    this.model = model;
    if (model.getNumberOfCountries() >= 1)
    {
      label1.setText(model.getCountry(0).getCountry());
    }
    if (model.getNumberOfCountries() >= 2)
    {
      label2.setText(model.getCountry(1).getCountry());
    }
    if (model.getNumberOfCountries() >= 3)
    {
      label3.setText(model.getCountry(2).getCountry());
    }
    if (model.getNumberOfCountries() >= 4)
    {
      label4.setText(model.getCountry(3).getCountry());
    }
    if (model.getNumberOfCountries() >= 5)
    {
      label5.setText(model.getCountry(4).getCountry());
    }
  }


}

