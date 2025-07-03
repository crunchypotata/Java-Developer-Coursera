package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class GridController {
/*TODO 29: Paste the @FXML annotations from gridscene.fxml */

    @FXML
    private Label nameLabel;

    @FXML
    private Label cityLabel;

    @FXML
    private Label zipcodeLabel;

    @FXML
    private Button prevButton;

    @FXML
    private Button nextButton;


    private List<String[]> personData;  // List to store fetched records
    private int currentIndex = 0;

  /** TODO 30: Copy the code of fetchPersonData(), displayRecord(), initialize() and 
   nextRecord() methods from VBoxController.java**/
    private List<String[]> fetchPersonData() {
        List<String[]> data = new ArrayList<>();

        String query = "SELECT name, city, zipcode FROM person";

        try (Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String city = resultSet.getString("city");
                String zipcode = resultSet.getString("zipcode");

                data.add(new String[]{name, city, zipcode});
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    private void displayRecord(int index) {
        String[] person = personData.get(index);
        nameLabel.setText(person[0]);
        cityLabel.setText(person[1]);
        zipcodeLabel.setText(person[2]);
    }

    @FXML
    void prevRecord(ActionEvent event) {

    }    
    // TODO 30: nextRecord()
    @FXML
    void handleNextRecord(ActionEvent event) {
        if (currentIndex < personData.size() - 1) {
            currentIndex++;
            displayRecord(currentIndex);
        }
    }

    // prevRecord 
    @FXML
    void handlePrevRecord(ActionEvent event) {
        if (currentIndex > 0) {
            currentIndex--;
            displayRecord(currentIndex);
        }
    }

    @FXML
    void switchVScene(ActionEvent event) throws IOException{
    /*TODO 31: set the vboxscene.fxml as the root of application window*/
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/gridscene.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 320, 240);

        stage.setScene(scene);
        stage.show();
    }

}
