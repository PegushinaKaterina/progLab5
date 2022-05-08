package commands;

import entities.CollectionHumanBeing;
import generators.GeneratorHumanBeing;
import validators.Validator;

import java.util.ArrayDeque;

/**
 * Класс команды: remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный
 */
public class RemoveLoverCommand extends AbstractCommand {
    private final CollectionHumanBeing collectionHumanBeing;

    public RemoveLoverCommand(CollectionHumanBeing collectionHumanBeing) {
        super("remove_lower", 0,
                "удалить из коллекции все элементы, меньшие, чем заданный");
        this.collectionHumanBeing = collectionHumanBeing;
    }

    @Override
    public void executeCommand(String[] commandArgs, ArrayDeque<String> commands) {
        try {
            Validator.validateQuantityOfArgs(commandArgs, getQuantityOfArgs());
            GeneratorHumanBeing generatorHumanBeing = new GeneratorHumanBeing();
            System.out.println(collectionHumanBeing.removeLover(generatorHumanBeing.getHumanBeing()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
