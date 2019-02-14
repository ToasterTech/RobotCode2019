package frc.team5332.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;
import frc.team5332.robot.CMap;

public class    Intake extends Subsystem {
    Solenoid hoodPistons;
    Solenoid rollerPistons;
    Solenoid hatchGrabber;

    SpeedControllerGroup cargoRollers;

    DigitalInput limitSwitch;

    State currentState;

    public enum State{
        RESET,
        HATCH,
        CARGO
    }

    public Intake(){
        //limitSwitch = new DigitalInput(CMap.limitSwitch);
        currentState = State.RESET;

        hoodPistons = new Solenoid(CMap.hoodSolenoid);
        rollerPistons = new Solenoid(CMap.rollerSolenoid);
        hatchGrabber = new Solenoid(CMap.hatchGrabberSolenoid);
    }

    @Override
    protected void initDefaultCommand() {

    }

    public void changeHoodState(){
        boolean currentstate = hoodPistons.get();
        if (currentstate) {
            hoodPistons.set(false);
        } else {
            hoodPistons.set(true);
        }


    }

    public void changeHoodState(boolean newValue){
        hoodPistons.set(newValue);
    }

    public void changeHatchGrabberState(){
        boolean currentstate = hoodPistons.get();
        if (currentstate) {
            hatchGrabber.set(false);
        } else {
            hatchGrabber.set(true);
        }
    }

    public void changeHatchGrabberState(boolean newValue){
        hatchGrabber.set(newValue);
    }

    public void changeRollerIntakeState(){
        boolean currentstate = hoodPistons.get();
        if (currentstate) {
            rollerPistons.set(false);
        } else {
            rollerPistons.set(true);
        }

    }

    public State getState(){
        return currentState;
    }

    public void setCurrentState(State newState){
        currentState = newState;
    }

    public void changeRollerIntakeState(boolean newValue){
        rollerPistons.set(newValue);
    }

    public void setRollerSpeed(double speed){
        cargoRollers.set(speed);
    }

    public boolean getLimitSwitch(){
        return limitSwitch.get();
    }
}
