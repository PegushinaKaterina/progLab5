package commands;

import entities.CollectionHumanBeing;
import validators.Validator;

import java.util.ArrayDeque;

/**
 * Класс команды: remove_head : вывести первый элемент коллекции и удалить его
 */
public class RemoveHeadCommand extends AbstractCommand {
    private final CollectionHumanBeing collectionHumanBeing;

    public RemoveHeadCommand(CollectionHumanBeing collectionHumanBeing) {
        super("remove_head", 0,
                "вывести первый элемент коллекции и удалить его");
        this.collectionHumanBeing = collectionHumanBeing;
    }

    @Override
    public void executeCommand(String[] commandArgs, ArrayDeque<String> commands) {
        try {
            Validator.validateQuantityOfArgs(commandArgs, getQuantityOfArgs());
            System.out.println(collectionHumanBeing.removeHead());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
