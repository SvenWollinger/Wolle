package net.svenwollinger.net.svenwollinger.wolle.variable;

public class VAR_Float implements IVariable {
    private float value;

    public VAR_Float(float value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public IVariable plus(IVariable variable) {
        if (variable instanceof VAR_Float) {
            return new VAR_Float(value + (float)variable.getValue());
        }
        return MismatchManager.plus(this, variable);
    }

    @Override
    public IVariable minus(IVariable variable) {
        if (variable instanceof VAR_Float) {
            return new VAR_Float(value - (float)variable.getValue());
        }
        return MismatchManager.minus(this, variable);
    }

    @Override
    public IVariable plusEquals(IVariable variable) {
        if (variable instanceof VAR_Float) {
            this.value += (float)variable.getValue();
        }
        return MismatchManager.plusEquals(this, variable);
    }

    @Override
    public IVariable minusEquals(IVariable variable) {
        if (variable instanceof VAR_Float) {
            this.value -= (float)variable.getValue();
        }
        return MismatchManager.minusEquals(this, variable);
    }
}
