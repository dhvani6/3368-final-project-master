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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.*;

@Controller
public class CustomerInfoController implements Initializable {
    @FXML
    private TableColumn<Customerss, String> colPhoneNumber;

    @FXML
    private TableColumn<Customerss, String> colfName;

    @FXML
    private TableColumn<Customerss, String> colAddress;

    @FXML
    private TableView<Customerss> customerTable;

    @FXML
    private TableColumn<Customerss, Integer> colPrice;

    @FXML
    private TableColumn<Customerss, String> colDescription;

    @FXML
    private TableColumn<Customerss, Integer> colId;

    @FXML
    private TableColumn<Customerss, String> collName;

    @FXML
    private TableColumn<Customerss, String> colEmail;

    @FXML
    private TableColumn<Customerss, String> colStatus;

    @Lazy
    @Autowired
    StageManager stageManager;

    @Autowired
    CustomerssRepository customerssRepository;

    ObservableList<Customerss> customerList = FXCollections.observableArrayList();

    private void setColProperties(){
        colId.setCellValueFactory(new PropertyValueFactory<>("customerId"));

         colfName.setCellValueFactory(new PropertyValueFactory<>("custFirstName"));
         colfName.setCellFactory(TextFieldTableCell.forTableColumn());

          collName.setCellValueFactory(new PropertyValueFactory<>("custLastName"));
          collName.setCellFactory(TextFieldTableCell.forTableColumn());

           colEmail.setCellValueFactory(new PropertyValueFactory<>("custEmail"));
           colEmail.setCellFactory(TextFieldTableCell.forTableColumn());

            colAddress.setCellValueFactory(new PropertyValueFactory<>("custAddress"));
            colAddress.setCellFactory(TextFieldTableCell.forTableColumn());

             colPrice.setCellValueFactory(new PropertyValueFactory<>("custPrice"));


              colPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("custPhoneNumber"));
              colPhoneNumber.setCellFactory(TextFieldTableCell.forTableColumn());

               colStatus.setCellValueFactory(new PropertyValueFactory<>("custStatus"));
               colStatus.setCellFactory(TextFieldTableCell.forTableColumn());

                colDescription.setCellValueFactory(new PropertyValueFactory<>("custDescription"));
                colDescription.setCellFactory(TextFieldTableCell.forTableColumn());

                loadCustomerDetails();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        customerTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        customerTable.setEditable(true);
        setColProperties();
        loadCustomerDetails();

    }

    @FXML
    void updateFName(TableColumn.CellEditEvent update) {
        Customerss customerEdit = customerTable.getSelectionModel().getSelectedItem();
        customerEdit.setCustFirstName(update.getNewValue().toString());
        Customerss customer = customerssRepository.findByCustomerId(customerEdit.getCustomerId());
        customer.setCustFirstName(customerEdit.getCustFirstName());
        customerssRepository.save(customer);

    }

    @FXML
    void updateLName(TableColumn.CellEditEvent update) {
        Customerss customerEdit = customerTable.getSelectionModel().getSelectedItem();
        customerEdit.setCustLastName(update.getNewValue().toString());
        Customerss customer = customerssRepository.findByCustomerId(customerEdit.getCustomerId());
        customer.setCustLastName(customerEdit.getCustFirstName());
        customerssRepository.save(customer);

    }

    @FXML
    void updateEmail(TableColumn.CellEditEvent update) {
        Customerss customerEdit = customerTable.getSelectionModel().getSelectedItem();
        customerEdit.setCustEmail(update.getNewValue().toString());
        Customerss customer = customerssRepository.findByCustomerId(customerEdit.getCustomerId());
        customer.setCustEmail(customerEdit.getCustFirstName());
        customerssRepository.save(customer);

    }

    @FXML
    void updateAddress(TableColumn.CellEditEvent update) {
        Customerss customerEdit = customerTable.getSelectionModel().getSelectedItem();
        customerEdit.setCustAddress(update.getNewValue().toString());
        Customerss customer = customerssRepository.findByCustomerId(customerEdit.getCustomerId());
        customer.setCustAddress(customerEdit.getCustFirstName());
        customerssRepository.save(customer);

    }

    @FXML
    void updateStatus(TableColumn.CellEditEvent update) {
        Customerss customerEdit = customerTable.getSelectionModel().getSelectedItem();
        customerEdit.setCustStatus(update.getNewValue().toString());
        Customerss customer = customerssRepository.findByCustomerId(customerEdit.getCustomerId());
        customer.setCustStatus(customerEdit.getCustFirstName());
        customerssRepository.save(customer);

    }

    @FXML
    void updatePhoneNumber(TableColumn.CellEditEvent update) {
        Customerss customerEdit = customerTable.getSelectionModel().getSelectedItem();
        customerEdit.setCustPhoneNumber(update.getNewValue().toString());
        Customerss customer = customerssRepository.findByCustomerId(customerEdit.getCustomerId());
        customer.setCustPhoneNumber(customerEdit.getCustFirstName());
        customerssRepository.save(customer);

    }

    @FXML
    void updateDescription(TableColumn.CellEditEvent update) {
        Customerss customerEdit = customerTable.getSelectionModel().getSelectedItem();
        customerEdit.setCustDescription(update.getNewValue().toString());
        Customerss customer = customerssRepository.findByCustomerId(customerEdit.getCustomerId());
        customer.setCustDescription(customerEdit.getCustFirstName());
        customerssRepository.save(customer);

    }

    private void loadCustomerDetails(){
        customerList.clear();
        customerList.addAll(findAll());
        customerTable.setItems(customerList);
    }
    public List<Customerss> findAll(){
        Iterable<Customerss> iterable = customerssRepository.findAll();
        List<Customerss> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }

    public void delete(ActionEvent actionEvent) {
        List<Customerss> customer = customerTable.getSelectionModel().getSelectedItems();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete selected?");

        Optional<ButtonType> action = alert.showAndWait();

        if(action.get() == ButtonType.OK)  customerssRepository.deleteAll(customer);
        loadCustomerDetails();
    }

    public void back(ActionEvent actionEvent) { stageManager.switchScene(FxmlView.MENU);}
}
