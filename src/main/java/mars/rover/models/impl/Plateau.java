package mars.rover.models.impl;

import mars.rover.models.IPlateau;

public class Plateau implements IPlateau {

    private int length; // x axis
    private int width; // y axis

    public Plateau(int length, int width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public int getWidth() {
        return width;
    }
}
