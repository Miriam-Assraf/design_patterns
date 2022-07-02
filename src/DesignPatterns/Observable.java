package DesignPatterns;

public interface Observable<T> {
    public void attach(T observer);
    public void detach(T observer);
    //public void notifyObservers(T arg1, T arg2);
}
