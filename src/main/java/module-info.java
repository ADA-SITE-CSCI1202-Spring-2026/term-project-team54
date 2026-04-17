module com.team54.airportdispatchtycoonteam54 {
    requires javafx.controls;
    requires javafx.fxml;


    // remove stage warning

    requires transitive javafx.graphics;

    opens com.team54.airportdispatchtycoonteam54 to javafx.fxml;
    exports com.team54.airportdispatchtycoonteam54;
}