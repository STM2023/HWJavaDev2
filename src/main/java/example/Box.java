package example;

public class Box {
    private char[] box =  { '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    private void cleanBox() {
        for (int i = 0; i < 9; i++)
            box[i] = ' ';
    }
    void printStartInfo(){

        System.out.println("Enter box number to select. Enjoy!\n");
        printBoxInfo();
        cleanBox();
    }
    void printBoxInfo() {
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }
    boolean checkFinalCombination(final char symbol) {

        if ((isRowFinal((byte) 0,(byte) 1,(byte) 2, symbol)) ||
                (isRowFinal((byte) 3,(byte) 4,(byte) 5, symbol)) ||
                (isRowFinal((byte) 6,(byte) 7,(byte) 8, symbol)) ||
                (isRowFinal((byte) 0,  (byte) 3,(byte) 6, symbol)) ||
                (isRowFinal( (byte) 1,(byte) 4, (byte) 7, symbol)) ||
                (isRowFinal((byte) 2, (byte) 5,(byte) 8, symbol)) ||
                (isRowFinal((byte) 0,(byte) 4,(byte) 8, symbol)) ||
                (isRowFinal((byte) 2,(byte) 4,(byte) 6, symbol))) {
            return true;
        }
        return false;
    }
    boolean isRowFinal( byte i, byte j, byte k,  char symbol) {
        return box[i] == symbol && box[j] == symbol && box[k] == symbol;
    }
    boolean isBoxEmpty( byte i) {
        return box[i] != 'X' && box[i] != 'O';
    }

    boolean isBoxFull( byte i) {
        return box[i] == 'X' || box[i] == 'O';
    }

    void fillBox( byte i,  char symbol) {
        box[i] = symbol;
    }
}

