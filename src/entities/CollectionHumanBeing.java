package entities;

import workingWithFiles.FileWorker;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * Класс коллекции
 */
public class CollectionHumanBeing {
    public Date creationDate;
    LinkedList<HumanBeing> collectionHumanBeing = new LinkedList<>();
    FileWorker fileWorker;

    /**
     * Конструктор коллекции
     *
     * @param fileWorker - объект для работы с файлом
     * @throws FileNotFoundException
     */
    public CollectionHumanBeing(FileWorker fileWorker) throws FileNotFoundException {
        creationDate = new Date();
        this.fileWorker = fileWorker;
    }

    public LinkedList<HumanBeing> getCollectionHumanBeing() {
        return collectionHumanBeing;
    }

    public FileWorker getFileWorker() {
        return fileWorker;
    }

    /**
     * Метод info
     *
     * @return информация о коллекции (тип, дата инициализации, количество элементов и т.д.)
     */
    public String info() {
        return "Информация о коллекции:" +
                "\nКласс коллекции: " + collectionHumanBeing.getClass().toString() +
                "\nДата создания: " + creationDate +
                "\nРазмер коллекции: " + collectionHumanBeing.size() +
                "\nКласс экземпляров коллекции" + HumanBeing.class;
    }

    /**
     * Метод show
     *
     * @return все элементы коллекции в строковом представлении
     */
    public String show() {
        String string = "";
        if (collectionHumanBeing.isEmpty()) {
            throw new IllegalArgumentException("Коллекция пуста");
        } else {
            for (int i = 0; i < collectionHumanBeing.size(); i++) {
                string += collectionHumanBeing.get(i).toString() + "\n";
            }
        }
        return string;
    }

    /**
     * Метод add - добавить новый элемент в коллекцию
     *
     * @param humanBeing - человек для добавления
     * @return сообщение о результате добавления
     */
    public String add(HumanBeing humanBeing) {
        collectionHumanBeing.add(humanBeing);
        collectionHumanBeing = collectionHumanBeing
                .stream()
                .sorted()
                .collect(Collectors.toCollection(LinkedList::new));
        return "\n Человек успешно добавлен";
    }

    /**
     * Метод update - обновить значение элемента коллекции, id которого равен заданному
     *
     * @param id
     * @param element - новое значение элемента колекции
     * @return сообщение о результате обновления
     */
    public String update(long id, HumanBeing element) {
        if (collectionHumanBeing.isEmpty()) {
            throw new IllegalArgumentException("Коллекция пуста");
        } else {
            boolean found = false;
            for (int i = 0; i < collectionHumanBeing.size(); i++) {
                if (collectionHumanBeing.get(i).getId() == id) {
                    collectionHumanBeing.set(i, element);
                }
                found = true;
                break;
            }
            collectionHumanBeing = collectionHumanBeing
                    .stream()
                    .sorted()
                    .collect(Collectors.toCollection(LinkedList::new));
            if (found == false) {
                throw new IllegalArgumentException("Элементов со значением id = " + id + " не найдено");
            } else {
                return "Значение элемента коллекции, id которого равен " + id + " успешно обновлено";
            }
        }
    }

    /**
     * Метод remove_by_id - удалить элемент из коллекции по его id
     *
     * @param id
     * @return сообщение о результате удаления
     */
    public String removeById(Long id) {

        if (collectionHumanBeing.isEmpty()) {
            throw new IllegalArgumentException("Коллекция пуста");
        } else {
            boolean found = false;
            for (int i = 0; i < collectionHumanBeing.size(); i++) {
                if (collectionHumanBeing.get(i).getId() == id) {
                    collectionHumanBeing.remove(i);
                    found = true;
                    break;
                }
            }
            if (!found) {
                throw new IllegalArgumentException("Элементов со значением id = " + id + " не найдено");
            } else {
                return "Элемент со значением id = " + id + " успешно удален";
            }
        }
    }

    /**
     * Метод clear - очистить коллекцию
     *
     * @return сообщение о результате очистки
     */
    public String clear() {
        if (collectionHumanBeing.isEmpty()) {
            return "Коллекция уже пуста";
        } else {
            collectionHumanBeing.clear();
            return "Коллекция успешно очищена";
        }

    }

    /**
     * Метод remove_head - вывести первый элемент коллекции и удалить его
     *
     * @return Первый элемент коллекции в строковом представлении с сообщением о результате удаления
     */
    public String removeHead() {
        if (collectionHumanBeing.isEmpty()) {
            throw new IllegalArgumentException("Коллекция пуста");
        } else {
            return "Первый элемент коллекции: " + collectionHumanBeing.poll() + "\nуспешно удален";
        }
    }

    /**
     * Метод remove_lower - удалить из коллекции все элементы, меньшие, чем заданный
     *
     * @param humanBeing - человек для сравнения
     * @return сообщение о результате удаления
     */
    public String removeLover(HumanBeing humanBeing) {
        if (collectionHumanBeing.isEmpty()) {
            throw new IllegalArgumentException("Коллекция пуста");
        } else {
            boolean found = false;
            for (int i = 0; i < collectionHumanBeing.size(); i++) {
                if (collectionHumanBeing.get(i).compareTo(humanBeing) == -1) {
                    collectionHumanBeing.remove(i);
                    found = true;
                } else {
                    break;
                }
            }
            if (found == false) {
                throw new IllegalArgumentException("Элементов, меньших, чем заданный, не найдено");
            } else {
                return "Элементы, меньшие, чем заданный, успешно удалены";
            }
        }
    }

    /**
     * Метод remove_all_by_minutes_of_waiting - удалить из коллекции все элементы, значение поля minutesOfWaiting которого эквивалентно заданному
     *
     * @param minutesOfWaiting - значение для сравнения
     * @return сообщение о результате удаления
     */
    public String removeAllByMinutesOfWaiting(int minutesOfWaiting) {
        if (collectionHumanBeing.isEmpty()) {
            throw new IllegalArgumentException("Коллекция пуста");
        } else {
            boolean found = false;
            for (int i = 0; i < collectionHumanBeing.size(); i++) {
                if (collectionHumanBeing.get(i).getMinutesOfWaiting() == minutesOfWaiting) {
                    collectionHumanBeing.remove(i);
                    found = true;
                }
            }
            if (found == false) {
                throw new IllegalArgumentException("Элементов со значением ВРЕМЯ ОЖИДАНИЯ = " + minutesOfWaiting + " не найдено");
            } else {
                return "Элементы со значением ВРЕМЯ ОЖИДАНИЯ = " + minutesOfWaiting + " успешно удалены";
            }
        }
    }

    /**
     * Метод sum_of_minutes_of_waiting
     *
     * @return сумма значений поля minutesOfWaiting для всех элементов коллекции
     */
    public String sumOfMinutesOfWaiting() {
        if (collectionHumanBeing.isEmpty()) {
            throw new IllegalArgumentException("Коллекция пуста");
        } else {
            int sumOfMinutesOfWaiting = 0;
            for (int i = 0; i < collectionHumanBeing.size(); i++) {
                sumOfMinutesOfWaiting += collectionHumanBeing.get(i).getMinutesOfWaiting();
            }
            return "Сумма значений поля ВРЕМЯ ОЖИДАНИЯ для всех элементов коллекции = " + sumOfMinutesOfWaiting;
        }
    }

    /**
     * Метод count_by_impact_speed - вывести количество элементов, значение поля impactSpeed которых равно заданному
     *
     * @param impactSpeed значение для сравнения
     * @return количество элементов
     */
    public String countByImpactSpeed(double impactSpeed) {
        if (collectionHumanBeing.isEmpty()) {
            throw new IllegalArgumentException("Коллекция пуста");
        } else {
            int countByImpactSpeed = 0;
            for (int i = 0; i < collectionHumanBeing.size(); i++) {
                if (collectionHumanBeing.get(i).getImpactSpeed() == impactSpeed) {
                    countByImpactSpeed++;
                }
            }
            if (countByImpactSpeed == 0) {
                throw new IllegalArgumentException("Элементов со значением СКОРОСТЬ УДАРА = " + impactSpeed + " не найдено");
            } else {
                return "Количество элементов, у которых значение поля СКОРОСТЬ УДАРА = " + impactSpeed + ": " + countByImpactSpeed;
            }
        }
    }
}