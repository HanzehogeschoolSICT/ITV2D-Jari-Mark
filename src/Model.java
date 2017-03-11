import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

public class Model {
    static ArrayList<Bar> list;
    static int n = 10;
    static int loops = 0;

    @FXML
    public Canvas barcanvas;
    BubbleSorter bubblesorter;
    InsertionSorter insertionsorter;

    public Model() {
        bubblesorter = new BubbleSorter();
        insertionsorter = new InsertionSorter();
        list = new ArrayList<>();
        randomize(list);
    }

    private static void randomize(ArrayList<Bar> list) {
        for (int i = 1; i <= n; i++) {
            list.add(new Bar(i, Color.RED));
        }
        Random random = new Random();
        for (int i = 0; i < list.size(); i++) {
            Bar temp = list.remove(random.nextInt(list.size()));
            list.add(temp);
        }
    }

    public boolean BubbleStep() {
        if (n - loops - 1 > 0) {
            if (bubblesorter.step(list, loops)) {
                loops++;
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setColor(Color.GREEN);
            }
            return true;
        }
        return false;
    }

    public boolean InsertionStep() {
        return insertionsorter.step(list);
    }

    public ArrayList<Bar> getList() {
        return list;
    }
}
