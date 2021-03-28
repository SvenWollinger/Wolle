package net.svenwollinger.net.svenwollinger.wolle.instruction;

import net.svenwollinger.net.svenwollinger.wolle.Runtime;
import net.svenwollinger.net.svenwollinger.wolle.function.Function;
import net.svenwollinger.net.svenwollinger.wolle.variable.IVariable;

public class INS_Update implements IInstruction {
    private String identifier;
    private IVariable variable;

    public INS_Update (String identifier, IVariable variable) {
        this.identifier = identifier;
        this.variable = variable;
    }

    @Override
    public void execute(Function function) {
        if(function.hasVariable(identifier)) {
            function.setVariable(identifier, variable);
        } else {
            boolean done = false;
            Function lastFunction = function;
            while(!done) {
                Function parent = lastFunction.getParent();
                if(parent.hasVariable(identifier)) {
                    parent.setVariable(identifier, variable);
                    done = true;
                } else if(parent == null){
                    //VAR is not set in any functions, check in runtime
                    Runtime runtime = function.getRuntime();
                    if(runtime.hasVariable(identifier)) {
                        runtime.setVariable(identifier, variable);
                    } else {
                        //TODO: THROW VAR UNDEFINED ERROR
                    }
                    done = true;
                } else {
                    lastFunction = parent;
                }
            }
        }
    }
}
