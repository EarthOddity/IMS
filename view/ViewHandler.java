package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Table;

import java.io.IOException;

public class ViewHandler
{

  private Stage primaryStage;
  private Table model;
  private Scene startIMS;
  private Scene generateCSTable;
  private Scene generateMATable;
  private Scene typeCountries;
  private Scene compareCountries;
  private Scene macsGraph;
  private Scene endingThanks;
  private StartIMSController startIMSController;
  private GenerateCSTableController generateCSTableController;
  private TypeCountriesController typeCountriesController;
  private GenerateMATableController generateMATableController;
  private CompareCountriesController compareCountriesController;
  private EndingThanksController endingThanksController;
  private MACSgraphController macsGraphController;

  public static final String START_IMS = "start IMS";
  public static final String GENERATE_MA_TABLE = "generate MA table";
  public static final String GENERATE_CS_TABLE = "generate CS table";
  public static final String TYPE_COUNTRIES = "type countries";
  public static final String COMPARE_COUNTRIES = "compare countries";
  public static final String MACS_GRAPH = "macs graph";
  public static final String ENDING_THANKS = "ending thanks";



  public ViewHandler(Stage primaryStage, Table model)
  {
    this.primaryStage = primaryStage;
    this.model = model;

    FXMLLoader loader = new FXMLLoader();

    loader.setLocation(getClass().getResource("StartIMS.fxml"));

    try {
      startIMS = new Scene(loader.load());
      startIMSController = loader.getController();
      startIMSController.init(this, model);
    }
    catch (IOException e)
    {
      System.out.println("Failed to load StartIMS.fxml");
      System.exit(1);
    }

    loader = new FXMLLoader();

    loader.setLocation(getClass().getResource("TypeCountries.fxml"));

    try {
      typeCountries = new Scene(loader.load());
      typeCountriesController = loader.getController();
      typeCountriesController.init(this, model);
    }
    catch (IOException e)
    {
      System.out.println("Failed to load TypeCountries.fxml");
      System.exit(1);
    }

    loader = new FXMLLoader();

    loader.setLocation(getClass().getResource("GenerateMATable.fxml"));

    try {
      generateMATable = new Scene(loader.load());
      generateMATableController = loader.getController();
      generateMATableController.init(this, model);
    }
    catch (IOException e)
    {
      System.out.println("Failed to load GenerateMATable.fxml");
      System.exit(1);
    }

    loader = new FXMLLoader();

    loader.setLocation(getClass().getResource("GenerateCSTable.fxml"));

    try {
      generateCSTable = new Scene(loader.load());
      generateCSTableController = loader.getController();
      generateCSTableController.init(this, model);
    }
    catch (IOException e)
    {
      System.out.println("Failed to load GenerateCSTable.fxml");
      System.exit(1);
    }

    loader = new FXMLLoader();

    loader.setLocation(getClass().getResource("CompareCountries.fxml"));

    try {
      compareCountries = new Scene(loader.load());
      compareCountriesController = loader.getController();
      compareCountriesController.init(this, model);
    }
    catch (IOException e)
    {
      System.out.println("Failed to load CompareCountries.fxml");
      System.exit(1);
    }

    loader = new FXMLLoader();

    loader.setLocation(getClass().getResource("MACSgraph.fxml"));

    try {
      macsGraph = new Scene(loader.load());
      macsGraphController = loader.getController();
      macsGraphController.init(this, model);
    }
    catch (IOException e)
    {
      System.out.println("Failed to load MACSgraph.fxml");
      System.exit(1);
    }

    loader = new FXMLLoader();

    loader.setLocation(getClass().getResource("EndingThanks.fxml"));

    try {
      endingThanks = new Scene(loader.load());
      endingThanksController = loader.getController();
      endingThanksController.init(this, model);
    }
    catch (IOException e)
    {
      System.out.println("Failed to load EndingThanks.fxml");
      System.exit(1);
    }

    openView(START_IMS);

  }

  public void setMAScreen(Table model){
    FXMLLoader loader = new FXMLLoader();
    this.model = model;

  loader.setLocation(getClass().getResource("GenerateMATable.fxml"));

  try {
    generateMATable = new Scene(loader.load());
    generateMATableController = loader.getController();
    generateMATableController.init(this, model);
  }
  catch (IOException e)
  {
    System.out.println("Failed to load GenerateMATable.fxml");
    System.exit(1);
  }
}


  public void openView(String sceneName)
  {
    switch (sceneName)
    {
      case START_IMS:
        primaryStage.setTitle("Intro");
        primaryStage.setScene(startIMS);
        primaryStage.show();
      break;
      case TYPE_COUNTRIES:
        primaryStage.setTitle("Choose");
        primaryStage.setScene(typeCountries);
        primaryStage.show();
        break;
      case GENERATE_MA_TABLE:
        primaryStage.setTitle("Market Attractiveness");
        primaryStage.setScene(generateMATable);
        primaryStage.show();
      break;
      case GENERATE_CS_TABLE:
        primaryStage.setTitle("Competitive Strengths");
        primaryStage.setScene(generateCSTable);
        primaryStage.show();
        break;
      case COMPARE_COUNTRIES:
        primaryStage.setTitle("Compare countries");
        primaryStage.setScene(compareCountries);
        primaryStage.show();
        break;
      case MACS_GRAPH:
        primaryStage.setTitle("Total weighted points");
        primaryStage.setScene(macsGraph);
        primaryStage.show();
        break;
      case ENDING_THANKS:
        primaryStage.setTitle("The End");
        primaryStage.setScene(endingThanks);
        primaryStage.show();
        break;
      default:
        throw new IllegalArgumentException("Unknown view: " + sceneName);
    }
  }



}
