package net.svenwollinger.wolle.variable;

import net.svenwollinger.net.svenwollinger.wolle.variable.VAR_Float;
import net.svenwollinger.net.svenwollinger.wolle.variable.VAR_Int;
import net.svenwollinger.net.svenwollinger.wolle.variable.VAR_String;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VariableTests {

    @Test
    public void VAR_Int() {
        VAR_Int var1 = new VAR_Int(4);
        VAR_Int var2 = new VAR_Int(17);

        //Plus and minus test, original variables should not be modified.
        assertEquals(21, var1.plus(var2).getValue());
        assertEquals(-13, var1.minus(var2).getValue());

        //Check that they have not been modified
        assertEquals(4, var1.getValue());
        assertEquals(17, var2.getValue());

        //Plus Equals (+=) test. First variable should be modified, not second.
        var1.plusEquals(var2);
        assertEquals(21, var1.getValue());
        assertEquals(17, var2.getValue());

        //Minus Equals (-=) test. First variable should be modified, not second.
        var2.minusEquals(var1);
        assertEquals(-4, var2.getValue());
        assertEquals(21, var1.getValue());
    }

    @Test
    public void VAR_Float() {
        VAR_Float var1 = new VAR_Float(4.51F);
        VAR_Float var2 = new VAR_Float(17.875F);

        //Plus and minus test, original variables should not be modified.
        assertEquals(22.385F, var1.plus(var2).getValue());
        assertEquals(-13.365F, var1.minus(var2).getValue());

        //Check that they have not been modified
        assertEquals(4.51F, var1.getValue());
        assertEquals(17.875F, var2.getValue());

        //Plus Equals (+=) test. First variable should be modified, not second.
        var1.plusEquals(var2);
        assertEquals(22.385F, var1.getValue());
        assertEquals(17.875F, var2.getValue());

        //Minus Equals (-=) test. First variable should be modified, not second.
        var2.minusEquals(var1);
        assertEquals(-4.51F, var2.getValue());
        assertEquals(22.385F, var1.getValue());
    }

    @Test
    public void VAR_String() {
        final String value1 = "Sven";
        final String value2 = "Wollinger";

        VAR_String var1 = new VAR_String(value1);
        VAR_String var2 = new VAR_String(value2);

        assertEquals(value1, var1.getValue());
        assertEquals(value2, var2.getValue());

        assertEquals(value1 + value2, var1.plus(var2).getValue());
        assertEquals(value2 + value1, var2.plus(var1).getValue());

        var1.plusEquals(var2);
        assertEquals(value1 + value2, var1.getValue());
        var2.plusEquals(var1);
        assertEquals(value2 + value1 + value2, var2.getValue());

        //TODO: Implement & react on throws
    }
}
