package workingWithCommands;

import commands.*;
import entities.CollectionHumanBeing;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static commands.ExitCommand.isRunning;

/**
 * Класс, отвечающий за считывание и выполнение команд
 */
public class CommandListener {
    public static CommandManager manager;

    /**
     * Конструктор класса, создающий менеджер команд
     *
     * @param collectionHumanBeing - коллекция
     */
    public CommandListener(CollectionHumanBeing collectionHumanBeing) {
        manager = new CommandManager(
                new HelpCommand(CommandManager.AVAILABLE_COMMANDS),
                new InfoCommand(collectionHumanBeing),
                new ShowCommand(collectionHumanBeing),
                new AddCommand(collectionHumanBeing),
                new UpdateCommand(collectionHumanBeing),
                new RemoveByIdCommand(collectionHumanBeing),
                new ClearCommand(collectionHumanBeing),
                new SaveCommand(collectionHumanBeing),
                new ExecuteScriptCommand(),
                new ExitCommand(),
                new RemoveHeadCommand(collectionHumanBeing),
                new RemoveLoverCommand(collectionHumanBeing),
                new HistoryCommand(CommandManager.commandHistory.getHistory()),
                new RemoveAllByMinutesOfWaitingCommand(collectionHumanBeing),
                new SumOfMinutesOfWaitingCommand(collectionHumanBeing),
                new CountByImpactSpeedCommand(collectionHumanBeing));
    }

    /**
     * Метод, считывающий команды с консоли и вызывающий их выполнение
     */
    public void readCommandsFromConsole() {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque deque = null;
        while (isRunning) {
            try {
                System.out.print("Введите команду: ");
                String string = scanner.nextLine();
                manager.performCommand(string, null);
            } catch (NoSuchElementException e) {
                System.out.println("Введен недопустимый символ");
                System.exit(0);
            }
        }
    }
}
