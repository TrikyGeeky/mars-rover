package mars.rover.models;

import mars.rover.models.impl.Position;

public interface IPosition {

    IPosition move(IAction steps, IPlateau plateau);
    int getXposition();
    int getYposition();
    Position.Direction getHeading();
}
