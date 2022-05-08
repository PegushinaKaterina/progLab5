import generators.GeneratorCollectionHumanBeing;
import workingWithCommands.CommandListener;
import workingWithFiles.FileWorker;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //String fileName = args[0];
        String fileName = "file.txt";
        try {
            FileWorker fileWorker = new FileWorker(fileName);
            GeneratorCollectionHumanBeing collectionHumanBeing = new GeneratorCollectionHumanBeing(fileWorker);
            CommandListener commandListener = new CommandListener(collectionHumanBeing.getCollectionHumanBeing());
            commandListener.readCommandsFromConsole();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
