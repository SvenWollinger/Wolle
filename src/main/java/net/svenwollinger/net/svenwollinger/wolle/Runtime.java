package net.svenwollinger.net.svenwollinger.wolle;

import net.svenwollinger.net.svenwollinger.wolle.function.Function;
import net.svenwollinger.net.svenwollinger.wolle.variable.IVariable;

import java.util.HashMap;

public class Runtime {

    private HashMap<String, IVariable> variables = new HashMap<String, IVariable>();
    private HashMap<String, Function> functions = new HashMap<String, Function>();

    public Runtime() {
        loadCode("");
    }

    public void loadCode(String code) {
        //TODO: Load code
        execute();
    }

    public void execute() {
        if (functions.containsKey("main")) {
            functions.get("main").execute();
            System.exit(0);
        } else {
            System.exit(-1);
        }
    }

    public IVariable getVariable(String identifier) {
        return variables.get(identifier);
    }

    public Function getFunction(String identifier) {
        return functions.get(identifier);
    }

    public void setVariable(String identifier, IVariable variable) {
        if(variables.containsKey(identifier)) {
            variables.put(identifier, variable);
        } else {
            //TODO: Throw error
        }
    }

}
