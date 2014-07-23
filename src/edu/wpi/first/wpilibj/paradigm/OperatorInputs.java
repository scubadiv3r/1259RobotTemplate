/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.paradigm;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author 1259
 */
public class OperatorInputs {

    private final Joystick logitechJoystick = new Joystick(1);
    private final Joystick xBoxJoystick = new Joystick(2);

    //static variables can benefit compile size
    
    
    //XBOX Joystick Variables Start Here
    private double xBoxTriggerPressed;
    private static final int A_BUTTON = 1;
    private static final int B_BUTTON = 2;
    private static final int X_BUTTON = 3;
    private static final int Y_BUTTON = 4;
    private static final int RIGHT_BUMPER = 6;
    private static final int LEFT_BUMPER = 5;
    private static final int BACK_BUTTON = 7;
    private static final int START_BUTTON = 8;
    private static final int XBOX_TRIGGER_RAW_AXIS = 3;
    private static final double RIGHT_TRIGGER_MIN = -1.0;
    private static final double RIGHT_TRIGGER_MAX = -0.5;
    private static final double LEFT_TRIGGER_MIN = 0.5;
    private static final double LEFT_TRIGGER_MAX = 1.0;

    //Logitech Joystick Variables Start Here   
    private static final double DEADZONE_Y = 0.1;
    private static final double DEADZONE_X = 0.15;


    public OperatorInputs() {

    }

    //XBOX Joystick Code Starts Here
    
    
    public boolean xBoxStartButton() { //Returns true if start button is pressed
        return xBoxJoystick.getRawButton(START_BUTTON);
    }

    public boolean xBoxRightTrigger() {
        xBoxTriggerPressed = xBoxJoystick.getRawAxis(XBOX_TRIGGER_RAW_AXIS);
        return (RIGHT_TRIGGER_MIN <= xBoxTriggerPressed && xBoxTriggerPressed <= RIGHT_TRIGGER_MAX);
    }

    public boolean xBoxLeftTrigger() {
        xBoxTriggerPressed = xBoxJoystick.getRawAxis(XBOX_TRIGGER_RAW_AXIS);
        return (LEFT_TRIGGER_MIN <= xBoxTriggerPressed && xBoxTriggerPressed <= LEFT_TRIGGER_MAX);

    }

    public boolean xBoxBackButton() {
        return xBoxJoystick.getRawButton(BACK_BUTTON);
    }

    public boolean xBoxYButton() {
        return xBoxJoystick.getRawButton(Y_BUTTON);
    }

    public boolean xBoxAButton() {
        return xBoxJoystick.getRawButton(A_BUTTON);
    }

    public boolean xBoxBButton() {
        return xBoxJoystick.getRawButton(B_BUTTON);
    }

    public boolean xBoxXButton() {
        return xBoxJoystick.getRawButton(X_BUTTON);
    }

    public boolean xBoxRightBumper() {
        return xBoxJoystick.getRawButton(RIGHT_BUMPER);
    }

    public boolean xBoxLeftBumper() {
        return xBoxJoystick.getRawButton(LEFT_BUMPER);
    }

    public double xboxRightX() {
        return deadzoneFilterX(this.xBoxJoystick.getX(Joystick.Hand.kRight));
    }

    public double xboxRightY() {
        return deadzoneFilterY(this.xBoxJoystick.getY(Joystick.Hand.kRight));
    }

    public double xboxLeftX() {
        return deadzoneFilterX(this.xBoxJoystick.getX(Joystick.Hand.kLeft));
    }

    public double xboxLeftY() {
        return deadzoneFilterY(this.xBoxJoystick.getY(Joystick.Hand.kLeft));
    }

    //Logitech Joystick Code Starts Here
    public double joystickX() {
        return deadzoneFilterX(this.logitechJoystick.getX());
    }

    public double joystickY() {
        return deadzoneFilterY(this.logitechJoystick.getY());
    }

    public double joystickZ() {
        return deadzoneFilterX(this.logitechJoystick.getZ());
    }

    /**
     * returns a value 0 if the logitechJoystick value is within the dead zone
     * (if the logitechJoystick is outside of the dead zone it returns the
     * logitechJoystick value)
     *
     * @param joyStickValue
     * @return
     */
    private double deadzoneFilterY(double joyStickValue) {
        if (Math.abs(joyStickValue) <= DEADZONE_Y) {
            return 0;
        }
        double sub = joyStickValue / Math.abs(joyStickValue);
        return (joyStickValue - sub * DEADZONE_Y) / 0.8;

    }

    private double deadzoneFilterX(double joyStickValue) {
        if (Math.abs(joyStickValue) <= DEADZONE_X) {
            return 0;
        }
        double sub = joyStickValue / Math.abs(joyStickValue);
        return (joyStickValue - sub * DEADZONE_X) / 0.8;
    }

    public boolean logitechTriggerPressed() {
        return this.logitechJoystick.getTrigger();

    }

}
