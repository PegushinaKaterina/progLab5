package commands;

import entities.CollectionHumanBeing;
import validators.Validator;

import java.util.ArrayDeque;

/**
 * Класс команды: sum_of_minutes_of_waiting : вывести сумму значений поля minutesOfWaiting для всех элементов коллекции
 */
public class SumOfMinutesOfWaitingCommand extends AbstractCommand {
    private final CollectionHumanBeing collectionHumanBeing;

    public SumOfMinutesOfWaitingCommand(CollectionHumanBeing collectionHumanBeing) {
        super("sum_of_minutes_of_waiting", 0,
                "вывести сумму значений поля ВРЕМЯ ОЖИДАНИЯ для всех элементов коллекции");
        this.collectionHumanBeing = collectionHumanBeing;
    }

    @Override
    public void executeCommand(String[] commandArgs, ArrayDeque<String> commands) {
        try {
            Validator.validateQuantityOfArgs(commandArgs, getQuantityOfArgs());

            System.out.println(collectionHumanBeing.sumOfMinutesOfWaiting());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
