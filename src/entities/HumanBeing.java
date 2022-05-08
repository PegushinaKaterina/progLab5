package entities;

import java.util.Date;

/**
 * Класс человека
 */
public class HumanBeing implements Comparable<HumanBeing> {
    public static long idCounter = 1;
    public static Double IMPACT_SPEED_MIN = -484.;
    private final Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private final java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private Boolean realHero; //Поле не может быть null
    private boolean hasToothpick;
    private Double impactSpeed; //Значение поля должно быть больше -484, Поле может быть null
    private String soundtrackName; //Поле не может быть null
    private Integer minutesOfWaiting; //Поле не может быть null
    private WeaponType weaponType; //Поле не может быть null
    private Car car; //Поле не может быть null

    /**
     * Конструктор человека
     *
     * @param name             - имя человека
     * @param coordinates      - координаты человека
     * @param realHero         - значение реальный это герой или нет
     * @param hasToothpick     - значение есть ли у него зубочистка
     * @param impactSpeed      - скорость удара
     * @param soundtrackName   - саундтрек
     * @param minutesOfWaiting - время ожидания
     * @param weaponType       - тип оружия
     * @param car              - машина
     */
    public HumanBeing(String name, Coordinates coordinates, Boolean realHero, boolean hasToothpick,
                      Double impactSpeed, String soundtrackName, Integer minutesOfWaiting,
                      WeaponType weaponType, Car car) {
        id = idCounter++;
        setName(name);
        setCoordinates(coordinates);
        creationDate = new Date();
        setRealHero(realHero);
        setHasToothpick(hasToothpick);
        setImpactSpeed(impactSpeed);
        setSoundtrackName(soundtrackName);
        setMinutesOfWaiting(minutesOfWaiting);
        setWeaponType(weaponType);
        setCar(car);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public boolean getRealHero() {
        return realHero;
    }

    public void setRealHero(Boolean realHero) {
        this.realHero = realHero;
    }

    public boolean getHasToothpick() {
        return hasToothpick;
    }

    public void setHasToothpick(boolean hasToothpick) {
        this.hasToothpick = hasToothpick;
    }

    public double getImpactSpeed() {
        return impactSpeed;
    }

    public void setImpactSpeed(Double impactSpeed) {
        this.impactSpeed = impactSpeed;
    }

    public String getSoundtrackName() {
        return soundtrackName;
    }

    public void setSoundtrackName(String soundtrackName) {
        this.soundtrackName = soundtrackName;
    }

    public int getMinutesOfWaiting() {
        return minutesOfWaiting;
    }

    public void setMinutesOfWaiting(Integer minutesOfWaiting) {
        this.minutesOfWaiting = minutesOfWaiting;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    /**
     * Метод, сравнивающий людей
     *
     * @param humanBeing - человек для сравнения
     * @return результат сравнения
     */
    @Override
    public int compareTo(HumanBeing humanBeing) {
        if (name.compareTo(humanBeing.getName()) == 0) {
            return Long.compare(id, humanBeing.getId());
        } else {
            return name.compareTo(humanBeing.getName());
        }
    }

    @Override
    public String toString() {
        String stringRealHero;
        if (realHero == true) {
            stringRealHero = "Это реальный человек";
        } else {
            stringRealHero = "Это не реальный человек";
        }
        String stringHasToothpick;
        if (hasToothpick == true) {
            stringHasToothpick = "у него есть зубочистка";
        } else {
            stringHasToothpick = "у него нет зубочистки";
        }
        String stringCar;
        if (car.getCool() == null) {
            stringCar = ", о его машине ничего не известно";
        } else if (car.getCool() == false) {
            stringCar = " и нет крутой машины";
        } else {
            stringCar = " и есть крутая машина";
        }
        return "Человек с именем " + name + ", id - " + id + "\n" +
                "   Скорость удара: " + impactSpeed +
                ", время ожидания: " + minutesOfWaiting;
        /*
        return "Человек с именем " + name + ", id - " + id + "\n" +
                "   Дата создания: " + creationDate + ", " +
                "Координаты: " + "x - " + coordinates.getX() + ", y - " +coordinates.getY() + "\n" +
                "   " + stringRealHero + ", " +stringHasToothpick + stringCar + ".\n"+
                "   Скорость удара: " + impactSpeed +
                ", cаундтрек: " + soundtrackName +
                ", время ожидания: " + minutesOfWaiting +
                ", Тип оружия:" + weaponType + "\n";
                */
    }
}