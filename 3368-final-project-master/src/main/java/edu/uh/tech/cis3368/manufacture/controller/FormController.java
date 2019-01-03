package edu.uh.tech.cis3368.manufacture.controller;

import edu.uh.tech.cis3368.manufacture.Customerss;
import edu.uh.tech.cis3368.manufacture.repository.CustomerssRepository;
import edu.uh.tech.cis3368.manufacture.view.FxmlView;
import edu.uh.tech.cis3368.manufacture.view.StageManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;


@Controller
public class FormController implements Initializable {
    @FXML
    private TextField lNameField;

    @FXML
    private TextField fNameField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private ComboBox<String> statusField;

    @FXML
    private TextField priceField;

    @FXML
    private TextArea descriptionField;

    @FXML
    private Label idOfProject;

    @FXML
    private TextField addressField;

    @Lazy
    @Autowired
    StageManager stageManager;
    @Autowired
    CustomerssRepository customerssRepository;

    private ObservableList<String> statusList = FXCollections.observableArrayList("pre-production", "production", "post-production");

    public String getfNameText(){return fNameField.getText();}
    public String getlNameText(){return lNameField.getText();}
    public String getPhoneNumberText(){return phoneNumberField.getText();}
    public Integer getPriceText(){return Integer.parseInt(priceField.getText());}
    public String getDesciptionText(){return descriptionField.getText();}
    public String getAddressText(){return addressField.getText();}
    public String getStatusText(){return statusField.getSelectionModel().getSelectedItem();}



    public void back(ActionEvent actionEvent) { stageManager.switchScene(FxmlView.MENU);}

    @Override
    public void initialize(URL location, ResourceBundle resources) { statusField.setItems(statusList);

    }

    public void save(ActionEvent actionEvent) {
        Customerss customer = new Customerss();
        customer.setCustFirstName(getfNameText());
        customer.setCustLastName(getlNameText());
        customer.setCustPhoneNumber(getPhoneNumberText());
        customer.setCustAddress(getAddressText());
        customer.setCustPrice(getPriceText());
        customer.setCustDescription(getDesciptionText());
        customer.setCustStatus(getStatusText());

        customerssRepository.save(customer);
        stageManager.switchScene(FxmlView.CUSTOMERINFO);



    }

    public void clear(ActionEvent actionEvent) {
        fNameField.clear();
        lNameField.clear();
        phoneNumberField.clear();
        priceField.clear();
        descriptionField.clear();
        addressField.clear();
        statusField.getSelectionModel().clearSelection();
    }
}
