package com.team54.airportdispatchtycoonteam54.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainController {
    @FXML
    private ListView flightList; //TODO: add abstract Aircraft type

    @FXML
    private Label jetFuelLabel;

    @FXML
    private Label mealsLabel;

    @FXML
    private Label luggageCartsLabel;

    @FXML
    private Label budgetLabel;

    @FXML
    private Button clearNextFlightButton;

    @FXML
    private Button purchaseButton;

    @FXML
    private TextArea systemLog;

    @FXML
    private ComboBox availableResourcesDropdown; //TODO: add type

    @FXML
    public void initialize(){
        clearNextFlightButton.setOnAction(this::handleClearNextFlightButtonPressed);
        purchaseButton.setOnAction(this::handlePurchaseButtonPressed);

        initializeGUI();
        updateGUI();
    }

    private void handleClearNextFlightButtonPressed(ActionEvent event){

    }

    private void handlePurchaseButtonPressed(ActionEvent event){

    }

    private void initializeGUI(){
        systemLog.clear();
        //TODO: fill combobox
    }

    private void updateGUI(){
        //TODO: update GUI from DepoManager
    }

}
