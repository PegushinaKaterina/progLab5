package entities;

/**
 * Класс координат, описывающий положение человека
 */
public class Coordinates {

    public static final int X_MAX = 877;
    private final int x; //Максимальное значение поля: 877
    private final int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
