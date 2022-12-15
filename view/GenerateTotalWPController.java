package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Country;
import model.CountryToShow;
import model.Table;

public class GenerateTotalWPController
{

    @FXML
    private TableColumn<Country, String> countryColumn;

    @FXML
    private Label labelTWP;

    @FXML
    private TableColumn<CountryToShow, String> totalWPColumn;

    @FXML
    private TableView<?> wpTable;
    @FXML private ViewHandler viewHandler;
    @FXML private Table model;

    public void init(ViewHandler viewHandler, Table model)
    {
        this.viewHandler = viewHandler;
        this.model = model;
    }



}
