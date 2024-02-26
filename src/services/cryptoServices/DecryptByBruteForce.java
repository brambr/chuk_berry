package services.cryptoServices;

import entities.CryptoKey;
import entities.DataElement;
import services.serviceManagers.DataManager;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class DecryptByBruteForce {
    private static final String resultCheck1 =", ";
    private List<Integer> keyDecryptionValue=  new ArrayList<>();

    public void run() throws FileNotFoundException {

        System.out.println("DecryptByBruteForce is running");
        DataManager dataManager = new DataManager();
        dataManager.loadInitialDataFromFile();

        dataManager.setActualCryptoKey(bruteforce(dataManager));

        DecryptByKey decryptByKey=new DecryptByKey();
        decryptByKey.decrypt(dataManager);

        dataManager.convertHandledDataToStrings();
        dataManager.uploadHendledDataToFile();
    }
    private int bruteforce(DataManager dataManager) {

        CryptoKey actualCryptoKey = new CryptoKey();
        DecryptByKey decryptByKey= new DecryptByKey();
        for (int i = 0; i < dataManager.getActualAlphabet().getSizeOfAlphabet(); i++) {

                actualCryptoKey.setKey(i);
                actualCryptoKey.getKeyOffSet(dataManager.getActualAlphabet());

            DataElement currentDataElement1 ;
            DataElement currentDataElement2 ;

            char newSymbol1;
            char newSymbol2;

            StringBuilder result= new StringBuilder();
            for (int j = 0; j < dataManager.getCurrentDataSet().getDataElementArray().size()-1; j++) {

                currentDataElement1 = dataManager.getDataElementByIndex(j);

                if (j == dataManager.getCurrentDataSet().getDataElementArray().size()) {
                    currentDataElement2 = dataManager.getDataElementByIndex(j);
                }
                else {
                    currentDataElement2 = dataManager.getDataElementByIndex(j+1);
                }
                decryptByKey.decryptDataElement(currentDataElement1,dataManager.getActualAlphabet(), actualCryptoKey );
                decryptByKey.decryptDataElement(currentDataElement2,dataManager.getActualAlphabet(), actualCryptoKey );

                newSymbol1 = currentDataElement1.getDataElementUpdatedValue();
                newSymbol2 = currentDataElement2.getDataElementUpdatedValue();

                result.append(newSymbol1);
                result.append(newSymbol2);

                if (result.toString().equals(resultCheck1)){
                    this.keyDecryptionValue.add(i);
                }
                result.delete(0, result.length());
            }
        }
        return findMaxOftenNumber(keyDecryptionValue);
    }
    private int findMaxOftenNumber(List<Integer> arrayList){
            int maxRate=0;
            int finalNumber=0;
        for (int i = 0; i < arrayList.size(); i++) {
            int currentNumber=0;
            int currentRate=0;
            for (int j = 0; j < arrayList.size(); j++) {
                if(arrayList.get(i).equals(arrayList.get(j))){
                    currentRate= currentRate +1;
                    currentNumber=arrayList.get(i);
                }
            }
            if (maxRate<currentRate){
                maxRate=currentRate;
                finalNumber=currentNumber;
            }

        }

        return finalNumber;
    }



}
