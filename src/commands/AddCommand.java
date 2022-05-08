package commands;

import entities.CollectionHumanBeing;
import entities.HumanBeing;
import generators.GeneratorHumanBeing;
import parsers.Parser;
import validators.Validator;

import java.util.ArrayDeque;

/**
 * Класс команды: add {element} : добавить новый элемент в коллекцию
 */
public class AddCommand extends AbstractCommand {
    private final CollectionHumanBeing collectionHumanBeing;

    public AddCommand(CollectionHumanBeing collectionHumanBeing) {
        super("add", 0, "добавить новый элемент в коллекцию");
        this.collectionHumanBeing = collectionHumanBeing;

    }

    @Override
    public void executeCommand(String[] commandArgs, ArrayDeque<String> commands) {
        try {
            Validator.validateQuantityOfArgs(commandArgs, getQuantityOfArgs());
            if(!getExecutedScript()){
                GeneratorHumanBeing generatorHumanBeing = new GeneratorHumanBeing();
                System.out.println(collectionHumanBeing.add(generatorHumanBeing.getHumanBeing()));
            } else{
                if (commands.size() < 10){
                    throw new IllegalArgumentException("Неверное количество аргументов для команды add");
                }
                String string = "";
                for (int i = 0; i < 10; i++){
                    string += commands.remove();
                    if(i != 9){
                        string+=",";
                    }
                }
                HumanBeing humanBeing = Parser.stringToHumanBeingParser(string);
                System.out.println(collectionHumanBeing.add(humanBeing));
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
