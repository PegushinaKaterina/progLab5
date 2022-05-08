package workingWithCommands;

import java.util.ArrayDeque;

/**
 * Класс истории команд
 */
public class CommandHistory {
    private final ArrayDeque<String> history = new ArrayDeque<>(9);
    private final int dequeOverflow = 11;

    public ArrayDeque<String> getHistory() {
        return history;
    }

    /**
     * Метод для добавления команды в историю
     *
     * @param name - имя команды
     */
    public void pushCommand(String name) {
        history.addFirst(name);
        if (history.size() == dequeOverflow) {
            history.remove();
        }
    }
}
