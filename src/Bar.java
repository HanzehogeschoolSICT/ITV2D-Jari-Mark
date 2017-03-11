import javafx.scene.paint.Color;

public class Bar {
    public int value;
    public Color color;

    public Bar(int value, Color color) {
        this.value = value;
        this.color = color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
