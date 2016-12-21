package model.observer;

import model.Target;
import model.type.ShipType;

import java.util.*;

/**
 * Created by yanice on 21/12/16.
 */
public interface Subject {
    List<Observer> getObservers();
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
