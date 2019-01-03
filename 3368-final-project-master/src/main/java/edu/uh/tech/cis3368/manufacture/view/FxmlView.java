package edu.uh.tech.cis3368.manufacture.view;

import java.util.ResourceBundle;

public enum FxmlView {
    PARTINFO{
        @Override
        public String getTitle(){return getStringFromResourceBundle("partInfo.title");}

        @Override
        public String getFxmlFile(){return "/fxml/partInfo.fxml";}

    },
    PART{
        @Override
        public String getTitle(){return getStringFromResourceBundle("part.title");}

        @Override
        public String getFxmlFile(){return "/fxml/inventory.fxml";}

    },
    EMPLOYEEINFO{
        @Override
        public String getTitle(){return getStringFromResourceBundle("employeeInfo.title");}

        @Override
        public String getFxmlFile(){return "/fxml/employeeInfo.fxml";}

    },
    EMPLOYEE{
        @Override
        public String getTitle(){return getStringFromResourceBundle("employee.title");}

        @Override
        public String getFxmlFile(){return "/fxml/employee.fxml";}

    },
    FORM{
        @Override
        public String getTitle(){return getStringFromResourceBundle("form.title");}

        @Override
        public String getFxmlFile(){return "/fxml/form.fxml";}
    },
    CUSTOMERINFO{
        @Override
        public String getTitle(){return getStringFromResourceBundle("customer.title");}

        @Override
        public String getFxmlFile(){return "/fxml/customerInfo.fxml";}

    },
    MENU{
        @Override
        public String getTitle(){return getStringFromResourceBundle("menu.title");}

        @Override
        public String getFxmlFile(){return "/fxml/menu.fxml";}
    };

    abstract String getTitle();
    abstract String getFxmlFile();

    String getStringFromResourceBundle(String key){return ResourceBundle.getBundle("Bundle").getString(key);
    }
}
