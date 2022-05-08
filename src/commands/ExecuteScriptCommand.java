package commands;

import validators.Validator;
import workingWithCommands.CommandListener;
import workingWithFiles.FileWorker;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashSet;

/**
 * Класс команды: execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
 */
public class ExecuteScriptCommand extends AbstractCommand {
    HashSet<String> hashSet = new HashSet<String>();

    public ExecuteScriptCommand() {
        super("execute_script", 1,
                "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме",
                "название файла");
    }

    @Override
    public void executeCommand(String[] commandArgs, ArrayDeque<String> commandss) {
        setExecutedScript(true);
        try {
            Validator.validateQuantityOfArgs(commandArgs, getQuantityOfArgs());
            if (hashSet.contains(commandArgs[0])) {
                throw new IllegalArgumentException("Возможно зацикливание");
            }
            hashSet.add(commandArgs[0]);
            ArrayDeque<String> commands = FileWorker.readScript(commandArgs[0]);
            while (!commands.isEmpty()) {
                CommandListener.manager.performCommand(commands.remove(), commands);
            }
            hashSet.remove(commandArgs[0]);
            setExecutedScript(false);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setExecutedScript(false);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            setExecutedScript(false);
        }
    }
}
