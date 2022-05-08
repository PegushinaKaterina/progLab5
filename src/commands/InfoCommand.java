package commands;

import entities.CollectionHumanBeing;
import validators.Validator;

import java.util.ArrayDeque;

/**
 * Класс команды: info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
 */
public class InfoCommand extends AbstractCommand {
    private final CollectionHumanBeing collectionHumanBeing;

    public InfoCommand(CollectionHumanBeing collectionHumanBeing) {
        super("info", 0, " вывести в стандартный поток вывода информацию о коллекции");
        this.collectionHumanBeing = collectionHumanBeing;
    }

    @Override
    public void executeCommand(String[] commandArgs, ArrayDeque<String> commands) {
        try {
            Validator.validateQuantityOfArgs(commandArgs, getQuantityOfArgs());
            System.out.println(collectionHumanBeing.info());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
