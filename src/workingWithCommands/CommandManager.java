package workingWithCommands;

import commands.AbstractCommand;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;

/**
 * Менеджер для работы с командами
 */
public class CommandManager {
    public static final HashMap<String, AbstractCommand> AVAILABLE_COMMANDS = new HashMap<>();
    public static CommandHistory commandHistory = new CommandHistory();

    /**
     * Конструктор, создающий Менеджер для работы с командами
     *
     * @param helpCommand                 - экземпляр команды help
     * @param infoCommand                 - экземпляр команды infoCommand
     * @param showCommand                 - экземпляр команды showCommand
     * @param addCommand                  - экземпляр команды addCommand
     * @param updateCommand               - экземпляр команды updateCommand
     * @param removeByIdCommand           - экземпляр команды removeByIdCommand
     * @param clearCommand                - экземпляр команды clearCommand
     * @param saveCommand                 - экземпляр команды saveCommand
     * @param executeScriptCommand        - экземпляр команды executeScriptCommand
     * @param exitCommand                 - экземпляр команды exitCommand
     * @param removeHead                  - экземпляр команды removeHead
     * @param removeLower                 - экземпляр команды removeLower
     * @param historyCommand              - экземпляр команды historyCommand
     * @param removeAllByMinutesOfWaiting - экземпляр команды removeAllByMinutesOfWaiting
     * @param sumOfMinutesOfWaiting       - экземпляр команды sumOfMinutesOfWaiting
     * @param countByImpactSpeed          - экземпляр команды countByImpactSpeed
     */
    public CommandManager(AbstractCommand helpCommand,
                          AbstractCommand infoCommand,
                          AbstractCommand showCommand,
                          AbstractCommand addCommand,
                          AbstractCommand updateCommand,
                          AbstractCommand removeByIdCommand,
                          AbstractCommand clearCommand,
                          AbstractCommand saveCommand,
                          AbstractCommand executeScriptCommand,
                          AbstractCommand exitCommand,
                          AbstractCommand removeHead,
                          AbstractCommand removeLower,
                          AbstractCommand historyCommand,
                          AbstractCommand removeAllByMinutesOfWaiting,
                          AbstractCommand sumOfMinutesOfWaiting,
                          AbstractCommand countByImpactSpeed
    ) {
        AVAILABLE_COMMANDS.put(helpCommand.getName(), helpCommand);
        AVAILABLE_COMMANDS.put(infoCommand.getName(), infoCommand);
        AVAILABLE_COMMANDS.put(showCommand.getName(), showCommand);
        AVAILABLE_COMMANDS.put(addCommand.getName(), addCommand);
        AVAILABLE_COMMANDS.put(updateCommand.getName(), updateCommand);
        AVAILABLE_COMMANDS.put(removeByIdCommand.getName(), removeByIdCommand);
        AVAILABLE_COMMANDS.put(clearCommand.getName(), clearCommand);
        AVAILABLE_COMMANDS.put(saveCommand.getName(), saveCommand);
        AVAILABLE_COMMANDS.put(executeScriptCommand.getName(), executeScriptCommand);
        AVAILABLE_COMMANDS.put(exitCommand.getName(), exitCommand);
        AVAILABLE_COMMANDS.put(removeHead.getName(), removeHead);
        AVAILABLE_COMMANDS.put(removeLower.getName(), removeLower);
        AVAILABLE_COMMANDS.put(historyCommand.getName(), historyCommand);
        AVAILABLE_COMMANDS.put(removeAllByMinutesOfWaiting.getName(), removeAllByMinutesOfWaiting);
        AVAILABLE_COMMANDS.put(sumOfMinutesOfWaiting.getName(), sumOfMinutesOfWaiting);
        AVAILABLE_COMMANDS.put(countByImpactSpeed.getName(), countByImpactSpeed);

    }

    /**
     * Метод, выполняющий команду
     *
     * @param command - выполняемая команда, в строковом представлении
     */
    public void performCommand(String command, ArrayDeque<String> commands) {
        command = command.trim();
        String[] commandString = command.split(" ");
        String commandName = commandString[0].toLowerCase(Locale.ROOT);
        String[] commandsArgs = Arrays.copyOfRange(commandString, 1, commandString.length);
        if (AVAILABLE_COMMANDS.containsKey(commandName)) {
            AbstractCommand executingCommand = AVAILABLE_COMMANDS.get(commandName);
            executingCommand.executeCommand(commandsArgs, commands);
            commandHistory.pushCommand(commandName);
        } else {
            System.out.println("Такой команды не существует. Для справки введите команду help");
        }
    }
}
