package edu.wit.comp1050;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.TimeUnit;

public class Timer implements Runnable {

    public static StopWatch timer;

    public Timer() {
        timer = new StopWatch();
        timer.start();
    }

    public void run() {
        while (timer.isStarted()) {
            try {
                if (Timer.getTimeUnits(TimeUnit.MINUTES)>= Controller.time_limit && Controller.time_limit!=0) {
                    if (Controller.sounds) {
                        soundPlayer.playSound("src/main/resources/The Price is Right Losing Horn - Gaming Sound Effect (HD).wav");
                    }
                    colorChanger.winBox();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static long getTimeUnits(TimeUnit x) {
        return timer.getTime(x);
    }

    public static String getTime() {
        return DurationFormatUtils.formatDuration((timer.getTime(TimeUnit.MILLISECONDS)), "mm':'ss", true);
    }

    public static void stopTime() {
        timer.stop();
    }

    public static void resetTime() {
        timer.reset();
        timer.start();
    }
}

