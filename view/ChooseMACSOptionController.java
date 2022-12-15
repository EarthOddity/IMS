package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import model.Table;

public class ChooseMACSOptionController
{
  @FXML
  private AnchorPane choiceAnchorPane;

  @FXML
  private Button doBothButton;

  @FXML
  private Button doCSButton;

  @FXML
  private Button doMAButton;

  @FXML private ViewHandler viewHandler;
  @FXML private Table model;

  public void init(ViewHandler viewHandler, Table model)
  {
    this.viewHandler = viewHandler;
    this.model = model;
  }

  @FXML public void onDoMAButtonClick()
  {
    viewHandler.openView(ViewHandler.GENERATE_MA_TABLE);
  }

  @FXML public void onDoCSButtonClick()
  {
    viewHandler.openView(ViewHandler.GENERATE_CS_TABLE);
  }

  public void onDoBothButtonClick()
  {

  }

}
