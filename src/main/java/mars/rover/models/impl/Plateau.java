package mars.rover.models.impl;

import mars.rover.models.IPlateau;

public class Plateau implements IPlateau {

    private int length; // x axis
    private int width; // y axis

    public Plateau(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
