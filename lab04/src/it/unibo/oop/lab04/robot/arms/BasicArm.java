package it.unibo.oop.lab04.robot.arms;

public class BasicArm {
    public static final double CONSUPTION_PICKUP = 0.5;
    public static final double CONSUPTION_DROPDOWN = 0.5;
    
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
        return CONSUPTION_PICKUP;
    }

    public double getConsuptionDropDown() {
        return CONSUPTION_DROPDOWN;
    }

    public String toString() {
        return "BasicArm [name=" + name + ", isGrabbing()=" + isGrabbing() + "]";
    }

  
    
}
