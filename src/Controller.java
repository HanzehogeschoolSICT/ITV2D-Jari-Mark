import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

@SuppressWarnings("unchecked")
public class Controller implements Initializable {

    Scene scene;
    ArrayList<Integer> list;
    String sortingtype = "BubbleSort";
    Random random = new Random();
    int n = 6;
    XYChart.Series series;

    @FXML
    private BarChart<?, ?> randomchart;

    @FXML
    private ComboBox<?> methodbox;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        randomchart.getXAxis().setTickLabelsVisible(false);
        list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        for (int i = 0; i < list.size(); i++) {
            int temp = list.remove(random.nextInt(list.size()));
            list.add(temp);
        }

        series = new XYChart.Series();

        for (int i = 0; i < list.size(); i++) {
            series.getData().add(new XYChart.Data(""+i, list.get(i)));
        }
        randomchart.getData().addAll(series);
    }

    @FXML
    void changeString(ActionEvent event) {
        // Called when the combobox value is changed
        sortingtype = (String) methodbox.getValue();
    }

    @FXML
    void doStep(MouseEvent event) {
        // Called when the step button is clicked
        switch (sortingtype) {
            case "BubbleSort":
                SortOneBubble();
                break;

            case "InsertionSort":
                SortOneInsertion();
                break;
        }
        UpdateGUI();
    }

    private void UpdateGUI() {
        // TODO: Fix GUI update
        for (int i = 0; i < list.size(); i++) {
            series.getData().set(i, new XYChart.Data(""+i, list.get(i)));
        }
    }

    private void SortOneInsertion() {
        // TODO: Make Injection sort
    }

    private void SortOneBubble() {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                int temp = list.get(i);
                int temp2 = list.get(i + 1);
                list.set(i + 1, temp);
                list.set(i, temp2);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
