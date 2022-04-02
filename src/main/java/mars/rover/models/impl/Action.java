package mars.rover.models.impl;

import mars.rover.models.IAction;

public class Action implements IAction {

    String actions;

    public Action(String actions) {
        this.actions = actions;
    }

    @Override
    public String getActions() {
        return actions;
    }
}
