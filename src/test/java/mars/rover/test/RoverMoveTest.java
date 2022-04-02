package mars.rover.test;

import mars.rover.models.IAction;
import mars.rover.models.IPlateau;
import mars.rover.models.IPosition;
import mars.rover.models.impl.Action;
import mars.rover.models.impl.Plateau;
import mars.rover.models.impl.Position;
import org.junit.Assert;
import org.junit.Test;

public class RoverMoveTest {

    @Test
    public void move_optimal_position(){
        IPosition position = new Position(2,2, Position.Direction.N);
        IPlateau plateau = new Plateau(5,5);
        IAction action = new Action("LMMR");
        position.move(action, plateau);

        Assert.assertTrue("The X position of the Rover has changed", position.getXposition() == 0);
        Assert.assertTrue("The Y position of the Rover has not changed", position.getYposition() == 2);
        Assert.assertTrue("The Heading of the Rover has not changed", position.getHeading().equals(Position.Direction.N));
    }

    @Test
    public void move_rover_on_X_edge(){
        IPosition position = new Position(3,2, Position.Direction.E);
        IPlateau plateau = new Plateau(5,5);
        IAction action = new Action("MMMR");
        position.move(action, plateau);

        Assert.assertTrue("The X position of the Rover has changed", position.getXposition() == 5);
        Assert.assertTrue("The Y position of the Rover has not changed", position.getYposition() == 2);
        Assert.assertTrue("The Heading of the Rover has not changed", position.getHeading().equals(Position.Direction.S));
    }

    @Test
    public void move_rover_on_Y_edge(){
        IPosition position = new Position(3,2, Position.Direction.S);
        IPlateau plateau = new Plateau(5,5);
        IAction action = new Action("MMML");
        position.move(action, plateau);

        Assert.assertTrue("The X position of the Rover has changed", position.getXposition() == 3);
        Assert.assertTrue("The Y position of the Rover has not changed", position.getYposition() == 0);
        Assert.assertTrue("The Heading of the Rover has not changed", position.getHeading().equals(Position.Direction.E));
    }
}
