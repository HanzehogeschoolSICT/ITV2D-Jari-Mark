package Tests;

import Model.Bar;
import Model.Sorters.BubbleSorter;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class BubbleSortTest {

    private static void randomize(ArrayList<Bar> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(new Bar(i, Color.RED));
        }
        Random random = new Random();
        for (int i = 0; i < list.size(); i++) {
            Bar temp = list.remove(random.nextInt(list.size()));
            list.add(temp);
        }
    }

    @Test
    void TestBubble() {
        ArrayList<Bar> originallist = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            originallist.add(new Bar(i, Color.RED));
        }
        ArrayList<Bar> list = new ArrayList<>();
        randomize(list);
        BubbleSorter bubbleSorter = new BubbleSorter(list);

        getPop(bubbleSorter);
    }

    public void getPop(BubbleSorter bubbleSorter) {
        ArrayList<Bar> temp1 = bubbleSorter.pop();
        for (int i = 0; i < temp1.size(); i++) {
            if (temp1.get(i).color == Color.RED) {
                getPop(bubbleSorter);
                return;
            }
        }
        CheckEquals(temp1);
    }

    private void CheckEquals(ArrayList<Bar> temp1) {
        int[] rightorder = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        boolean equals = true;
        for (int i = 0; i < temp1.size(); i++) {
            if (rightorder[i] != temp1.get(i).value) {
                equals = false;
            }
        }
        assert equals;
    }
}
