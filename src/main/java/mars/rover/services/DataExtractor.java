package mars.rover.services;

import mars.rover.models.IPosition;
import mars.rover.models.impl.Action;
import mars.rover.models.impl.Plateau;
import mars.rover.models.impl.Position;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class DataExtractor {

    public static void extractDataFromFile(String filePath){
        File inputFile = new File(filePath);
        if (inputFile.exists() && inputFile.isFile()){
            try {
                Stream<String> lines = Files.lines(inputFile.toPath());
                AtomicReference<Plateau> plateau = new AtomicReference<>();
                AtomicReference<IPosition> position = new AtomicReference<>();
                lines.forEach(line -> {
                    String[] coordinates = line.split(" ");
                    if(coordinates.length == 2){
                        plateau.set(new Plateau(Integer.valueOf(coordinates[0]), Integer.valueOf(coordinates[1])));
                    } else if(Character.isDigit(line.charAt(0))){
                        position.set(new Position(Integer.valueOf(coordinates[0]), Integer.valueOf(coordinates[1]), Position.Direction.valueOf(coordinates[2])));
                    } else {
                        IPosition rover = position.get().move(new Action(line), plateau.get());
                        System.out.println("X position : " + rover.getXposition() + ", Y Position : "
                                + rover.getYposition() + ", Heading : " + rover.getHeading());
                    }
                });
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("The file does not exist or not a file !!");
        }
    };
}
