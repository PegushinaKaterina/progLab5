package entities;

/**
 * Класс машины, которой обладает человек
 */
public class Car {
    private final Boolean cool;

    public Car(Boolean cool) {
        this.cool = cool;
    }

    public Boolean getCool() {
        return cool;
    }

}