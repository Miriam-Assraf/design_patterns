package DesignPatterns;

import Model.Container;
import Model.ContainersStack;

/* ----------------------------------Composite------------------------------------- */
public interface IContainer extends Iterable<ContainersStack> {
    public boolean load(Container container);
    public Container unload();
    public int getNumContainers();
    public void undo();
    public void redo();
}
/* --------------------------------------------------------------------------------- */