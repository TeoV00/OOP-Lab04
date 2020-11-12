package it.unibo.oop.lab04.robot.arms;

public class BasicArm {
    private final static double consuptionPickUp = 2.0;
    private final static double consuptionDropDown = 2.0;
    
    private final String name;
    private boolean isGrabbing;
    
    public BasicArm(String name) {
        this.name = name;
        this.isGrabbing = false;
    }
    
    public boolean isGrabbing() {
        return this.isGrabbing;
    }
    
    public void pickUp() {
        if(!this.isGrabbing) {
            this.isGrabbing = true;
        }
    }
    
    public void dropDown() {
        if(this.isGrabbing) {
            this.isGrabbing = false;
        }
    }

    public double getConsuptionPickUp() {
        return consuptionPickUp;
    }

    public double getConsuptionDropDown() {
        return consuptionDropDown;
    }

    public String toString() {
        return "BasicArm [name=" + name + ", isGrabbing=" + isGrabbing + ", isGrabbing()=" + isGrabbing() + "]";
    }

  
    
}
