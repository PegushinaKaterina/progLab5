package generators;

import entities.Car;
import entities.Coordinates;
import entities.HumanBeing;
import entities.WeaponType;
import parsers.CheckBoolean;
import parsers.Parser;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Класс, генерирующий человека
 */
public class GeneratorHumanBeing {
    private final HumanBeing generatedHumanBeing;

    private final Scanner scanner = new Scanner(System.in);

    /**
     * Конструктор, генерирующий человека
     */
    public GeneratorHumanBeing() {
        String name = setName();
        Coordinates coordinates = setCoordinate();
        Boolean realHero = setRealHero();
        boolean hasToothpick = setHasToothpick();
        Double impactSpeed = setImpactSpeed();
        String soundtrackName = setSoundtrackName();
        Integer minutesOfWaiting = setMinutesOfWaiting();
        WeaponType weaponType = setWeaponType();
        Car car = setCar();
        generatedHumanBeing = new HumanBeing(name, coordinates, realHero, hasToothpick,
                impactSpeed, soundtrackName, minutesOfWaiting, weaponType, car);
    }

    public HumanBeing getHumanBeing() {
        System.out.println("Создан новый человек");
        System.out.println(generatedHumanBeing);
        return generatedHumanBeing;
    }

    /**
     * Метод, считывающий и устанавливающий значение поля
     *
     * @param message     - сообщение о вводимых данных
     * @param description - описание вводимых данных
     * @param nullable    - может ли быть null
     * @param function    - функция из строки в нужный тип данных
     * @param predicate   - predicate - предикат, проверяющий правильность значения
     * @param error       - сообщение об ошибке
     * @param <T>         - тип возвращаемого значения
     * @return значение
     */
    private <T> T setValue(String message,
                           String description,
                           boolean nullable,
                           Function<String, T> function,
                           Predicate<Object> predicate,
                           String error) {
        System.out.println(message + ", " + description);
        boolean isRunning = true;
        T value = null;
        while (isRunning) {
            try {
                String string = scanner.nextLine();
                value = Parser.valueParser(string, description, nullable, function, predicate, error);
                isRunning = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + ".\nПовторите ввод");
                continue;
            } catch (NoSuchElementException e) {
                System.out.println("Введен недопустимый символ");
                System.exit(1);
            }
        }
        return value;
    }

    /**
     * Метод, считывающий и устанавливающий значение поля
     *
     * @param message  - сообщение о вводимых данных
     * @param nullable - может ли быть null
     * @return значение
     */
    private String setValue(String message,
                            boolean nullable) {
        System.out.println(message);
        boolean isRunning = true;
        String value = null;
        while (isRunning) {
            try {
                String string = scanner.nextLine();
                value = Parser.valueParser(string, nullable);
                isRunning = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + ".\nПовторите ввод");
                continue;
            } catch (NoSuchElementException e) {
                System.out.println("Введен недопустимый символ");
                System.exit(1);
            }
        }
        return value;
    }

    /**
     * Метод, считывающий и устанавливающий значение поля
     *
     * @param message     - сообщение о вводимых данных
     * @param description - описание вводимых данных
     * @param nullable    - может ли быть null
     * @param function    - функция из строки в нужный тип данных
     * @param <T>         - тип возвращаемого значения
     * @return значение
     */
    private <T> T setValue(String message,
                           String description,
                           boolean nullable,
                           Function<String, T> function) {
        System.out.println(message + ", " + description);
        boolean isRunning = true;
        T value = null;
        while (isRunning) {
            try {
                String string = scanner.nextLine();
                value = Parser.valueParser(string, description, nullable, function);
                isRunning = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + ".\nПовторите ввод");
                continue;
            } catch (NoSuchElementException e) {
                System.out.println("Введен недопустимый символ");
                System.exit(1);
            }
        }
        return value;
    }

    private String setName() {
        String name = setValue("Введите имя",
                false);
        return name;
    }

    private Coordinates setCoordinate() {
        int x = setValue("Введите координату X",
                "значение должно быть целым числом не больше " + Coordinates.X_MAX,
                false,
                Integer::parseInt,
                arg -> (int) arg < Coordinates.X_MAX,
                "Координата X должна быть не больше " + Coordinates.X_MAX);

        int y = setValue("Введите координату Y",
                "значение должно быть целым числом",
                false,
                Integer::parseInt);

        return new Coordinates(x, y);
    }

    private Boolean setRealHero() {
        Boolean realHero = setValue("Это реальный герой или нет?",
                "значение должно быть Да или Нет",
                false,
                CheckBoolean::checkBoolean);
        return realHero;
    }

    private boolean setHasToothpick() {
        boolean hasToothpick = setValue("У героя есть зубочистка?",
                "значение должно быть Да или Нет",
                false,
                CheckBoolean::checkBoolean);
        return hasToothpick;
    }

    private Double setImpactSpeed() {
        Double impactSpeed = setValue("Введите скорость удара",
                "значение должно быть вещественным числом и больше " + HumanBeing.IMPACT_SPEED_MIN,
                false,
                Double::parseDouble,
                arg -> (Double) arg > HumanBeing.IMPACT_SPEED_MIN,
                "Значение должно быть больше " + HumanBeing.IMPACT_SPEED_MIN);
        return impactSpeed;
    }

    private String setSoundtrackName() {
        String soundtrackName = setValue("Введите название саундтрека",
                false);
        return soundtrackName;
    }

    private Integer setMinutesOfWaiting() {
        Integer minutesOfWaiting = setValue("Введите время ожидания",
                "значение должно быть целым числом",
                false,
                Integer::valueOf);
        return minutesOfWaiting;
    }

    private WeaponType setWeaponType() {
        WeaponType weaponType = setValue("Введите тип оружия",
                "допустимые значения: \n" + WeaponType.show() + "регистр должен сохраняться",
                false,
                WeaponType::valueOf);
        return weaponType;
    }

    private Car setCar() {
        Boolean cool = setValue("Машина крутая?",
                "значение должно быть Да или Нет. Если хотите оставить это значение, пустым нажмите enter",
                true,
                CheckBoolean::checkBoolean);
        return new Car(cool);
    }
}
