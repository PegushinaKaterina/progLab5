package validators;

import java.util.function.Predicate;

/**
 * Класс валидаторов
 */
public class Validator {
    /**
     * Метод, валидирующий значение
     *
     * @param value     - значение
     * @param predicate - предикат, проверяющий правильность значения
     * @param <T>       - тип возвращаемого значения
     * @throws IllegalArgumentException
     */
    public static <T> void validate(T value, Predicate<Object> predicate) throws IllegalArgumentException {
        if (!predicate.test(value)) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Метод, валидирующий количество аргументов
     *
     * @param args         - массив аргументов
     * @param amountOfArgs - количество аргументов
     * @throws IllegalArgumentException
     */
    public static void validateQuantityOfArgs(String[] args, int amountOfArgs) throws IllegalArgumentException {
        if (args.length != amountOfArgs) {
            throw new IllegalArgumentException("Неверное количество аргументов, данная команда требует " + amountOfArgs + " аргументов");
        }
    }
}