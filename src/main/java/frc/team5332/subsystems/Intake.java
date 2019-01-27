package frc.team5332.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {
    DoubleSolenoid hoodPistons;
    DoubleSolenoid rollerPistons;
    DoubleSolenoid hatchGrabber;

    SpeedControllerGroup cargoRollers;

    public Intake(){

    }

    @Override
    protected void initDefaultCommand() {
        
    }

    public void changeHoodState(){

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

    }

    public void changeRollerIntakeState(DoubleSolenoid.Value newValue){
        rollerPistons.set(newValue);
    }

    public void setRollerSpeed(double speed){
        cargoRollers.set(speed);
    }

}
