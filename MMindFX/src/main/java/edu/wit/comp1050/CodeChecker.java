package edu.wit.comp1050;

import java.util.Arrays;

public class CodeChecker {
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
