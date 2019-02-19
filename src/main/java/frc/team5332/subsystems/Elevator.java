package frc.team5332.subsystems;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team5332.robot.CMap;

public class Elevator extends Subsystem {
    VictorSP flippedElevatorMotor;
    public SpeedControllerGroup elevatorMotors;
    PIDController elevatorPIDController;

    Counter opticalSensor;

    public Elevator(){
        //We will add the elevator motor ports when we get there.
        flippedElevatorMotor = new VictorSP(CMap.elevatorWenchMotor2);
        flippedElevatorMotor.setInverted(false);

        elevatorMotors = new SpeedControllerGroup(flippedElevatorMotor, new VictorSP(CMap.elevatorWenchMotor1));

        //elevatorPIDController = new PIDController(0.5, 0, 0, opticalSensor, elevatorMotors);
        //elevatorPIDController.setAbsoluteTolerance(0.5);

    }

    @Override
    protected void initDefaultCommand() {
        //Don't worry about this
    }

    public void setElevatorSpeed(double speed){
        elevatorMotors.set(speed);
    }

    public void setElevatorSetpoint(int setpoint){
        elevatorPIDController.enable();
        elevatorPIDController.setSetpoint(setpoint);
    }

    public void disableElevatorPID(){
        elevatorPIDController.disable();
    }

    public boolean PIDFInished(){
        return elevatorPIDController.onTarget();
    }

}
