package edu.wit.comp1050;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Mastermind {
    public static void main(String[] args) {
        boolean gameRunning = true;
        var code = createCode(getDupe());
        int trial = 0;
        while (gameRunning) {
            System.out.println("Trial #" + (trial + 1));
            var guess = getGuess(code);
            if (getConfirm()) {
                checkDirect(code, guess);
                checkColor(code, guess);
                System.out.println(Arrays.toString(guess));
                System.out.println("Direct Match: " + checkDirect(code, guess) + " | Color Match: " + checkColor(code, guess));
                trial++;
                if (trial > 8) {
                    System.out.println("YOU RAN OUT OF TRIES!!!!");
                    gameRunning = false;
                }
                if (checkDirect(code, guess) == 4) {
                    System.out.println("YOU WON!!!!!");
                    gameRunning = false;
                }
            }
        }
    }

    public static String[] createCode(boolean dupeAllow) {
        String allCombos = "roygbp";
        String[] code = new String[4];
        if (dupeAllow) {
            for (int i = 0; i < code.length; i++) {
                Random choose = new Random();
                int index = choose.nextInt(allCombos.length());
                code[i] = allCombos.substring(index, index + 1);
            }
        } else {
            Random choose = new Random();
            ArrayList<Integer> arrayList = new ArrayList<>();
            while (arrayList.size() < 4) {
                int a = choose.nextInt(allCombos.length());
                if (!arrayList.contains(a)) {
                    arrayList.add(a);
                }
            }
            for (int i = 0; i < code.length; i++) {
                code[i] = allCombos.substring(arrayList.get(i), arrayList.get(i) + 1);
            }
        }
        System.out.println(Arrays.toString(code));
        return code;
    }

    public static boolean getConfirm() {
        boolean ret = false;
        Scanner sys = new Scanner(System.in);
        System.out.println("Do you want to check your code, Yes or No?");
        String line = sys.nextLine();
        if (line.toLowerCase().equals("yes")) {
            ret = true;
        }
        return ret;
    }

    public static boolean getDupe() {
        boolean ret = true;
        Scanner sys = new Scanner(System.in);
        System.out.println("Do you want there to be duplicates, Yes or No?");
        String line = sys.nextLine();
        if (line.toLowerCase().equals("no")) {
            ret = false;
        }
        return ret;
    }

    public static String[] getGuess(String[] code) {
        Scanner sys = new Scanner(System.in);
        String[] enter = new String[code.length];
        for (int i = 0; i < code.length; i++) {
            System.out.println("Type the #" + (i + 1) + " Code");
            enter[i] = sys.nextLine().substring(0, 1);
        }
        return enter;
    }

    public static int checkDirect(String[] code, String[] guess) {
        int direct = 0;
        String[] ret = new String[code.length];
        Arrays.fill(ret, "");
        for (int i = 0; i < code.length; i++) {
            if (code[i].equals(guess[i])) {
                ret[i] = "direct";
            }
        }
        for (String s : ret) {
            if (s.equals("direct")) {
                direct++;
            }
        }
        return direct;
    }

    public static int checkColor(String[] code, String[] guess) {
        int color = 0;
        String[] ret = new String[code.length];
        Arrays.fill(ret, "");
        for (int i = 0; i < code.length; i++) {
            if (code[i].equals(guess[i])) {
                ret[i] = "direct";
            }
        }
        for (int i = 0; i < code.length; i++) {
            for (int j = 0; j < code.length; j++) {
                if (guess[i].equals(code[j]) && !ret[j].equals("direct") && !ret[i].equals("direct")) {
                    ret[j] = "color";
                }
            }
        }
        for (String s : ret) {
            if (s.equals("color")) {
                color++;
            }
        }
        return color;
    }
}