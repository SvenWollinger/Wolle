package net.svenwollinger.wolle.variable;

import net.svenwollinger.net.svenwollinger.wolle.Logging;
import net.svenwollinger.net.svenwollinger.wolle.Runtime;
import net.svenwollinger.net.svenwollinger.wolle.function.Function;
import net.svenwollinger.net.svenwollinger.wolle.variable.VAR_Float;
import net.svenwollinger.net.svenwollinger.wolle.variable.VAR_Int;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;

public class FunctionTests {
    @Test
    public void runtime1() {
        Logging.newline(2);
        Logging.log("Starting Runtime test 1", Level.INFO);
        Runtime runtime = new Runtime("RuntimeTest1");
        Function mainFunction = new Function(runtime);
        runtime.setFunction("main", mainFunction);
        mainFunction.setFunction("test", new Function(runtime,mainFunction));
        runtime.execute();

        System.out.println(runtime.toJSON().toString());
    }

}
