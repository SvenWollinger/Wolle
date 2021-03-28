package net.svenwollinger.net.svenwollinger.wolle.function;

import net.svenwollinger.net.svenwollinger.wolle.Runtime;
import net.svenwollinger.net.svenwollinger.wolle.instruction.IInstruction;
import net.svenwollinger.net.svenwollinger.wolle.variable.IVariable;

import java.util.ArrayList;
import java.util.HashMap;

public class Function {
    private HashMap<String, IVariable> variables = new HashMap<>();
    private HashMap<String, Function> functions = new HashMap<>();

    private ArrayList<IInstruction> instructions = new ArrayList<>();

    private Runtime runtime;
    private Function parent;

    public Function(Runtime runtime) {
        this.runtime = runtime;
        this.parent = null;
    }

    public Function(Runtime runtime, Function parent) {
        this.runtime = runtime;
        this.parent = parent;
    }

    public void execute() {
        for(IInstruction instruction : instructions) {
            instruction.execute(this);
        }
    }

    public Runtime getRuntime() {
        return runtime;
    }

    public Function getParent() {
        return parent;
    }

    public IVariable getVariable(String identifier) {
        if(variables.containsKey(identifier)) {
            return variables.get(identifier);
        }
        //TODO: Throw error
        return null;
    }

    public Function getFunction(String identifier) {
        if(functions.containsKey(identifier)) {
            return functions.get(identifier);
        }
        //TODO: Throw error
        return null;
    }

    public boolean hasVariable(String identifier) {
        return variables.containsKey(identifier);
    }

    public boolean hasFunction(String identifier) {
        return functions.containsKey(identifier);
    }

    public void setVariable(String identifier, IVariable variable) {
        variables.put(identifier, variable);
    }

    public void setFunction(String identifier, Function function) {
        functions.put(identifier, function);
    }

}
