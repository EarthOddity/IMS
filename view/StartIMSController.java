package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import model.Table;

public class StartIMSController {

  @FXML
  private Button bNo;

  @FXML
  private Button bYes;

  @FXML
  private Label labelQStart;

  @FXML
  private AnchorPane startIMS;

  @FXML private ViewHandler viewHandler;
  @FXML private Table model;

  public void init(ViewHandler viewHandler, Table model)
  {
    this.viewHandler = viewHandler;
    this.model = model;
  }

    @FXML public void handleYesButtonClick()
    {
      viewHandler.openView(ViewHandler.TYPE_COUNTRIES);
    }

    @FXML public void handleNoButtonClick()
    {
      viewHandler.openView(ViewHandler.ENDING_THANKS);
    }


}
