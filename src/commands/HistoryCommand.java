package commands;

import validators.Validator;

import java.util.ArrayDeque;

/**
 * Класс команды: history : вывести последние 10 команд (без их аргументов)
 */
public class HistoryCommand extends AbstractCommand {
    private final ArrayDeque<String> queueOfCommands;

    public HistoryCommand(ArrayDeque<String> queueOfCommands) {
        super("history", 0, "вывести последние 10 команд (без их аргументов)");
        this.queueOfCommands = queueOfCommands;
    }

    @Override
    public void executeCommand(String[] commandArgs, ArrayDeque<String> commands) {
        try {
            Validator.validateQuantityOfArgs(commandArgs, getQuantityOfArgs());
            System.out.println("Последние 10 команд:");
            for (String name : queueOfCommands) {
                System.out.println(name);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}