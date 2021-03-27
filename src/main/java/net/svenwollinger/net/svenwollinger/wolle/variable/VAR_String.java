package net.svenwollinger.net.svenwollinger.wolle.variable;

public class VAR_String implements IVariable {
    private String value;

    public VAR_String (String value) {
        this.value = value;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public IVariable plus(IVariable variable) {
        if (variable instanceof VAR_String) {
            return new VAR_String(value + (String)variable.getValue());
        }
        return MismatchManager.plus(this, variable);
    }

    @Override
    public IVariable minus(IVariable variable) {
        if (variable instanceof VAR_String) {
            //TODO: Throw error
            return null;
        }
        return MismatchManager.minus(this, variable);
    }

    @Override
    public IVariable plusEquals(IVariable variable) {
        if (variable instanceof VAR_String) {
            this.value += (String)variable.getValue();
        }
        return MismatchManager.plusEquals(this, variable);
    }

    @Override
    public IVariable minusEquals(IVariable variable) {
        if (variable instanceof VAR_String) {
            //TODO: Throw error
            return null;
        }
        return MismatchManager.minusEquals(this, variable);
    }
}
