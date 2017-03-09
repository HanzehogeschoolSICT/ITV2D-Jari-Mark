package Runner;

import Control.Controller;
import Model.Model;
import View.AbstractView;
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

        AbstractView bar = new BarChartView(model);
        FXMLLoader CanvasLoader = new FXMLLoader(getClass().getResource("/res/Canvas.fxml"));
        CanvasLoader.setController(bar);
        root.setTop(CanvasLoader.load());

        FXMLLoader ControlLoader = new FXMLLoader(getClass().getResource("/res/Controls.fxml"));
        ControlLoader.setController(new Controller(model, bar));
        root.setCenter(ControlLoader.load());

        Scene scene = new Scene(root);
        primaryStage.setTitle("MVCTest");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
