package net.svenwollinger.net.svenwollinger.wolle.variable;

public interface IVariable {

    public Object getValue();

    public IVariable plus(IVariable variable);
    public IVariable minus(IVariable variable);

    public IVariable plusEquals(IVariable variable);
    public IVariable minusEquals(IVariable variable);

}
