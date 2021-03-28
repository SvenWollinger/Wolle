package net.svenwollinger.net.svenwollinger.wolle;

import net.svenwollinger.net.svenwollinger.wolle.function.Function;
import net.svenwollinger.net.svenwollinger.wolle.variable.IVariable;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.logging.Level;

public class Runtime {
    private String identifier;

    private HashMap<String, IVariable> variables = new HashMap<String, IVariable>();
    private HashMap<String, Function> functions = new HashMap<String, Function>();

    public Runtime(String identifier) {
        this.identifier = identifier;
        Logging.log("Starting runtime", this, Level.INFO);
    }

    public String getID() {
        return identifier;
    }

    public void parseCode(String code) {
        //TODO: Parse code
        Logging.log("Parsing code", this, Level.INFO);
    }

    public void execute() {
        Logging.log("Executing", this, Level.INFO);
        if (functions.containsKey("main")) {
            functions.get("main").execute();
        } else {
            Logging.log("No main function found", this, Level.SEVERE);
            //TODO: Throw error
        }
        Logging.log("Goodbye!", this, Level.INFO);
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

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("identifier", identifier);
        json.put("type", "runtime");

        JSONArray jsonVariables = new JSONArray();
        for(String key : variables.keySet()) {
            JSONObject jsonVariable = new JSONObject();
            jsonVariable.put("identifier", key);
            jsonVariable.put("value", variables.get(key).getValue().toString());
            jsonVariables.put(jsonVariable);
        }
        json.put("variables", jsonVariables);

        JSONArray jsonFunctions = new JSONArray();
        for(String key : functions.keySet()) {
            JSONObject jsonFunction = functions.get(key).toJSON();
            jsonFunction.put("identifier", key);
            jsonFunctions.put(jsonFunction);
        }
        json.put("functions", jsonFunctions);

        return json;
    }

}
