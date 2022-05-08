package commands;

import entities.CollectionHumanBeing;
import validators.Validator;

import java.io.IOException;
import java.util.ArrayDeque;

/**
 * Класс команды: save : сохранить коллекцию в файл
 */
public class SaveCommand extends AbstractCommand {
    private final CollectionHumanBeing collectionHumanBeing;

    public SaveCommand(CollectionHumanBeing collectionHumanBeing) {
        super("save", 0, "сохранить коллекцию в файл");
        this.collectionHumanBeing = collectionHumanBeing;
    }

    @Override
    public void executeCommand(String[] commandArgs, ArrayDeque<String> commands){
        try {
            Validator.validateQuantityOfArgs(commandArgs, getQuantityOfArgs());
            collectionHumanBeing.getFileWorker().fileWriter(collectionHumanBeing);
            System.out.println("Коллекция сохранена в файл");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Отсутствуют права на запись в файл, либо путь к файлу изменился");
        }
    }
}
