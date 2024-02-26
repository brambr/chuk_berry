package entities;

public class CryptoKey {
    private int key;
    private int keyOffSet;
    private int currentAlphabetLength;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getKeyOffSet(Alphabet currentAlphabet) {

        calcKeyOffSet(currentAlphabet.getSizeOfAlphabet());

        return keyOffSet;
    }

    private void calcKeyOffSet(int alphabetLength) {
        this.currentAlphabetLength = alphabetLength;

        if(key>=0 & key <=currentAlphabetLength)this.keyOffSet = key;
        else{
                if (key>currentAlphabetLength){

                    int result;
                    int i=1;
                    do {
                        result = key - (currentAlphabetLength* i++);
                    }
                    while (currentAlphabetLength <=result);
                    keyOffSet=result;
                }
                if (key<0) {

                    int result;
                    do {
                        result = currentAlphabetLength + key;
                    }
                    while ((key + result) > 0);
                    keyOffSet = result;
                }
            }


        }

    }

