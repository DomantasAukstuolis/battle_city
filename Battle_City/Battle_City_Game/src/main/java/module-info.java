module com.example.battle_city_game {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.battle_city_game to javafx.fxml;
    exports com.example.battle_city_game;
}