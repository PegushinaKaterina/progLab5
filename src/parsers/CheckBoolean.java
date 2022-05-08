package parsers;

import java.util.Locale;

/**
 * Класс для конвертации строки в Boolean
 */
public class CheckBoolean {
    public static Boolean checkBoolean(String bool) {
        bool = bool.toLowerCase(Locale.ROOT);
        if (bool.equals("да") || bool.equals("true")) {
            return true;
        } else if (bool.equals("нет") || bool.equals("false")) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
