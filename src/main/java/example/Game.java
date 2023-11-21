package example;

import java.util.Scanner;

public class Game {
    private final Box box = new Box();

    private static final Scanner scan = new Scanner(System.in);

    public void play() {
        box.printStartInfo();

        while (true) {
            box.printBoxInfo();
            final ResultGame result = playStrategy();
            if (result != ResultGame.GOING) {
                box.printBoxInfo();
                writeResultGame(result);
                return;
            }
        }
    }

    private void writeResultGame(final ResultGame variant) {
        if (ResultGame.WON.equals(variant)) {
            System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
        } else if (ResultGame.LOST.equals(variant)) {
            System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
        } else if (ResultGame.DRAW.equals(variant)) {
            System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
        }
        if(scan != null){
            scan.close();
        }
    }

    private byte input() {
        while (true) {
            final byte input = scan.nextByte();
            if (input > 0 && input < 10) {
                if (box.isBoxFull((byte) (input - 1)))
                    System.out.println("That one is already in use. Enter another.");
                else {
                    return  input;
                }
            } else
                System.out.println("Invalid input. Enter again.");
        }
    }

    private boolean playHuman() {
        byte input = input();
        box.fillBox((byte) (input - 1), 'X');

        return box.checkFinalCombination('X');
    }
    private byte doPC() {
        while (true) {
            final byte rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (box.isBoxEmpty(((byte) (rand - 1)))) {
                return rand;
            }
        }
    }

    private boolean playPC() {
        byte rnd = doPC();
        box.fillBox((byte) (rnd - 1), 'O');

        return box.checkFinalCombination('O');
    }

    private boolean checkDraw() {
        for (byte i = 0; i < 9; i++) {
            if (box.isBoxEmpty(i)) {
                return false;
            }
        }
        return true ;
    }

       private ResultGame playStrategy() {
        if (playHuman()) {
            return ResultGame.WON;
        } else if (checkDraw()) {
            return ResultGame.DRAW;
        } else if (playPC()) {
            return ResultGame.LOST;
        } else return ResultGame.GOING;
    }



}

