package frc.team5332.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team5332.robot.CMap;

public class    Intake extends Subsystem {
    DoubleSolenoid hoodPistons;
    DoubleSolenoid rollerPistons;
    DoubleSolenoid hatchGrabber;

    SpeedControllerGroup cargoRollers;

    DigitalInput limitSwitch;

    State currentState;

    public enum State{
        RESET,
        HATCH,
        CARGO
    }

    public Intake(){
        limitSwitch = new DigitalInput(CMap.limitSwitch);
        currentState = State.RESET;
    }

    @Override
    protected void initDefaultCommand() {

    }

    public void changeHoodState(){
        DoubleSolenoid.Value currentstate = hoodPistons.get();
        if (currentstate == DoubleSolenoid.Value.kForward) {
            hoodPistons.set(DoubleSolenoid.Value.kReverse);
        } else {
            hoodPistons.set(DoubleSolenoid.Value.kForward);
        }


    }

    public void changeHoodState(DoubleSolenoid.Value newValue){
        hoodPistons.set(newValue);
    }

    public void changeHatchGrabberState(){
        DoubleSolenoid.Value currentstate = hatchGrabber.get();
        if (currentstate == DoubleSolenoid.Value.kForward) {
            hatchGrabber.set(DoubleSolenoid.Value.kReverse);
        } else {
            hatchGrabber.set(DoubleSolenoid.Value.kForward);
        }
    }

    public void changeHatchGrabberState(DoubleSolenoid.Value newValue){
        hatchGrabber.set(newValue);
    }

    public void changeRollerIntakeState(){
        DoubleSolenoid.Value currentstate = rollerPistons.get();
        if (currentstate == DoubleSolenoid.Value.kForward) {
            rollerPistons.set(DoubleSolenoid.Value.kReverse);
        } else {
            rollerPistons.set(DoubleSolenoid.Value.kForward);
        }

    }

    public State getState(){
        return currentState;
    }

    public void setCurrentState(State newState){
        currentState = newState;
    }

    public void changeRollerIntakeState(DoubleSolenoid.Value newValue){
        rollerPistons.set(newValue);
    }

    public void setRollerSpeed(double speed){
        cargoRollers.set(speed);
    }

    public boolean getLimitSwitch(){
        return limitSwitch.get();
    }
}
