package net.largem.java101.streams101.exerise01;

/**
 * Created by James Tan on 11/13/2016.
 */
public final class Cell {
    private final String name;
    private final int index;

    public Cell(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }
}
