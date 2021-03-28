package net.svenwollinger.net.svenwollinger.wolle;

import net.svenwollinger.net.svenwollinger.wolle.function.Function;

import java.util.logging.Level;

public class Logging {

    public static void newline(int amount) {
        String msg = "";
        for(int i = 0; i < amount; i++)
            msg += "\n";
        System.out.print(msg);
    }

    public static void log(String message, Level level) {
        String msg = "[" + level.toString() + "] " + message;
        System.out.println(msg);
    }

    public static void log(String message, Runtime runtime, Level level) {
        Logging.log("[" + runtime.getID() + "] " + message, level);
    }

    public static void log(String message, Function function, Level level) {
        Logging.log("[" + function.getRuntime().getID() + "][function_" + System.identityHashCode(function) + "] " + message, level);
    }
}
