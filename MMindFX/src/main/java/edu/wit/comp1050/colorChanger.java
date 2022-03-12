package edu.wit.comp1050;

import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class colorChanger {
    public static void clearGameBoard() {
        // RESET TIME
        Timer.resetTime();
        // MAKE BUTTON COLORS VISIBLE
        Controller.box_List.get(12).setVisible(true);
        // INDEX CLEAR
        Controller.index = 0;
        Controller.box_List.get(11).setTranslateY(Controller.index);
        // WIN BOX CLEAR
        Circle w1 = (Circle) Controller.box_List.get(10).getChildren().get(0);
        Circle w2 = (Circle) Controller.box_List.get(10).getChildren().get(1);
        Circle w3 = (Circle) Controller.box_List.get(10).getChildren().get(2);
        Circle w4 = (Circle) Controller.box_List.get(10).getChildren().get(3);
        w1.setFill(Color.WHITE);
        w2.setFill(Color.WHITE);
        w3.setFill(Color.WHITE);
        w4.setFill(Color.WHITE);
        // COLOR CLEAR
        for (int i = 0; i < Controller.max_guess; i++) {
            Circle g1 = (Circle) Controller.box_List.get(i).getChildren().get(0);
            Circle g2 = (Circle) Controller.box_List.get(i).getChildren().get(1);
            Circle g3 = (Circle) Controller.box_List.get(i).getChildren().get(2);
            Circle g4 = (Circle) Controller.box_List.get(i).getChildren().get(3);
            g1.setFill(Color.WHITE);
            g2.setFill(Color.WHITE);
            g3.setFill(Color.WHITE);
            g4.setFill(Color.WHITE);
        }
        // CHECK CLEAR
        for (int i = 0; i < Controller.max_guess; i++) {
            HBox checkBox = (HBox) Controller.box_List.get(i).getChildren().get(4);
            Circle c1 = (Circle) checkBox.getChildren().get(0);
            Circle c2 = (Circle) checkBox.getChildren().get(1);
            Circle c3 = (Circle) checkBox.getChildren().get(2);
            Circle c4 = (Circle) checkBox.getChildren().get(3);
            c1.setFill(Color.TRANSPARENT);
            c2.setFill(Color.TRANSPARENT);
            c3.setFill(Color.TRANSPARENT);
            c4.setFill(Color.TRANSPARENT);
        }
        // GUESSES CLEAR
        Controller.guesses.clear();
        // CHECK CLEAR
        Controller.colors.clear();
        // CREATE CODE
        Controller.dupes = Boolean.parseBoolean(UserConfig.getInstance().getProperty("dupesAllowedInCode"));
        Controller.blanks = Boolean.parseBoolean(UserConfig.getInstance().getProperty("blanksAllowedInCode"));
        Controller.code = CodeMaker.createCode(Controller.dupes, Controller.blanks);
        // MAX GUESSES
        Controller.max_guess = Integer.parseInt(UserConfig.getInstance().getProperty("codePegRows"));
        // TIME LIMIT
        Controller.time_limit = Integer.parseInt(UserConfig.getInstance().getProperty("maxTime"));
        // SOUND ON/OFF
        Controller.sounds = Boolean.parseBoolean(UserConfig.getInstance().getProperty("playSounds"));
        // System.out.println("MAX GUESSES = "+Controller.max_guess);
        // System.out.println("TIME LIMIT = "+Controller.time_limit);
        // System.out.println("DUPES ALLOWED = "+Controller.dupes);
        // System.out.println("BLANKS ALLOWED = "+Controller.blanks);
        // System.out.println("SOUND ALLOWED = "+Boolean.parseBoolean(UserConfig.getInstance().getProperty("playSounds")));
    }

    public static void winBox() {
        // STOP TIMER
        Timer.stopTime();
        // DISABLE COLOR BUTTON
        Controller.box_List.get(12).setVisible(false);
        Circle g1 = (Circle) Controller.box_List.get(10).getChildren().get(0);
        Circle g2 = (Circle) Controller.box_List.get(10).getChildren().get(1);
        Circle g3 = (Circle) Controller.box_List.get(10).getChildren().get(2);
        Circle g4 = (Circle) Controller.box_List.get(10).getChildren().get(3);
        for (int i = 0; i < Controller.code.length; i++) {
            // CLEAR
            if (Controller.code[i].equals("") && i == 0) {
                g1.setFill(Color.WHITE);
            } else if (Controller.code[i].equals("") && i == 1) {
                g2.setFill(Color.WHITE);
            } else if (Controller.code[i].equals("") && i == 2) {
                g3.setFill(Color.WHITE);
            } else if (Controller.code[i].equals("") && i == 3) {
                g4.setFill(Color.WHITE);
            }
            // RED
            if (Controller.code[i].equals("r") && i == 0) {
                g1.setFill(Color.RED);
            } else if (Controller.code[i].equals("r") && i == 1) {
                g2.setFill(Color.RED);
            } else if (Controller.code[i].equals("r") && i == 2) {
                g3.setFill(Color.RED);
            } else if (Controller.code[i].equals("r") && i == 3) {
                g4.setFill(Color.RED);
            }
            // ORANGE
            if (Controller.code[i].equals("o") && i == 0) {
                g1.setFill(Color.ORANGE);
            } else if (Controller.code[i].equals("o") && i == 1) {
                g2.setFill(Color.ORANGE);
            } else if (Controller.code[i].equals("o") && i == 2) {
                g3.setFill(Color.ORANGE);
            } else if (Controller.code[i].equals("o") && i == 3) {
                g4.setFill(Color.ORANGE);
            }
            // YELLOW
            if (Controller.code[i].equals("y") && i == 0) {
                g1.setFill(Color.YELLOW);
            } else if (Controller.code[i].equals("y") && i == 1) {
                g2.setFill(Color.YELLOW);
            } else if (Controller.code[i].equals("y") && i == 2) {
                g3.setFill(Color.YELLOW);
            } else if (Controller.code[i].equals("y") && i == 3) {
                g4.setFill(Color.YELLOW);
            }
            // GREEN
            if (Controller.code[i].equals("g") && i == 0) {
                g1.setFill(Color.GREEN);
            } else if (Controller.code[i].equals("g") && i == 1) {
                g2.setFill(Color.GREEN);
            } else if (Controller.code[i].equals("g") && i == 2) {
                g3.setFill(Color.GREEN);
            } else if (Controller.code[i].equals("g") && i == 3) {
                g4.setFill(Color.GREEN);
            }
            // BLUE
            if (Controller.code[i].equals("b") && i == 0) {
                g1.setFill(Color.BLUE);
            } else if (Controller.code[i].equals("b") && i == 1) {
                g2.setFill(Color.BLUE);
            } else if (Controller.code[i].equals("b") && i == 2) {
                g3.setFill(Color.BLUE);
            } else if (Controller.code[i].equals("b") && i == 3) {
                g4.setFill(Color.BLUE);
            }
            // PURPLE
            if (Controller.code[i].equals("p") && i == 0) {
                g1.setFill(Color.PURPLE);
            } else if (Controller.code[i].equals("p") && i == 1) {
                g2.setFill(Color.PURPLE);
            } else if (Controller.code[i].equals("p") && i == 2) {
                g3.setFill(Color.PURPLE);
            } else if (Controller.code[i].equals("p") && i == 3) {
                g4.setFill(Color.PURPLE);
            }
            // TRANSPARENT
            if (Controller.code[i].equals(" ") && i == 0) {
                g1.setFill(Color.TRANSPARENT);
            } else if (Controller.code[i].equals(" ") && i == 1) {
                g2.setFill(Color.TRANSPARENT);
            } else if (Controller.code[i].equals(" ") && i == 2) {
                g3.setFill(Color.TRANSPARENT);
            } else if (Controller.code[i].equals(" ") && i == 3) {
                g4.setFill(Color.TRANSPARENT);
            }
        }
    }

    public static void colorGuess(String x) {
        Controller.guesses.add(x);

        Circle g1 = (Circle) Controller.box_List.get(Controller.index).getChildren().get(0);
        Circle g2 = (Circle) Controller.box_List.get(Controller.index).getChildren().get(1);
        Circle g3 = (Circle) Controller.box_List.get(Controller.index).getChildren().get(2);
        Circle g4 = (Circle) Controller.box_List.get(Controller.index).getChildren().get(3);

        if (Controller.guesses.size() > 4) {
            Controller.guesses.clear();
        }

        for (int i = 0; i < Controller.guesses.size(); i++) {
            // CLEAR
            if (Controller.guesses.get(i).equals("") && i == 0) {
                g1.setFill(Color.WHITE);
            } else if (Controller.guesses.get(i).equals("") && i == 1) {
                g2.setFill(Color.WHITE);
            } else if (Controller.guesses.get(i).equals("") && i == 2) {
                g3.setFill(Color.WHITE);
            } else if (Controller.guesses.get(i).equals("") && i == 3) {
                g4.setFill(Color.WHITE);
            }
            // RED
            if (Controller.guesses.get(i).equals("r") && i == 0) {
                g1.setFill(Color.RED);
            } else if (Controller.guesses.get(i).equals("r") && i == 1) {
                g2.setFill(Color.RED);
            } else if (Controller.guesses.get(i).equals("r") && i == 2) {
                g3.setFill(Color.RED);
            } else if (Controller.guesses.get(i).equals("r") && i == 3) {
                g4.setFill(Color.RED);
            }
            // ORANGE
            if (Controller.guesses.get(i).equals("o") && i == 0) {
                g1.setFill(Color.ORANGE);
            } else if (Controller.guesses.get(i).equals("o") && i == 1) {
                g2.setFill(Color.ORANGE);
            } else if (Controller.guesses.get(i).equals("o") && i == 2) {
                g3.setFill(Color.ORANGE);
            } else if (Controller.guesses.get(i).equals("o") && i == 3) {
                g4.setFill(Color.ORANGE);
            }
            // YELLOW
            if (Controller.guesses.get(i).equals("y") && i == 0) {
                g1.setFill(Color.YELLOW);
            } else if (Controller.guesses.get(i).equals("y") && i == 1) {
                g2.setFill(Color.YELLOW);
            } else if (Controller.guesses.get(i).equals("y") && i == 2) {
                g3.setFill(Color.YELLOW);
            } else if (Controller.guesses.get(i).equals("y") && i == 3) {
                g4.setFill(Color.YELLOW);
            }
            // GREEN
            if (Controller.guesses.get(i).equals("g") && i == 0) {
                g1.setFill(Color.GREEN);
            } else if (Controller.guesses.get(i).equals("g") && i == 1) {
                g2.setFill(Color.GREEN);
            } else if (Controller.guesses.get(i).equals("g") && i == 2) {
                g3.setFill(Color.GREEN);
            } else if (Controller.guesses.get(i).equals("g") && i == 3) {
                g4.setFill(Color.GREEN);
            }
            // BLUE
            if (Controller.guesses.get(i).equals("b") && i == 0) {
                g1.setFill(Color.BLUE);
            } else if (Controller.guesses.get(i).equals("b") && i == 1) {
                g2.setFill(Color.BLUE);
            } else if (Controller.guesses.get(i).equals("b") && i == 2) {
                g3.setFill(Color.BLUE);
            } else if (Controller.guesses.get(i).equals("b") && i == 3) {
                g4.setFill(Color.BLUE);
            }
            // PURPLE
            if (Controller.guesses.get(i).equals("p") && i == 0) {
                g1.setFill(Color.PURPLE);
            } else if (Controller.guesses.get(i).equals("p") && i == 1) {
                g2.setFill(Color.PURPLE);
            } else if (Controller.guesses.get(i).equals("p") && i == 2) {
                g3.setFill(Color.PURPLE);
            } else if (Controller.guesses.get(i).equals("p") && i == 3) {
                g4.setFill(Color.PURPLE);
            }
            // TRANSPARENT
            if (Controller.guesses.get(i).equals(" ") && i == 0) {
                g1.setFill(Color.TRANSPARENT);
            } else if (Controller.guesses.get(i).equals(" ") && i == 1) {
                g2.setFill(Color.TRANSPARENT);
            } else if (Controller.guesses.get(i).equals(" ") && i == 2) {
                g3.setFill(Color.TRANSPARENT);
            } else if (Controller.guesses.get(i).equals(" ") && i == 3) {
                g4.setFill(Color.TRANSPARENT);
            }
        }
    }

    public static void colorHint(String[] code, String[] guess) {
        HBox checkBox = (HBox) Controller.box_List.get(Controller.index).getChildren().get(4);

        Circle c1 = (Circle) checkBox.getChildren().get(0);
        Circle c2 = (Circle) checkBox.getChildren().get(1);
        Circle c3 = (Circle) checkBox.getChildren().get(2);
        Circle c4 = (Circle) checkBox.getChildren().get(3);

        if (Controller.getConfirm) {
            for (int i = 0; i < CodeChecker.checkDirect(code, guess); i++) {
                if (CodeChecker.checkDirect(code, guess) != 0) {
                    Controller.colors.add(2);
                }
            }

            for (int i = 0; i < CodeChecker.checkColor(code, guess); i++) {
                if (CodeChecker.checkColor(code, guess) != 0) {
                    Controller.colors.add(1);
                }
            }

            if (Controller.colors.size() > 4 || Controller.colors.isEmpty()) {
                Controller.colors.clear();
                c1.setFill(Color.TRANSPARENT);
                c2.setFill(Color.TRANSPARENT);
                c3.setFill(Color.TRANSPARENT);
                c4.setFill(Color.TRANSPARENT);
            }

            for (int i = 0; i < Controller.colors.size(); i++) {
                if (Controller.colors.get(i) == 1 && i == 0) {
                    c1.setFill(Color.GRAY);
                } else if (Controller.colors.get(i) == 1 && i == 1) {
                    c2.setFill(Color.GRAY);
                } else if (Controller.colors.get(i) == 1 && i == 2) {
                    c3.setFill(Color.GRAY);
                } else if (Controller.colors.get(i) == 1 && i == 3) {
                    c4.setFill(Color.GRAY);
                }
                if (Controller.colors.get(i) == 2 && i == 0) {
                    c1.setFill(Color.GOLDENROD);
                } else if (Controller.colors.get(i) == 2 && i == 1) {
                    c2.setFill(Color.GOLDENROD);
                } else if (Controller.colors.get(i) == 2 && i == 2) {
                    c3.setFill(Color.GOLDENROD);
                } else if (Controller.colors.get(i) == 2 && i == 3) {
                    c4.setFill(Color.GOLDENROD);
                }

                if (Controller.colors.size() == 1) {
                    c2.setFill(Color.TRANSPARENT);
                    c3.setFill(Color.TRANSPARENT);
                    c4.setFill(Color.TRANSPARENT);
                }

                if (Controller.colors.size() == 2) {
                    c3.setFill(Color.TRANSPARENT);
                    c4.setFill(Color.TRANSPARENT);
                }
                if (Controller.colors.size() == 3) {
                    c4.setFill(Color.TRANSPARENT);
                }
            }
        }
    }
}
