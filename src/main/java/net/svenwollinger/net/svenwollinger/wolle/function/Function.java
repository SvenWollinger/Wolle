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

    public Function() {
    }

    public void execute() {
        for(IInstruction instruction : instructions) {
            instruction.execute(this);
        }
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

    public void setVariable(String identifier, IVariable variable) {
        if(variables.containsKey(identifier)) {
            variables.put(identifier, variable);
        } else {
            //TODO: Throw error
        }
    }

}
