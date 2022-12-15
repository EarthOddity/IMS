package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import model.Table;

public class EndingThanksController {

    @FXML
    private Label labelMangeTak;

    @FXML
    private AnchorPane thanksPane;
  @FXML private ViewHandler viewHandler;
  @FXML private Table model;

  public void init(ViewHandler viewHandler, Table model)
  {
    this.viewHandler = viewHandler;
    this.model = model;
  }




}
