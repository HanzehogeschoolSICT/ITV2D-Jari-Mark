package Model;

import java.util.ArrayList;
import java.util.Random;

public class Model {
    int n = 10;
    private static ArrayList<Integer> list;

    Model() {
        list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        Random random = new Random();
        for (int i = 0; i < list.size(); i++) {
            int temp = list.remove(random.nextInt(list.size()));
            list.add(temp);
        }
    }

    public void setList(ArrayList<Integer> list) {
        Model.list = list;
    }

    public ArrayList<Integer> getList() {
        return list;
    }
}
