package it.unibo.oop.lab04.robot.arms;

import it.unibo.oop.lab04.robot.base.BaseRobot;

public class RobotWithTwoArms extends BaseRobot implements RobotWithArms {

    private BasicArm leftArm;
    private BasicArm rightArm;
    private int countItem;
    
    public RobotWithTwoArms(String robotName) {
        super(robotName);
        this.countItem = 0;
        this.leftArm = new BasicArm("leftArm");
        this.rightArm = new BasicArm("rightArm");
    }

    public boolean pickUp() {
        if(!leftArm.isGrabbing()) {
            this.leftArm.pickUp();
            this.incrementCountItem();
        }
        else if(!rightArm.isGrabbing()) {
            this.rightArm.pickUp();
            this.incrementCountItem();
        }
        return !(this.leftArm.isGrabbing() && this.rightArm.isGrabbing());
    }

    public boolean dropDown() {
        if(leftArm.isGrabbing()) {
            this.leftArm.dropDown();
            this.decrementCountItem();
        }
        else if(rightArm.isGrabbing()) {
            this.rightArm.dropDown();
            this.decrementCountItem();
        }
        return (this.leftArm.isGrabbing() && this.rightArm.isGrabbing());
    }

    private void decrementCountItem() {
        this.countItem -= 1;        
    }

    private void incrementCountItem() {
        this.countItem += 1;
    }
    
    public int getCarriedItemsCount() {
        return this.countItem;
    }
}
