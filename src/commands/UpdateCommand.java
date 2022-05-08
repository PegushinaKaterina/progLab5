package commands;

import entities.CollectionHumanBeing;
import entities.HumanBeing;
import generators.GeneratorHumanBeing;
import parsers.Parser;
import validators.Validator;

import java.util.ArrayDeque;

/**
 * Класс команды: update id {element} : обновить значение элемента коллекции, id которого равен заданному
 */
public class UpdateCommand extends AbstractCommand {
    private final CollectionHumanBeing collectionHumanBeing;

    public UpdateCommand(CollectionHumanBeing collectionHumanBeing) {
        super("update",
                1,
                "обновить значение элемента коллекции, id которого равен заданному. ",
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
            if(!getExecutedScript()){
                GeneratorHumanBeing generatorHumanBeing = new GeneratorHumanBeing();
                System.out.println(collectionHumanBeing.update(id, generatorHumanBeing.getHumanBeing()));
            } else{
                if (commands.size() < 10){
                    throw new IllegalArgumentException("Неверное количество аргументов для команды update");
                }
                String string = "";
                for (int i = 0; i < 10; i++){
                    string += commands.remove();
                    if(i != 9){
                        string+=",";
                    }
                }
                HumanBeing humanBeing = Parser.stringToHumanBeingParser(string);
                System.out.println(collectionHumanBeing.update(id, humanBeing));
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
