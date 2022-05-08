package commands;

import entities.CollectionHumanBeing;
import parsers.Parser;
import validators.Validator;

import java.util.ArrayDeque;

/**
 * Класс команды: remove_all_by_minutes_of_waiting minutesOfWaiting : удалить из коллекции все элементы, значение поля minutesOfWaiting которого эквивалентно заданному
 */
public class RemoveAllByMinutesOfWaitingCommand extends AbstractCommand {
    private final CollectionHumanBeing collectionHumanBeing;

    public RemoveAllByMinutesOfWaitingCommand(CollectionHumanBeing collectionHumanBeing) {
        super("remove_all_by_minutes_of_waiting", 1,
                "удалить из коллекции все элементы, значение поля ВРЕМЯ ОЖИДАНИЯ которого эквивалентно заданному. ",
                "Значение поля ВРЕМЯ ОЖИДАНИЯ - целое число минут");
        this.collectionHumanBeing = collectionHumanBeing;
    }

    @Override
    public void executeCommand(String[] commandArgs, ArrayDeque<String> commands) {
        try {
            Validator.validateQuantityOfArgs(commandArgs, getQuantityOfArgs());
            Integer minutesOfWaiting = Parser.valueParser(commandArgs[0],
                    "значение должно быть целым числом",
                    false,
                    Integer::valueOf);
            System.out.println(collectionHumanBeing.removeAllByMinutesOfWaiting(minutesOfWaiting));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
