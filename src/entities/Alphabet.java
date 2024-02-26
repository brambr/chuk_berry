package entities;

public class Alphabet {
    private static final char[] ALPHABET = {' ','а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','й','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь','э','ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?'};
    private int charIndex;
    private char currentChar;
    public char getCharByIndex(int index){
        this.charIndex=index;
        char symbol=ALPHABET[charIndex];
        return symbol;
    }
    public int getSizeOfAlphabet(){
        int length = ALPHABET.length;
        return length;
        
    }
    public int getIndexByChar (char currentChar){
        this.currentChar=currentChar;
        int charIndex = 0;
        for (int i = 0; i < ALPHABET.length; i++) {
            if(currentChar== ALPHABET[i]){
                charIndex =i;
            }
        }
        return charIndex;
    }
}
