package entities;

public class DataElement {

        private char dataElementInitialValue;
        private boolean belongsToAlphabet;
        private int alphabetSymbolIndex;
        private char dataElementUpdatedValue;

    public char getDataElementUpdatedValue() {
        return dataElementUpdatedValue;
    }

    public void setDataElementUpdatedValue(char dataElementUpdatedValue) {
        this.dataElementUpdatedValue = dataElementUpdatedValue;
    }

    public int getAlphabetSymbolIndex() {
            return alphabetSymbolIndex;
        }

        public void setAlphabetSymbolIndex(int alphabetSymbolIndex) {
            this.alphabetSymbolIndex = alphabetSymbolIndex;
        }



        public char getDataElementInitialValue() {

            return dataElementInitialValue;
        }
        public void setDataElementInitialValue(char dataElementInitialValue) {

            this.dataElementInitialValue = dataElementInitialValue;
        }

        public boolean isBelongsToAlphabet() {

            return belongsToAlphabet;
        }
        public void setBelongsToAlphabet(boolean belongsToAlphabet) {

            this.belongsToAlphabet = belongsToAlphabet;
        }




}
