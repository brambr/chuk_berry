package entities;

import java.util.ArrayList;
import java.util.List;

public class DataSet {
    private  List<String> inboundStrings;


    private  List<String> outboundStrings;
   private  ArrayList<DataElement> arrayOfDataElements= new ArrayList<DataElement>();
    private DataElement currentDataElement;
    private CryptoKey currentCryptoKey;


    public void setOutboundStrings(List<String> outboundStrings) {
        this.outboundStrings = outboundStrings;
    }

    public List<String> getOutboundStrings() {
        return outboundStrings;
    }

    public List<String> getInboundStrings() {
        return inboundStrings;
    }

    public void setInboundStrings(List<String> inboundStrings) {
        this.inboundStrings = inboundStrings;
    }

    public ArrayList<DataElement> getDataElementArray() {
        return arrayOfDataElements;
    }

    public void setDataElementArray(ArrayList<DataElement> dataElementArray) {
        this.arrayOfDataElements = dataElementArray;
    }
    public void addDataElementToArray(DataElement dataElement) {
        this.currentDataElement=dataElement;
        arrayOfDataElements.add(currentDataElement);
    }


    public CryptoKey getCurrentCryptoKey() {
        return currentCryptoKey;
    }

    public void setCurrentCryptoKey(CryptoKey currentCryptoKey) {
        this.currentCryptoKey = currentCryptoKey;
    }
}
