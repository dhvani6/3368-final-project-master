package edu.uh.tech.cis3368.manufacture.controller;

import edu.uh.tech.cis3368.manufacture.Part;
import edu.uh.tech.cis3368.manufacture.repository.PartRepository;
import edu.uh.tech.cis3368.manufacture.view.FxmlView;
import edu.uh.tech.cis3368.manufacture.view.StageManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

@Controller
public class PartInfoController implements Initializable {

    @FXML
    private TableColumn<Part, String> pName;

    @FXML
    private TableColumn<Part, Integer> pPrice;


    @FXML
    private TableView<Part> partTable;

    @FXML
    private TableColumn<Part, Integer> pId;


    @Lazy
    @Autowired
    StageManager stageManager;

    @Autowired
    PartRepository partRepository;


    ObservableList<Part> partList = FXCollections.observableArrayList();

    private void setColProperties() {
        pId.setCellValueFactory(new PropertyValueFactory<>("partId"));

        pName.setCellValueFactory(new PropertyValueFactory<>("partName"));
        pName.setCellFactory(TextFieldTableCell.forTableColumn());

        pPrice.setCellValueFactory(new PropertyValueFactory<>("partPrice"));

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        partTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        partTable.setEditable(true);
        setColProperties();
        loadPartDetails();
    }
    private void loadPartDetails() {
        partList.clear();
        partList.addAll(findAll());
        partTable.setItems(partList);
    }
    public List<Part> findAll(){
        Iterable<Part> iterable = partRepository.findAll();
        List<Part> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }

    public void delete(ActionEvent actionEvent) {
        List<Part> employee = partTable.getSelectionModel().getSelectedItems();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete selected?");

        Optional<ButtonType> action = alert.showAndWait();

        if(action.get() == ButtonType.OK)  partRepository.deleteAll(employee);
        loadPartDetails();
    }

    public void back(ActionEvent actionEvent) { stageManager.switchScene(FxmlView.MENU);
    }
}