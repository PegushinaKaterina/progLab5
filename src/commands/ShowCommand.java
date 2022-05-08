package commands;

import entities.CollectionHumanBeing;
import validators.Validator;

import java.util.ArrayDeque;

/**
 * Класс команды: show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
 */
public class ShowCommand extends AbstractCommand {
    private final CollectionHumanBeing collectionHumanBeing;

    public ShowCommand(CollectionHumanBeing collectionHumanBeing) {
        super("show", 0, "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.collectionHumanBeing = collectionHumanBeing;
    }

    @Override
    public void executeCommand(String[] commandArgs, ArrayDeque<String> commands){
        try {
            Validator.validateQuantityOfArgs(commandArgs, getQuantityOfArgs());
            System.out.println(collectionHumanBeing.show());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
