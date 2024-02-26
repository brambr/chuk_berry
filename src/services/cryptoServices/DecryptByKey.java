package services.cryptoServices;

import entities.Alphabet;
import entities.CryptoKey;
import entities.DataElement;
import services.serviceManagers.DataManager;

import java.io.FileNotFoundException;

public class DecryptByKey {
    public void run() throws FileNotFoundException {

        System.out.println("DecriptByKey is running");
        DataManager dataManager = new DataManager();
        dataManager.loadInitialDataFromFile();
        dataManager.loadCryptoKey();
        decrypt(dataManager);
        dataManager.convertHandledDataToStrings();
        dataManager.uploadHendledDataToFile();
    }

    public void decrypt(DataManager dataManager) {

        for (DataElement currentDataElement : dataManager.getCurrentDataSet().getDataElementArray()) {
            decryptDataElement(currentDataElement, dataManager.getActualAlphabet(), dataManager.getActualCryptoKey());
        }
    }
    public void decryptDataElement(DataElement dataElement, Alphabet alphabet, CryptoKey cryptoKey){
            DataElement currentDataElement;
            currentDataElement= dataElement;

            Alphabet actualAlphabet;
            actualAlphabet=alphabet;

            CryptoKey actualCryptoKey;
            actualCryptoKey=cryptoKey;

        if (currentDataElement.isBelongsToAlphabet()) {

            int newAlphabetSymbolIndex = currentDataElement.getAlphabetSymbolIndex() - actualCryptoKey.getKeyOffSet(alphabet);
            if (newAlphabetSymbolIndex < 0) {
                newAlphabetSymbolIndex = newAlphabetSymbolIndex + actualAlphabet.getSizeOfAlphabet();
            }
            char newSymbol = actualAlphabet.getCharByIndex(newAlphabetSymbolIndex);
            currentDataElement.setDataElementUpdatedValue(newSymbol);

        } else {
            currentDataElement.setDataElementUpdatedValue('#');

        }
    }


}
