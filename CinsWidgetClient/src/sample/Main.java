package sample;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Main.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("view/menu.fxml"));
        primaryStage.setTitle("CinsWidget Client");
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}
