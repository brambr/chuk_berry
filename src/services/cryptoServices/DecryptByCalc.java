package services.cryptoServices;

import entities.DataElement;
import entities.DataSet;
import services.serviceManagers.DataManager;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DecryptByCalc {
    public void run() throws FileNotFoundException {
        System.out.println("DecryptByCalc is running");
        DataManager dataManager = new DataManager();
        dataManager.loadInitialDataFromFile();
        char topChar = findMaxOftenChar(convertDataElementInitialSymbolsToArray(dataManager.getCurrentDataSet()));



        dataManager.setActualCryptoKey(dataManager.getActualAlphabet().getIndexByChar(topChar));

        DecryptByKey decryptByKey=new DecryptByKey();
        decryptByKey.decrypt(dataManager);

        dataManager.convertHandledDataToStrings();
        dataManager.uploadHendledDataToFile();
    }
    private ArrayList<Character> convertDataElementInitialSymbolsToArray(DataSet currentDataset){
        ArrayList<Character> currentCharList=new ArrayList<>();
        for(DataElement currentDataElement: currentDataset.getDataElementArray()){
            currentCharList.add(currentDataElement.getDataElementInitialValue());
        }
        return currentCharList;
    }


    private char findMaxOftenChar(List<Character> arrayList){
        int maxRate=0;
        char finalChar='&';
        for (int i = 0; i < arrayList.size(); i++) {
            char currentChar='&';
            int currentRate=0;
            for (int j = 0; j < arrayList.size(); j++) {
                if(arrayList.get(i).equals(arrayList.get(j))){
                    currentRate= currentRate +1;
                    currentChar=arrayList.get(i);
                }
            }
            if (maxRate<currentRate){
                maxRate=currentRate;
                finalChar=currentChar;
            }

        }

        return finalChar;
    }
}
