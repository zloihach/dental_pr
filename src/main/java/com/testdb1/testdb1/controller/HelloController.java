package com.testdb1.testdb1.controller;

import com.testdb1.testdb1.src.DB_con;
import com.testdb1.testdb1.struct.TableInit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.skin.LabeledSkinBase;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.stream.Collectors;

public class HelloController implements EventHandler<ActionEvent> {
    DB_con db_con = new DB_con();
    @FXML
    private TableView<TableInit> Employee;
    @FXML
    private TableColumn<TableInit, Integer> ID;
    @FXML
    private TableColumn<TableInit, Date> dob;
    @FXML
    private TableColumn<TableInit, String> email;
    @FXML
    private Button searh_btn;
    @FXML
    private Button close_btn;

    private ObservableList<TableInit> InitList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        searh_btn.setOnAction(this);
        ID.setCellValueFactory(new PropertyValueFactory<TableInit, Integer>("ID"));
        dob.setCellValueFactory(new PropertyValueFactory<TableInit, Date>("dob"));
        email.setCellValueFactory(new PropertyValueFactory<TableInit, String>("email"));
    }
    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) close_btn.getScene().getWindow();
        stage.close();
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == searh_btn) {
            String querry = "SELECT ID, dob, email FROM public.Employee;";
            try {
                ResultSet resultSet = db_con.Select(querry);
                while (resultSet.next()) {
                    InitList.add(new TableInit(
                            resultSet.getInt("ID"),
                            resultSet.getDate("dob"),
                            resultSet.getString("email")));
                    InitList.stream().distinct().collect(Collectors.toList());
                    Employee.setItems(InitList);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}