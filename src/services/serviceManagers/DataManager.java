package services.serviceManagers;

import entities.CryptoKey;
import entities.DataElement;
import entities.DataSet;
import entities.Alphabet;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


public class DataManager {
    private final Alphabet actualAlphabet;
    private DataSet currentDataSet;
    private CryptoKey actualCryptoKey;

    public DataManager() {
        actualAlphabet  = new Alphabet();
        currentDataSet = new DataSet();
        actualCryptoKey = new CryptoKey();
    }

    public void loadInitialDataFromFile() throws FileNotFoundException {

        FileManager fileManager = new FileManager();
        currentDataSet.setInboundStrings(fileManager.readFromFile());
        fillDataSetByInitialData(currentDataSet);
    }

    public void convertHandledDataToStrings(){
        fillOutboundStringsOfDataSet();
    }
    public void uploadHendledDataToFile() throws FileNotFoundException {

        FileManager fileManager = new FileManager();
        fileManager.writeToFile(currentDataSet);
    }

    public void loadCryptoKey(){
        System.out.println("Введите ключ кодировки:");
        ConsoleManager currentConsoleManager= new ConsoleManager();
        actualCryptoKey.setKey(currentConsoleManager.getConsoleDigitValue());
        actualCryptoKey.getKeyOffSet(actualAlphabet);
    }

    public DataSet getCurrentDataSet() {
        return currentDataSet;
    }

    public Alphabet getActualAlphabet() {
        return actualAlphabet;
    }

    public CryptoKey getActualCryptoKey() {
        return actualCryptoKey;
    }

    public void setActualCryptoKey(int key) {
        this.actualCryptoKey.setKey(key);
    }

   public DataElement getDataElementByIndex(int index){
        return currentDataSet.getDataElementArray().get(index);
   }


    private void fillDataSetByInitialData(DataSet currentDataSet){

        for(String currentString: currentDataSet.getInboundStrings()) {
            for(char currentSymbol: currentString.toCharArray()){
                DataElement currentDataElement=new DataElement();
                currentDataElement.setDataElementInitialValue(currentSymbol);
                currentDataElement.setBelongsToAlphabet(belongsToAlphabetChecking(currentSymbol));
                currentDataElement.setAlphabetSymbolIndex( alphabetIndexForSymbol(currentSymbol));
                currentDataSet.addDataElementToArray(currentDataElement);
            }
        }
    }


    private  void fillOutboundStringsOfDataSet(){
        List<String> currentOutboundStringsArray = new ArrayList<>();
        int cursor=0;
        int startPosition=0;
        int endPosition;
        for(String currentString: currentDataSet.getInboundStrings()) {
            cursor += currentString.length();
            endPosition=cursor;
            StringBuilder currentOutboundString = new StringBuilder();
            for (int i=startPosition; i < endPosition;i++){

                currentOutboundString.append(currentDataSet.getDataElementArray().get(i).getDataElementUpdatedValue());
            }
            startPosition=cursor;
            currentOutboundStringsArray.add(currentOutboundString.toString());

        }
        currentDataSet.setOutboundStrings(currentOutboundStringsArray);

    }

    private boolean belongsToAlphabetChecking(char symbol){
        boolean result= false;
        for (int i=0; i<actualAlphabet.getSizeOfAlphabet(); i++){


            if (symbol == actualAlphabet.getCharByIndex(i)) {
                result = true;
                break;
            }

        }
        return result;
    }
    private int  alphabetIndexForSymbol(char symbol){
        int result=0;
        for (int i=0; i<actualAlphabet.getSizeOfAlphabet(); i++){

            if (symbol == actualAlphabet.getCharByIndex(i)) {
                result = i;
                break;
            }

        }
        return result;
    }


}
