package commands;

import java.util.ArrayDeque;

/**
 * Абстрактный класс, описывающий общие характеристики всех команд
 */
public abstract class AbstractCommand {
    private static boolean executedScript = false;
    private final String name; // Имя
    private final int quantityOfArgs; // Количество аргументов
    private final String description; // Описание
    private final String descriptionOfArgs; // Описание аргументов

    public AbstractCommand(String name, int quantityOfArgs, String description, String descriptionOfArgs) {
        this.name = name;
        this.quantityOfArgs = quantityOfArgs;
        this.description = description;
        this.descriptionOfArgs = descriptionOfArgs;
    }

    public AbstractCommand(String name, int quantityOfArgs, String description) {
        this.name = name;
        this.quantityOfArgs = quantityOfArgs;
        this.description = description;
        this.descriptionOfArgs = "";
    }

    public abstract void executeCommand(String[] commandArgs, ArrayDeque<String> commands);
    public boolean getExecutedScript() {
        return executedScript;
    }
    public void setExecutedScript(boolean executedScript) {
        this.executedScript = executedScript;
    }

    public String getName() {
        return name;
    }

    public int getQuantityOfArgs() {
        return quantityOfArgs;
    }

    public String getDescription() {
        return description;
    }

    public String getDescriptionOfArgs() {
        return descriptionOfArgs;
    }

    @Override
    public String toString() {
        if (quantityOfArgs == 0) {
            return name + " - " + description;
        } else {
            return name + " - " + description +
                    "\n     Аргументы: " + descriptionOfArgs;
        }
    }
}

