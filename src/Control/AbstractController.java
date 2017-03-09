package Control;

import Model.Model;

public class AbstractController {

    protected final Model model;

    public AbstractController(Model model) {
        this.model = model;
    }
}
