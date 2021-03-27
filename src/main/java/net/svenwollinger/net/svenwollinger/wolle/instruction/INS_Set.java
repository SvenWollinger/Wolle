package net.svenwollinger.net.svenwollinger.wolle.instruction;

import net.svenwollinger.net.svenwollinger.wolle.function.Function;
import net.svenwollinger.net.svenwollinger.wolle.variable.IVariable;

public class INS_Set implements IInstruction {
    private String identifier;
    private IVariable variable;

    public INS_Set (String identifier, IVariable variable) {
        this.identifier = identifier;
        this.variable = variable;
    }

    @Override
    public void execute(Function function) {
        function.setVariable(identifier, variable);
    }
}
