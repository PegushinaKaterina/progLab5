package parsers;

import entities.HumanBeing;
import generators.FileGeneratorHumanBeing;
import validators.Validator;
import workingWithFiles.FileWorker;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Класс парсеров
 */
public class Parser {

    /**
     * Метод, преобразующий человека из строкового представления
     *
     * @param string - человек в строковом представлении
     * @return человек
     */
    public static HumanBeing stringToHumanBeingParser(String string) {
        String[] humanBeingString = string.split(",");
        for (int i = 0; i < humanBeingString.length; i++) {
            humanBeingString[i] = humanBeingString[i].trim();
        }
        FileGeneratorHumanBeing humanBeing = new FileGeneratorHumanBeing(humanBeingString);
        return humanBeing.getHumanBeing();
    }

    /**
     * Метод, преобразующий значение из строкового представления в нужный тип данных
     *
     * @param string      - значение в строковом представления
     * @param description - описание значения
     * @param nullable    - может ли быть null
     * @param function    - функция из строки в нужный тип данных
     * @param predicate   - predicate - предикат, проверяющий правильность значения
     * @param error       - сообщение об ошибке
     * @param <T>         - тип возвращаемого значения
     * @return значение
     */
    public static <T> T valueParser(String string,
                                    String description,
                                    boolean nullable,
                                    Function<String, T> function,
                                    Predicate<Object> predicate,
                                    String error) {

        if ("".equals(string)) {
            if (nullable) {
                return null;
            } else {
                throw new IllegalArgumentException("Значение не может быть пустой строкой");
            }
        }
        T value = null;
        try {
            value = function.apply(string);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Ошибка при обработке значения, " + description);
        }
        try {
            Validator.validate(value, predicate);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(error);
        }
        return value;
    }

    /**
     * Метод, преобразующий значение из строкового представления в нужный тип данных
     *
     * @param string      - значение в строковом представления
     * @param description - описание значения
     * @param nullable    - может ли быть null
     * @param function    - функция из строки в нужный тип данных
     * @param <T>         - тип возвращаемого значения
     * @return значение
     */
    public static <T> T valueParser(String string,
                                    String description,
                                    boolean nullable,
                                    Function<String, T> function) {
        if ("".equals(string)) {
            if (nullable) {
                return null;
            } else {
                throw new IllegalArgumentException("Значение не может быть пустой строкой");
            }
        }
        T value = null;
        try {
            value = function.apply(string);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Ошибка при обработке значения, " + description);
        }
        return value;
    }

    /**
     * Парсер строки
     *
     * @param string   - значение в строковом представления
     * @param nullable - может ли быть null
     * @return строка
     */
    public static String valueParser(String string,
                                     boolean nullable) {
        if ("".equals(string)) {
            if (nullable) {
                return null;
            } else {
                throw new IllegalArgumentException("Значение не может быть пустой строкой");
            }
        }
        return string;
    }

    /**
     * Метод, преобразующий человека в строковое представления
     *
     * @param humanBeing - человек
     * @return человек в строковом представлении
     */
    public static String humanBeingToStringParser(HumanBeing humanBeing) {
        String string = "";
        string += humanBeing.getName() + "," + humanBeing.getCoordinates().getX() +
                "," + humanBeing.getCoordinates().getY() + "," + humanBeing.getRealHero() +
                "," + humanBeing.getHasToothpick() + "," + humanBeing.getImpactSpeed() +
                "," + humanBeing.getSoundtrackName() + "," + humanBeing.getMinutesOfWaiting() +
                "," + humanBeing.getWeaponType() + "," +
                (humanBeing.getCar().getCool() == null ? " " : humanBeing.getCar().getCool()) + "\n";
        return string;
    }
}
