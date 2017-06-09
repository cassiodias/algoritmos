package br.com.algo.floodfill;

/**
 * Flood fill, also called seed fill, is an algorithm that determines the area connected to a given node in a
 * multi-dimensional array (Wikipedia).
 *
 * BigO: O(N) where N is the number of position to change.
 *
 * @author Cassio Dias
 */
class FloodFill {

    private int[][] surface;

    FloodFill(int[][] surface) {
        if (surface == null) {
            throw new IllegalArgumentException("Please dude, review your surface, it can't be null.");
        }
        this.surface = surface;
    }

    void start(int lookingForTheValue, int newValueToApply, Position position) {
        floodIt(lookingForTheValue, newValueToApply, position.getX(), position.getY());
    }

    private void floodIt(int lookingForTheValue, int newValueToApply, int x, int y) {
        int currentColor = getValueAt(x, y);
        if (lookingForTheValue == currentColor) {

            this.surface[x][y] = newValueToApply;
            // spread it over
            floodIt(lookingForTheValue, newValueToApply, x + 1, y); // runs down
            floodIt(lookingForTheValue, newValueToApply, x - 1, y); // runs up
            floodIt(lookingForTheValue, newValueToApply, x, y + 1); // runs right
            floodIt(lookingForTheValue, newValueToApply, x, y - 1); // runs left
        }
    }

    private int getValueAt(int x, int y) {
        if (!outOfBoundary(x, y)) {
            return this.surface[x][y];
        } else {
            return -1;
        }
    }

    private boolean outOfBoundary(int x, int y) {
        return x < 0 || y < 0 || x >= this.surface.length || y >= this.surface[x].length;
    }

}
