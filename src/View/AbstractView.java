package View;

import Model.Model;

public abstract class AbstractView {

    final Model model;

    AbstractView(Model model) {
        this.model = model;
    }

    public void Update() {

    }
}
