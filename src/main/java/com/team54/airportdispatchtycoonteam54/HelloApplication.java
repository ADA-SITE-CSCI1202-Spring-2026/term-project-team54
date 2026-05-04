package com.team54.airportdispatchtycoonteam54;

import com.team54.airportdispatchtycoonteam54.controllers.MainController;
import com.team54.airportdispatchtycoonteam54.core.Resource.DepotManager;
import com.team54.airportdispatchtycoonteam54.core.Resource.SupplyItem;
import com.team54.airportdispatchtycoonteam54.core.SaveLoad.SaveData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    final double WIDTH = 1920;
    final double HEIGHT = 1080;

    private MainController mainController;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), WIDTH, HEIGHT);
        mainController = fxmlLoader.getController();
        stage.setTitle("Airport Dispatch Tycoon");
        stage.setScene(scene);
        //stage.setOnCloseRequest(e -> handleQuitting());
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        if(mainController != null){
            mainController.saveCurrentState();
        }
    }
}
