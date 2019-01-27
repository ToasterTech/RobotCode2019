package frc.team5332.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {
    public SpeedControllerGroup elevatorMotors;

    public Elevator(){
        //We will add the elevator motor ports when we get there.
    }

    @Override
    protected void initDefaultCommand() {
        //Don't worry about this
    }

    public void setElevatorSpeed(double speed){
        elevatorMotors.set(speed);
    }


}
