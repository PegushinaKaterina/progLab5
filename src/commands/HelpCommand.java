package commands;

import validators.Validator;

import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * Класс команды: help : вывести справку по доступным командам
 */
public class HelpCommand extends AbstractCommand {
    private final HashMap<String, AbstractCommand> availableCommands;

    public HelpCommand(HashMap<String, AbstractCommand> availableCommands) {
        super("help", 0, "вывести справку по доступным командам");
        this.availableCommands = availableCommands;
    }

    @Override
    public void executeCommand(String[] commandArgs, ArrayDeque<String> commands) {
        try {
            Validator.validateQuantityOfArgs(commandArgs, getQuantityOfArgs());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Доступные команды:");
        for (AbstractCommand command : availableCommands.values()) {
            System.out.println(command.toString());
        }
    }
}
