package g58137.atlg3.bmr.model;

import g58137.atlg3.bmr.util.Observable;
import g58137.atlg3.bmr.util.Observer;

import java.util.ArrayList;
import java.util.List;


public class Facade implements Observable {
    private int age;
    private int size;
    private int weight;
    private boolean femme;
    private boolean homme;
    private double lifeStyle;
    private List<Observer> observers = new ArrayList();

    public Facade() {}

     public void set(int age,int size,int weight,boolean femme, boolean homme, double lifeStyle){
         this.age = age;
         this.size = size;
         this.weight = weight;
         this.femme = femme;
         this.homme = homme;
         this.lifeStyle = lifeStyle;
         notifyObservers();
    }

    public double getBMR(){
        if(femme){
            return 9.6 * weight +1.8 * size - 4.7 * age +655;
        } else if(homme){
            return 13.7 * weight + 5 * size - 6.8 * age +66;
        }
        throw new IllegalArgumentException("No data matches : homme femme ?");
    }

    public double getCalories(){
        return getBMR() * lifeStyle;
    }

    @Override
    public void register(Observer observer) {
        if(!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer obs: observers) {
            obs.update();
        }
    }
}
