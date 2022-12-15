package view;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Table;

public class Main extends Application
{
  @FXML private ViewHandler viewHandler;
  private Table model;
  private Stage stage;

  @Override public void start(Stage primaryStage) throws Exception
  {
    model = generateModel();
    viewHandler = new ViewHandler(primaryStage, model);

  }

  public static void main(String[] args)
  {
    Application.launch(Main.class);
  }

  private Table generateModel()
  {
    Table table = new Table();
    return table;
  }


}
