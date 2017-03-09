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
        FXMLLoader ControlLoader = new FXMLLoader(getClass().getResource("/res/Controls.fxml"));
        ControlLoader.setController(new Controller(model));
        root.setCenter(ControlLoader.load());

        AbstractView bar = new BarChartView(model);
        FXMLLoader CanvasLoader = new FXMLLoader(getClass().getResource("/res/Canvas.fxml"));
        CanvasLoader.setController(bar);
        model.AddView(bar);
        root.setTop(CanvasLoader.load());

        Scene scene = new Scene(root);
        primaryStage.setTitle("MVCTest");
        primaryStage.setScene(scene);
        primaryStage.show();
        model.start();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
