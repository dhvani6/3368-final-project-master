package edu.uh.tech.cis3368.manufacture.controller;

import edu.uh.tech.cis3368.manufacture.Employee;
import edu.uh.tech.cis3368.manufacture.repository.EmployeeRepository;
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
public class EmployeeInfoController implements Initializable {

    @FXML
    private TableColumn<Employee, String> emplFName;

    @FXML
    private TableColumn<Employee, String> emplLName;

    @FXML
    private TableColumn<Employee, String> emplEmail;
    @FXML
    private TableView<Employee> employeeTable;

    @FXML
    private TableColumn<Employee, Integer> emplId;


    @Lazy
    @Autowired
    StageManager stageManager;

    @Autowired
    EmployeeRepository employeeRepository;

    ObservableList<Employee> employeeList = FXCollections.observableArrayList();

    private void setColProperties(){
        emplId.setCellValueFactory(new PropertyValueFactory<>("empId"));

        emplFName.setCellValueFactory(new PropertyValueFactory<>("empFirstName"));
        emplFName.setCellFactory(TextFieldTableCell.forTableColumn());

        emplLName.setCellValueFactory(new PropertyValueFactory<>("empLastName"));
        emplLName.setCellFactory(TextFieldTableCell.forTableColumn());

        emplEmail.setCellValueFactory(new PropertyValueFactory<>("empEmail"));
        emplEmail.setCellFactory(TextFieldTableCell.forTableColumn());





    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        employeeTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        employeeTable.setEditable(true);
        setColProperties();
        loadEmployeeDetails();
}
    @FXML
    void updateEmplFName(TableColumn.CellEditEvent update) {
        Employee employeeEdit = employeeTable.getSelectionModel().getSelectedItem();
        employeeEdit.setEmpFirstName(update.getNewValue().toString());
        Employee employee = employeeRepository.findByEmpId(employeeEdit.getEmpId());
        employee.setEmpFirstName(employeeEdit.getEmpFirstName());
        employeeRepository.save(employee);

    }

    @FXML
    void updateEmplLName(TableColumn.CellEditEvent update) {
        Employee employeeEdit = employeeTable.getSelectionModel().getSelectedItem();
        employeeEdit.setEmpLastName(update.getNewValue().toString());
        Employee employee = employeeRepository.findByEmpId(employeeEdit.getEmpId());
        employee.setEmpLastName(employeeEdit.getEmpLastName());
        employeeRepository.save(employee);

    }

    @FXML
    void updateEmplEmail(TableColumn.CellEditEvent update) {
        Employee employeeEdit = employeeTable.getSelectionModel().getSelectedItem();
        employeeEdit.setEmpEmail(update.getNewValue().toString());
        Employee employee = employeeRepository.findByEmpId(employeeEdit.getEmpId());
        employee.setEmpEmail(employeeEdit.getEmpEmail());
        employeeRepository.save(employee);

    }

    private void loadEmployeeDetails() {
        employeeList.clear();
        employeeList.addAll(findAll());
        employeeTable.setItems(employeeList);
    }
    public List<Employee> findAll(){
        Iterable<Employee> iterable = employeeRepository.findAll();
        List<Employee> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }
    public void delete(ActionEvent actionEvent) {
        List<Employee> employee = employeeTable.getSelectionModel().getSelectedItems();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete selected?");

        Optional<ButtonType> action = alert.showAndWait();

        if(action.get() == ButtonType.OK)  employeeRepository.deleteAll(employee);
        loadEmployeeDetails();
    }

    public void back(ActionEvent actionEvent) { stageManager.switchScene(FxmlView.MENU);}
}

