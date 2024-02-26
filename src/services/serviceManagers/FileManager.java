package services.serviceManagers;

import entities.DataSet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    
    
    public List<String>  readFromFile() {
      Path filePathForReading = getFilePath(requestFileNameForLoading());


        File fileForReading = new File(filePathForReading.toString() );
        List<String> strings = new ArrayList<>();

        try (Scanner fileScanner = new Scanner(fileForReading)) {


            while (fileScanner.hasNextLine()) {
                String currentLineFromFile = fileScanner.nextLine();
                strings.add(currentLineFromFile);

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        }

        return strings;

    }



    public void  writeToFile (DataSet currrentDataSet) {
        Path filePathForWriting = getFilePath(requestFileNameForUploading());
        File fileForWriting = new File(filePathForWriting.toString());
        List<String> strings = new ArrayList<>();
        strings  = currrentDataSet.getOutboundStrings();
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(fileForWriting);
            for(int i=0; i<currrentDataSet.getOutboundStrings().size();i++){
                fileWriter.write(strings.get(i));
                fileWriter.write("\n");
            }
            fileWriter.close();

        } catch (IOException e) {
            System.out.println("Возникла ошибка во время записи, проверьте данные.");
        }


    }
    private Path getFilePath( String fileNameValue) {
        Path filePath = Path.of(fileNameValue).toAbsolutePath();

        return filePath;
    }

    private String requestFileNameForLoading(){
        System.out.println("Введите имя файла для загрузки ");
        ConsoleManager actualConsoleManager = new ConsoleManager();
        String fileNameValue = actualConsoleManager.getConsoleStringValue();// добавить проверку на корректность имени файла

        return fileNameValue ;

    }
    private String requestFileNameForUploading(){
        System.out.println("Введите имя файла для выгрузки ");
        ConsoleManager actualConsoleManager = new ConsoleManager();
        String fileNameValue = actualConsoleManager.getConsoleStringValue();// добавить проверку на корректность имени файла

        return fileNameValue ;

    }

}
