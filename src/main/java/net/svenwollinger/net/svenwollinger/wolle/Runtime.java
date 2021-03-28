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
