package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    String sortingtype = "BubbleSort";
    Random random = new Random();
    int n = 6;

    @FXML
    private BarChart<?, ?> randomchart;

    @FXML
    private ComboBox<?> methodbox;


    @SuppressWarnings("unchecked")
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        randomchart.setLegendVisible(false);

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        for (int i = 0; i < list.size(); i++) {
            int temp = list.remove(random.nextInt(list.size()));
            list.add(temp);
        }

        XYChart.Series series = new XYChart.Series();

        for (int i = 0; i < list.size(); i++) {
            series.getData().add(new XYChart.Data(list.get(i).toString(), list.get(i)));
        }
        randomchart.getData().addAll(series);
    }

    @FXML
    void changeString(ActionEvent event) {
        sortingtype = (String) methodbox.getValue();
    }

    @FXML
    void doStep(MouseEvent event) {
        switch (sortingtype) {
            case "BubbleSort":
                SortOneBubble();
                break;
        }
    }

    private void SortOneBubble() {

    }
}
