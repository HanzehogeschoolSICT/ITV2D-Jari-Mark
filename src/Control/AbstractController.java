package Control;

import Model.Model;
import View.AbstractView;

public class AbstractController {

    protected final Model model;
    protected final AbstractView view;

    public AbstractController(Model model, AbstractView view) {
        this.model = model;
        this.view = view;
    }
}
