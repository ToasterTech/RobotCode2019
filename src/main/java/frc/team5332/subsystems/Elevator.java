package frc.team5332.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team5332.robot.CMap;

public class Elevator extends Subsystem {
    VictorSP flippedElevatorMotor;
    public SpeedControllerGroup elevatorMotors;

    public Elevator(){

        //We will add the elevator motor ports when we get there.
        flippedElevatorMotor = new VictorSP(CMap.elevatorWenchMotor2);
        flippedElevatorMotor.setInverted(true);

        elevatorMotors = new SpeedControllerGroup(new VictorSP(CMap.elevatorWenchMotor1), flippedElevatorMotor);

    }

    @Override
    protected void initDefaultCommand() {
        //Don't worry about this
    }

    public void setElevatorSpeed(double speed){
        elevatorMotors.set(speed);
    }


}
