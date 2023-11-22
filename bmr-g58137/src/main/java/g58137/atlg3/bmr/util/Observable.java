package g58137.atlg3.bmr.util;

public interface Observable {
    void register(Observer observer);
    void unregister(Observer observer);
}
