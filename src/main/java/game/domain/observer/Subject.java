package game.domain.observer;

import java.util.ArrayList;

public class Subject {
    ArrayList<Observer> observers;
    protected Subject(){
        observers = new ArrayList<>();
    }
    public void attach(Observer observer){
        observers.add(observer);
    }

    public void detach(Observer observer){
        observers.remove(observer);
    }
    // Er i store bogstaver for ikke at komme i konflikt med notify i object
    public void Notify(){
        for(Observer observer : observers){
            observer.Update(this);
        }
    }
}
