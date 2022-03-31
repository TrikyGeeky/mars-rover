package mars.rover.models.impl;

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
    public IPosition move(String steps) {
        steps = steps.trim();
        steps.chars().mapToObj(i -> Character.valueOf((char)i))
                .forEach(character -> {
            if('M' == character){
                if(this.getHeading().equals(Direction.N) || this.getHeading().equals(Direction.S)) {
                    this.setyPosition(this.getHeading().equals(Direction.N)  ? this.getyPosition() + 1 : this.getyPosition() - 1);
                } else {
                    this.setxPosition(this.getHeading().equals(Direction.E)  ? this.getxPosition() + 1 : this.getxPosition() - 1);
                }
            } else {
                this.turnRover(this.getHeading(), 'R' == character);
            }
        });
        return this;
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

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public Direction getHeading() {
        return heading;
    }

    public void setHeading(Direction heading) {
        this.heading = heading;
    }
}
