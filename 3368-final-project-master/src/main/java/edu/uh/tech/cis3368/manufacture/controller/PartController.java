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
public class PartController implements Initializable {

    @FXML
    private TextField partName;

    @FXML
    private TextField partPrice;



    @Lazy
    @Autowired
    StageManager stageManager;
    @Autowired
    PartRepository partRepository;



    public String getPartName(){return partName.getText();}
    public Integer getPartPrice(){return Integer.parseInt(partPrice.getText());}



    @Override
    public void initialize(URL location, ResourceBundle resources) { }



    public void save(ActionEvent actionEvent) {
        Part part = new Part();
        part.setPartName(getPartName());
        part.setPartPrice(getPartPrice());
        partRepository.save(part);
        stageManager.switchScene(FxmlView.PARTINFO);

    }


    public void back(ActionEvent actionEvent) {
        stageManager.switchScene(FxmlView.MENU);

    }
}