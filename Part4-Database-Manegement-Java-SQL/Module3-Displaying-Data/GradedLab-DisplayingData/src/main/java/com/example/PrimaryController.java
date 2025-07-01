package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController {

    @FXML
    private TextField searchField;    

    @FXML
    private TableColumn<User, String> fnameColumn;

    @FXML
    private TableColumn<User, String> lnameColumn;

    @FXML
    private TableColumn<User, Integer> pointsColumn;

    @FXML
    private TableView<User> tableView;

    @FXML
    public void initialize() {
        // Initialize columns
        fnameColumn.setCellValueFactory(new PropertyValueFactory<>("fName"));
        lnameColumn.setCellValueFactory(new PropertyValueFactory<>("lName"));
        pointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));
        
        //right alignment
        pointsColumn.setCellFactory(column -> new TableCell<User, Integer>() {
            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.toString());
                    setAlignment(Pos.CENTER_RIGHT); // Align text to the right
                }
            }
        });
        //right alignment
        tableView.setItems(getAllUsers());
    }

    private static Connection connect() throws SQLException {
        
        String url = "jdbc:mysql://localhost:3306/clicknbuy";
        String user = "root";
        String password = "Lmv@15561";
        return DriverManager.getConnection(url, user, password);
    }

    private ObservableList<User> getAllUsers() {

        ObservableList<User> userList = FXCollections.observableArrayList();       


        String query = "SELECT * FROM user";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int userId = rs.getInt("user_id");
                String fName = rs.getString("first_name");
                String lName = rs.getString("last_name");
                int points = rs.getInt("reward_points");
                userList.add(new User(userId, fName, lName, points));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //return userList;
        
        FilteredList<User> filteredData = new FilteredList<>(userList, p -> true);
        
        filteredData.predicateProperty().bind(Bindings.createObjectBinding(() -> {
            String searchText = searchField.getText();

            // If search text is empty, show all records
            if (searchText == null || searchText.isEmpty()) {
                return person -> true;
            }

            // Otherwise, filter based on the person's name
            String lowerCaseFilter = searchText.toLowerCase();
            return person -> person.getfName().toLowerCase().contains(lowerCaseFilter);

        }, searchField.textProperty())); // Bind to the searchField's textProperty
        
        return filteredData;
    }    


    
}
