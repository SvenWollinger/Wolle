package net.svenwollinger.net.svenwollinger.wolle.variable;

public class VAR_Int implements IVariable{
    private int value;

    public VAR_Int(int value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public IVariable plus(IVariable variable) {
        if (variable instanceof VAR_Int) {
            return new VAR_Int(value + (int)variable.getValue());
        }
        return MismatchManager.plus(this, variable);
    }

    @Override
    public IVariable minus(IVariable variable) {
        if (variable instanceof VAR_Int) {
            return new VAR_Int(value - (int)variable.getValue());
        }
        return MismatchManager.minus(this, variable);
    }

    @Override
    public IVariable plusEquals(IVariable variable) {
        if (variable instanceof VAR_Int) {
            this.value += (int)variable.getValue();
        }
        return MismatchManager.plusEquals(this, variable);
    }

    @Override
    public IVariable minusEquals(IVariable variable) {
        if (variable instanceof VAR_Int) {
            this.value -= (int)variable.getValue();
        }
        return MismatchManager.minusEquals(this, variable);
    }
}
