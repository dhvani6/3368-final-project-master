package edu.uh.tech.cis3368.manufacture.controller;

import edu.uh.tech.cis3368.manufacture.view.FxmlView;
import edu.uh.tech.cis3368.manufacture.view.StageManager;
import javafx.event.ActionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class MenuController {

    @Lazy
    @Autowired
    StageManager stageManager;
    public void customerStage(ActionEvent actionEvent) { stageManager.switchScene(FxmlView.CUSTOMERINFO);}

    public void employeeStage(ActionEvent actionEvent) { stageManager.switchScene(FxmlView.EMPLOYEE);
    }

    public void formStage(ActionEvent actionEvent) { stageManager.switchScene(FxmlView.FORM);}

    public void kanbanStage(ActionEvent actionEvent) {
    }

    public void inventoryStage(ActionEvent actionEvent) {stageManager.switchScene(FxmlView.PART);
    }
}
