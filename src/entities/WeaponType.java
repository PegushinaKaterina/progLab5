package entities;

/**
 * Класс оружия, которым владеет человек
 */
public enum WeaponType {
    PISTOL,
    SHOTGUN,
    BAT;

    public static String show() {
        StringBuilder string = new StringBuilder();
        for (WeaponType i : values()) {
            string.append(i);
            string.append("\n");
        }
        return string.toString();
    }
}