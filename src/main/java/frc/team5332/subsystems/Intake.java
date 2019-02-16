package frc.team5332.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team5332.robot.CMap;

public class    Intake extends Subsystem {
    Solenoid hoodPistons;
    Solenoid rollerPistons;
    Solenoid hatchGrabber;

    VictorSP cargoRollers;

    DigitalInput limitSwitch;

    State currentState;

    public enum State{
        RESET,
        HATCH,
        CARGO
    }

    public Intake(){
        limitSwitch = new DigitalInput(CMap.limitSwitch);
        cargoRollers = new VictorSP(CMap.intakeMotor1);
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
        System.out.println("Old Hood: " + currentstate);
        hoodPistons.set(!currentstate);
        System.out.println("New Hood: " + currentstate);


    }

    public void changeHoodState(boolean newValue){
        hoodPistons.set(newValue);
    }

    public void changeHatchGrabberState(){
        System.out.println("Change Hatch Grabber");
        boolean currentstate = hatchGrabber.get();
        System.out.println("Previous Setting: " + currentstate);
        hatchGrabber.set(!currentstate);
        System.out.println("New Setting: " + hatchGrabber.get());
    }

    public void changeHatchGrabberState(boolean newValue){
        hatchGrabber.set(newValue);
    }

    public void changeRollerIntakeState(){
        boolean currentstate = rollerPistons.get();
        rollerPistons.set(!currentstate);

    }

    public void stopMotors(){
        cargoRollers.stopMotor();
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
