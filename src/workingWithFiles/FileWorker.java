package workingWithFiles;

import entities.CollectionHumanBeing;
import parsers.Parser;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Класс для работы с файлом, в котором хранится коллекция
 */
public class FileWorker {
    private final File file;
    /**
     * Конструктор, создающий объект класса для работы с файлом коллекции
     *
     * @param fileName - имя файла, в котором хранится изначальная коллекция
     * @throws FileNotFoundException
     */
    public FileWorker(String fileName) throws FileNotFoundException {
        file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException("Файл не найден");
        } else {
            if(!file.canRead()){
                throw new FileNotFoundException("Нет доступа на чтение");
            }
            else if (!file.canWrite()){
                throw new FileNotFoundException("Нет доступа на запись");
            }
        }
    }

    /**
     * Метод для чтения скрипта из файла
     *
     * @param fileName - имя файла, в котором хранится скрипт
     * @return Очередь, в которой хранятся команды в стороком представлении
     * @throws FileNotFoundException
     */
    public static ArrayDeque<String> readScript(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException("Файл не найден");
        } else if(!file.canRead()){
            throw new FileNotFoundException("Нет доступа на чтение");
        } else {
            Scanner scanner = new Scanner(file);
            try (scanner){
                ArrayDeque<String> deque = new ArrayDeque<String>();
                do {
                    String string = scanner.nextLine();
                    deque.add(string);
                } while (scanner.hasNextLine());
                return deque;
            }
        }
    }

    /**
     * Метод для чтения файла, в котором хранится коллекция
     *
     * @return Очередь, в которой хранятся элементы коллекции в строковом представлении
     */
    public ArrayDeque<String> fileReader() throws FileNotFoundException{
        ArrayDeque<String> deque = new ArrayDeque<String>();
        Scanner scanner = new Scanner(file);
        try (scanner) {
            do {
                String string = scanner.nextLine();
                deque.add(string);
            } while (scanner.hasNextLine());
            return deque;
        }
    }

    /**
     * Метод для записи коллекции в файл
     *
     * @param collectionHumanBeing - коллекция, записываемая в файл
     * @throws IOException
     */
    public void fileWriter(CollectionHumanBeing collectionHumanBeing) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        try (fileOutputStream; outputStreamWriter){
            for (int i = 0; i < collectionHumanBeing.getCollectionHumanBeing().size(); i++) {
                String string = Parser.humanBeingToStringParser(collectionHumanBeing.getCollectionHumanBeing().get(i));
                outputStreamWriter.write(string);
            }
        }
    }
}
