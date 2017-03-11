import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Runner extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();

        Model model = new Model();

        BarChartView barview = new BarChartView(model);
        FXMLLoader CanvasLoader = new FXMLLoader(getClass().getResource("/res/Canvas.fxml"));
        CanvasLoader.setController(barview);
        root.setTop(CanvasLoader.load());

        FXMLLoader ControlLoader = new FXMLLoader(getClass().getResource("/res/Controls.fxml"));
        ControlLoader.setController(new Controller(model, barview));
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
