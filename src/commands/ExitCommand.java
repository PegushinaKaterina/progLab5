package commands;

import validators.Validator;

import java.util.ArrayDeque;

/**
 * Класс команды: exit : завершить программу (без сохранения в файл)
 */
public class ExitCommand extends AbstractCommand {
    public static boolean isRunning = true;

    public ExitCommand() {
        super("exit", 0, "завершить программу (без сохранения в файл)");
    }

    @Override
    public void executeCommand(String[] commandArgs, ArrayDeque<String> commands){
        try {
            Validator.validateQuantityOfArgs(commandArgs, getQuantityOfArgs());
            System.out.println("Принудительное завершение программы");
            isRunning = false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
