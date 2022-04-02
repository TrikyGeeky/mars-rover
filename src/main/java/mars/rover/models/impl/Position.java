package mars.rover.models.impl;

import mars.rover.models.IAction;
import mars.rover.models.IPlateau;
import mars.rover.models.IPosition;

public class Position implements IPosition {

    public enum Direction {
        N,
        S,
        W,
        E
    }

    private int xPosition;
    private int yPosition;
    private Direction heading;

    public Position(int xPosition, int yPosition, Direction heading) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.heading = heading;
    }

    @Override
    public IPosition move(IAction action, IPlateau plateau) {
        String steps = action.getActions().trim();
        steps.chars().mapToObj(i -> Character.valueOf((char)i)).forEach(character -> {
            if ('M' != character) {
                this.turnRover(this.getHeading(), 'R' == character);
            } else if(checkRoverOnTheEdge(plateau)){
                System.out.println("Rover is on the edge and cannot go any further!");
            } else {
                if(this.getHeading().equals(Direction.N) || this.getHeading().equals(Direction.S)) {
                    this.setYposition(this.getHeading().equals(Direction.N)  ? this.getYposition() + 1 : this.getYposition() - 1);
                } else {
                    this.setXposition(this.getHeading().equals(Direction.E)  ? this.getXposition() + 1 : this.getXposition() - 1);
                }
            }
        });
        return this;
    }

    private boolean checkRoverOnTheEdge(IPlateau plateau) {
        return (this.getHeading().equals(Direction.N) && (this.getYposition() == plateau.getWidth()))
                || (this.getHeading().equals(Direction.S) && (this.getYposition() == 0))
                || (this.getHeading().equals(Direction.E) && (this.getXposition() == plateau.getLength()))
                || (this.getHeading().equals(Direction.W) && (this.getXposition() == 0));
    }


    private void turnRover(Direction direction, boolean right) {
        switch (direction){
            case N: {
                this.setHeading(right ? Direction.E : Direction.W);
                break;
            }
            case E: {
                this.setHeading(right ? Direction.S : Direction.N);
                break;
            }
            case S: {
                this.setHeading(right ? Direction.W : Direction.E);
                break;
            }
            case W: {
                this.setHeading(right ? Direction.N : Direction.S);
                break;
            }
        }
    }

    @Override
    public int getXposition() {
        return xPosition;
    }

    public void setXposition(int xPosition) {
        this.xPosition = xPosition;
    }

    @Override
    public int getYposition() {
        return yPosition;
    }

    public void setYposition(int yPosition) {
        this.yPosition = yPosition;
    }

    @Override
    public Direction getHeading() {
        return heading;
    }

    public void setHeading(Direction heading) {
        this.heading = heading;
    }
}
