module com.team54.airportdispatchtycoonteam54 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.team54.airportdispatchtycoonteam54 to javafx.fxml;
    exports com.team54.airportdispatchtycoonteam54;
}