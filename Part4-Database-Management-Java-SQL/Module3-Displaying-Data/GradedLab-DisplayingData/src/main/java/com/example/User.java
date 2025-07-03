package com.example;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
    private IntegerProperty userId;
    private StringProperty fName;
    private StringProperty lName;
    private IntegerProperty points;

    public User(int userId, String fName, String lName, int points) {
        this.userId = new SimpleIntegerProperty(userId);
        this.fName = new SimpleStringProperty(fName);
        this.lName = new SimpleStringProperty(lName);
        this.points = new SimpleIntegerProperty(points);
    }

    public int getUserId() {
        return userId.get();
    }

    public String getfName() {
        return fName.get();
    }

    public String getlName() {
        return lName.get();
    }

    public int getPoints() {
        return points.get();
    }

    public StringProperty fNameProperty() {
        return fName;
    }

    public StringProperty lNameProperty() {
        return lName;
    }

    
}
