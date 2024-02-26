package services.cryptoServices;

import entities.DataElement;
import services.serviceManagers.DataManager;
import java.io.FileNotFoundException;

public class EncryptByKey {

    public EncryptByKey(){
    }
    public void run() throws FileNotFoundException {
        System.out.println("EncriptByKey is running");
        DataManager dataManager = new DataManager();
        dataManager.loadInitialDataFromFile();
        dataManager.loadCryptoKey();
        encript(dataManager);
        dataManager.convertHandledDataToStrings();
        dataManager.uploadHendledDataToFile();
    }
    private void encript(DataManager dataManager){

        for(DataElement currentDataElement: dataManager.getCurrentDataSet().getDataElementArray() ){

            if (currentDataElement.isBelongsToAlphabet()) {
                int newAlphabetSymbolIndex = currentDataElement.getAlphabetSymbolIndex() + dataManager.getActualCryptoKey().getKeyOffSet(dataManager.getActualAlphabet());
                if (newAlphabetSymbolIndex >= dataManager.getActualAlphabet().getSizeOfAlphabet()) {
                    newAlphabetSymbolIndex = newAlphabetSymbolIndex - dataManager.getActualAlphabet().getSizeOfAlphabet();
                }
                char newSymbol = dataManager.getActualAlphabet().getCharByIndex(newAlphabetSymbolIndex);
                currentDataElement.setDataElementUpdatedValue(newSymbol);
            }
            else{
                currentDataElement.setDataElementUpdatedValue('#');
            }
        }

    }
}
