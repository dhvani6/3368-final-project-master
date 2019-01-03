package edu.uh.tech.cis3368.manufacture.controller;

import edu.uh.tech.cis3368.manufacture.Employee;
import edu.uh.tech.cis3368.manufacture.repository.EmployeeRepository;
import edu.uh.tech.cis3368.manufacture.view.FxmlView;
import edu.uh.tech.cis3368.manufacture.view.StageManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class EmployeeController implements Initializable {

    @FXML
    private TextField EFname;

    @FXML
    private TextField ELname;

    @FXML
    private TextField Eemail;

    @Lazy
    @Autowired
    StageManager stageManager;
    @Autowired
    EmployeeRepository employeeRepository;

    public String getEFnameText(){return EFname.getText();}
    public String getELnameText(){return ELname.getText();}
    public String getEemailText(){return Eemail.getText();}

    public void back(ActionEvent actionEvent) { stageManager.switchScene(FxmlView.MENU);}


    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    public void save(ActionEvent actionEvent) {
        Employee employee = new Employee();
        employee.setEmpFirstName(getEFnameText());
        employee.setEmpLastName(getELnameText());
        employee.setEmpEmail(getEemailText());

        employeeRepository.save(employee);
        stageManager.switchScene(FxmlView.EMPLOYEEINFO);

    }




}
