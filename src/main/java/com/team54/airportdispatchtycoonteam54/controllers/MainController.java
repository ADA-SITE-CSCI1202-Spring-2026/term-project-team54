package com.team54.airportdispatchtycoonteam54.controllers;

import com.team54.airportdispatchtycoonteam54.core.Events.RandomFlightRequestGenerator;
import com.team54.airportdispatchtycoonteam54.core.Events.TickManager;
import com.team54.airportdispatchtycoonteam54.core.Queue.FlightRequest;
import com.team54.airportdispatchtycoonteam54.core.Queue.FlightRequestQueue;
import com.team54.airportdispatchtycoonteam54.core.Resource.DepotManager;
import com.team54.airportdispatchtycoonteam54.core.Resource.SupplyItem;
import com.team54.airportdispatchtycoonteam54.core.Services.CrewManager;
import com.team54.airportdispatchtycoonteam54.core.Services.ServiceResult;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainController {
    @FXML
    private ListView<FlightRequest> flightList;

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
    private Button startOverButton;

    @FXML
    private TextArea systemLog;

    @FXML
    private ComboBox<SupplyItem> availableResourcesDropdown;

    private final FlightRequestQueue flightRequestQueue = new FlightRequestQueue();

    @FXML
    public void initialize(){
        clearNextFlightButton.setOnAction(this::handleClearNextFlightButtonPressed);
        purchaseButton.setOnAction(this::handlePurchaseButtonPressed);

        // the government mandated singular lambda (for F1)
        startOverButton.setOnAction(e -> resetToStartingState());

        flightList.setMouseTransparent(true);
        flightList.setFocusTraversable(false);
        flightList.setStyle("-fx-font-size: 15pt;");

        // initialize all singletons:
        // done this way so I can control the order in which they're initialized
        // because some singletons depend on others being initialized first
        TickManager.getInstance();
        RandomFlightRequestGenerator.initialize(flightRequestQueue);
        DepotManager.getInstance();
        CrewManager.getInstance();

        initializeGUI();
        updateGUI();
    }

    private void handleClearNextFlightButtonPressed(ActionEvent event){
        ServiceResult serviceResult =
                CrewManager.getInstance().serviceFlight(flightRequestQueue.peek());
        if(serviceResult.isSuccessfull()){
            FlightRequest clearedFlightRequest = flightRequestQueue.poll();
            DepotManager.getInstance().addBudget(
                    clearedFlightRequest.getSuccessfulServiceRevenue()
            );
        }
        systemLog.appendText(serviceResult.getMessage());
        updateGUI();
    }

    private void handlePurchaseButtonPressed(ActionEvent event){
        String message =
                DepotManager.getInstance().purchase(availableResourcesDropdown.getValue(), 10);
        systemLog.appendText(message);
        updateGUI();
    }

    /**
     * Resets all data to make it look as if
     * you just launched the game for the first time.
     */
    private void resetToStartingState(){
        System.out.println("Reset pressed");
        // TODO: Load from some existing save file.

        initializeGUI();
        updateGUI();
    }

    private void initializeGUI(){
        systemLog.clear();
        availableResourcesDropdown.setItems(FXCollections.observableArrayList(SupplyItem.values()));
        availableResourcesDropdown.getSelectionModel().selectFirst();
        flightList.setItems(flightRequestQueue.getInternalList());
    }

    private void updateGUI(){
        jetFuelLabel.setText("Jet Fuel: " +
                DepotManager.getInstance().getSupplyItemAmount(SupplyItem.FUEL) + " L");
        mealsLabel.setText("Meals: " +
                DepotManager.getInstance().getSupplyItemAmount(SupplyItem.MEAL));
        luggageCartsLabel.setText("Luggage Carts: " +
                DepotManager.getInstance().getSupplyItemAmount(SupplyItem.LUGGAGE));
        budgetLabel.setText("Budget: $" + DepotManager.getInstance().getBudget());
    }

}
