module com.testdb1.testdb1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.testdb1.testdb1 to javafx.fxml;
    exports com.testdb1.testdb1;
    opens com.testdb1.testdb1.src to javafx.fxml;
    exports com.testdb1.testdb1.src;
    exports com.testdb1.testdb1.struct;
    opens com.testdb1.testdb1.struct to javafx.fxml;
    exports com.testdb1.testdb1.controller;
    opens com.testdb1.testdb1.controller to javafx.fxml;
}