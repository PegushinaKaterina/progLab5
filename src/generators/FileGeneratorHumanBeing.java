package generators;

import entities.Car;
import entities.Coordinates;
import entities.HumanBeing;
import entities.WeaponType;
import parsers.CheckBoolean;
import parsers.Parser;
import validators.Validator;

import java.util.ArrayDeque;

/**
 * Класс, генерирующий человека с файла
 */
public class FileGeneratorHumanBeing {
    HumanBeing generatedHumanBeing;
    int quantityOfArgs = 10;
    ArrayDeque<String> errors = new ArrayDeque<String>();

    /**
     * Конструктор, генерирующий человека
     */
    public FileGeneratorHumanBeing(String[] stringHumanBeing) {
        try {
            Validator.validateQuantityOfArgs(stringHumanBeing, quantityOfArgs);
            String name = setName(stringHumanBeing[0]);
            Coordinates coordinates = setCoordinates(stringHumanBeing[1], stringHumanBeing[2]);
            Boolean realHero = setRealHero(stringHumanBeing[3]);
            boolean hasToothpick = setHasToothpick(stringHumanBeing[4]);
            Double impactSpeed = setImpactSpeed(stringHumanBeing[5]);
            String soundtrackName = setSoundtrackName(stringHumanBeing[6]);
            Integer minutesOfWaiting = setMinutesOfWaiting(stringHumanBeing[7]);
            WeaponType weaponType = setWeaponType(stringHumanBeing[8]);
            Car car = setCar(stringHumanBeing[9]);
            if (errors.isEmpty()) {
                generatedHumanBeing = new HumanBeing(name,
                        coordinates,
                        realHero,
                        hasToothpick,
                        impactSpeed,
                        soundtrackName,
                        minutesOfWaiting,
                        weaponType,
                        car);
            } else {
                while (!errors.isEmpty()) {
                    System.out.println(errors.remove());
                }
                generatedHumanBeing = null;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            generatedHumanBeing = null;
        }

    }

    public HumanBeing getHumanBeing() {
        return generatedHumanBeing;
    }

    public String setName(String stringName) {
        String name = null;
        try {
            name = Parser.valueParser(stringName,
                    false);
            return name;
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
        return " ";
    }

    public Coordinates setCoordinates(String stringX, String stringY) {
        int x = 0;
        try {
            x = Parser.valueParser(stringX,
                    "значение координаты X должно быть целым числом",
                    false,
                    Integer::parseInt,
                    arg -> (int) arg < Coordinates.X_MAX,
                    "Значение координаты X должно быть не больше " + Coordinates.X_MAX);
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
        try {
            int y = Parser.valueParser(stringY,
                    "значение координаты Y должно быть целым числом",
                    false,
                    Integer::parseInt);
            return new Coordinates(x, y);
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
        return new Coordinates(0, 0);
    }

    public Boolean setRealHero(String stringRealHero) {
        try {
            Boolean realHero = Parser.valueParser(stringRealHero,
                    "значение \"Это реальный герой\" должно быть Да или Нет",
                    false,
                    CheckBoolean::checkBoolean);
            return realHero;
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
        return false;
    }

    public boolean setHasToothpick(String stringHasToothpick) {
        try {
            boolean hasToothpick = Parser.valueParser(stringHasToothpick,
                    "значение \"У человека есть зубочистка\" должно быть Да или Нет",
                    false,
                    CheckBoolean::checkBoolean);
            return hasToothpick;
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
        return false;
    }

    public Double setImpactSpeed(String stringImpactSpeed) {
        try {
            Double impactSpeed = Parser.valueParser(stringImpactSpeed,
                    "значение скорости удара должно быть вещественным числом",
                    false,
                    Double::parseDouble,
                    arg -> (Double) arg > HumanBeing.IMPACT_SPEED_MIN,
                    "Значение скорости удара должно быть больше " + HumanBeing.IMPACT_SPEED_MIN);
            return impactSpeed;
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
        return 0.0;
    }

    public String setSoundtrackName(String stringSoundtrackName) {
        String soundtrackName = null;
        try {
            soundtrackName = Parser.valueParser(stringSoundtrackName,
                    false);
            return soundtrackName;
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
        return " ";
    }

    public Integer setMinutesOfWaiting(String stringMinutesOfWaiting) {
        try {
            Integer minutesOfWaiting = Parser.valueParser(stringMinutesOfWaiting,
                    "значение времени ожидания должно быть целым числом",
                    false,
                    Integer::parseInt);
            return minutesOfWaiting;
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
        return 0;
    }

    public WeaponType setWeaponType(String stringWeaponType) {
        try {
            WeaponType weaponType = Parser.valueParser(stringWeaponType,
                    "тип оружия должен быть из списка: \n" + WeaponType.show() + "Регистр должен сохраняться",
                    false,
                    WeaponType::valueOf);
            return weaponType;
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
        return WeaponType.BAT;
    }

    public Car setCar(String stringCool) {
        try {
            Boolean cool = Parser.valueParser(stringCool,
                    "значение \"У человека есть крутая машина\" должно быть Да или Нет, или быть пустым",
                    true,
                    CheckBoolean::checkBoolean);
            return new Car(cool);
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
        return new Car(false);

    }
}
