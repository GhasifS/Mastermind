package edu.wit.comp1050;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class CodeMaker {
    public static String[] createCode(boolean dupeAllow, boolean spaceAllow) {
        String allCombos = "roygbp";
        String[] code = new String[4];
        if (dupeAllow && !spaceAllow) {
            for (int i = 0; i < code.length; i++) {
                Random choose = new Random();
                int index = choose.nextInt(allCombos.length());
                code[i] = allCombos.substring(index, index + 1);
            }
        } else if (!dupeAllow && !spaceAllow) {
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
        String spaceCombo = "roygbp ";
        if (spaceAllow && dupeAllow) {
            for (int i = 0; i < code.length; i++) {
                Random choose = new Random();
                int index = choose.nextInt(spaceCombo.length());
                code[i] = spaceCombo.substring(index, index + 1);
            }
        } else if (spaceAllow) {
            Random choose = new Random();
            ArrayList<Integer> arrayList = new ArrayList<>();
            while (arrayList.size() < 4) {
                int a = choose.nextInt(spaceCombo.length());
                if (!arrayList.contains(a)) {
                    arrayList.add(a);
                }
            }
            for (int i = 0; i < code.length; i++) {
                code[i] = spaceCombo.substring(arrayList.get(i), arrayList.get(i) + 1);
            }
        }
        System.out.println(Arrays.toString(code));
        return code;
    }
}
