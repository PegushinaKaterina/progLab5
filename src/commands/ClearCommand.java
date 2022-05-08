package commands;

import entities.CollectionHumanBeing;
import validators.Validator;

import java.util.ArrayDeque;

/**
 * Класс команды: clear : очистить коллекцию
 */
public class ClearCommand extends AbstractCommand {
    private final CollectionHumanBeing collectionHumanBeing;

    public ClearCommand(CollectionHumanBeing collectionHumanBeing) {
        super("clear", 0, "очистить коллекцию");
        this.collectionHumanBeing = collectionHumanBeing;
    }

    @Override
    public void executeCommand(String[] commandArgs, ArrayDeque<String> commands) {
        try {
            Validator.validateQuantityOfArgs(commandArgs, getQuantityOfArgs());
            System.out.println(collectionHumanBeing.clear());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
