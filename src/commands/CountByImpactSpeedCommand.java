package commands;

import entities.CollectionHumanBeing;
import entities.HumanBeing;
import parsers.Parser;
import validators.Validator;

import java.util.ArrayDeque;

/**
 * Класс команды: count_by_impact_speed impactSpeed : вывести количество элементов, значение поля impactSpeed которых равно заданному
 */
public class CountByImpactSpeedCommand extends AbstractCommand {
    private final CollectionHumanBeing collectionHumanBeing;

    public CountByImpactSpeedCommand(CollectionHumanBeing collectionHumanBeing) {
        super("count_by_impact_speed", 1,
                "вывести количество элементов, значение поля СКОРОСТЬ УДАРА которых равно заданному. ",
                "Значение поля СКОРОСТЬ УДАРА - вещественное число, которое больше чем -484");
        this.collectionHumanBeing = collectionHumanBeing;
    }

    @Override
    public void executeCommand(String[] commandArgs, ArrayDeque<String> commands) {
        try {
            Validator.validateQuantityOfArgs(commandArgs, getQuantityOfArgs());
            Double impactSpeed = Parser.valueParser(commandArgs[0],
                    "значение должно быть вещественным числом и больше " + HumanBeing.IMPACT_SPEED_MIN,
                    false,
                    Double::parseDouble,
                    arg -> (Double) arg > HumanBeing.IMPACT_SPEED_MIN,
                    "Значение должно быть больше " + HumanBeing.IMPACT_SPEED_MIN);
            System.out.println(collectionHumanBeing.countByImpactSpeed(impactSpeed));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
