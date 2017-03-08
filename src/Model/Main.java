package Model;

import Control.Controller;
import View.BarChartView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Model model = new Model();
        BorderPane root = new BorderPane();
        FXMLLoader ControlLoader = new FXMLLoader(getClass().getResource("/res/BarChart.fxml"));
        ControlLoader.setController(new Controller(model));
        root.setCenter(ControlLoader.load());

        FXMLLoader CanvasLoader = new FXMLLoader(getClass().getResource("/res/Canvas.fxml"));
        CanvasLoader.setController(new BarChartView(model));
        root.setTop(CanvasLoader.load());

        Scene scene = new Scene(root);
        primaryStage.setTitle("MVCTest");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
