package commands;

import entities.CollectionHumanBeing;
import parsers.Parser;
import validators.Validator;

import java.util.ArrayDeque;

/**
 * Класс команды: remove_by_id id : удалить элемент из коллекции по его id
 */
public class RemoveByIdCommand extends AbstractCommand {
    private final CollectionHumanBeing collectionHumanBeing;

    public RemoveByIdCommand(CollectionHumanBeing collectionHumanBeing) {
        super("remove_by_id", 1, "удалить элемент из коллекции по его ID. ",
                "Значение поля ID - целое число, больше 0");
        this.collectionHumanBeing = collectionHumanBeing;
    }

    @Override
    public void executeCommand(String[] commandArgs, ArrayDeque<String> commands) {
        try {
            Validator.validateQuantityOfArgs(commandArgs, getQuantityOfArgs());
            Long id = Parser.valueParser(commandArgs[0],
                    "значение должно быть целым числом",
                    false,
                    Long::parseLong,
                    arg -> (Long) arg > 0,
                    "Значение должно быть больше 0");
            System.out.println(collectionHumanBeing.removeById(id));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
