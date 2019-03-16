package frc.team5332.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team5332.robot.CMap;

import java.security.PublicKey;

public class Elevator extends PIDSubsystem {
    VictorSP flippedElevatorMotor;
    SpeedControllerGroup elevatorMotors;
    PIDController elevatorPIDController;

    DigitalInput elevatorTopLimitSwitch;
    DigitalInput elevatorBottomLimitSwitch;

    Encoder elevatorEncoder;

    public Elevator(){
        super(0.2, 0, 0);
        //disable();
        setAbsoluteTolerance(0.2);

        //We will add the elevator motor ports when we get there.
        flippedElevatorMotor = new VictorSP(CMap.elevatorWenchMotor2);
        flippedElevatorMotor.setInverted(false);

        elevatorEncoder = new Encoder(CMap.elevatorEncoderA, CMap.elevatorEncoderB, true, CounterBase.EncodingType.k1X);
        elevatorEncoder.setDistancePerPulse(27.75/(1090));

        elevatorTopLimitSwitch = new DigitalInput(CMap.elevatorTopLimitSwitch);
        elevatorBottomLimitSwitch = new DigitalInput(CMap.elevatorBottomLimitSwitch);

        elevatorMotors = new SpeedControllerGroup(new VictorSP(CMap.elevatorWenchMotor1), flippedElevatorMotor);
        setOutputRange(-.7, .7);

        //elevatorPIDController = new PIDController(0.5, 0, 0, opticalSensor, elevatorMotors);
        //elevatorPIDController.setAbsoluteTolerance(0.5);

    }

    @Override
    protected void initDefaultCommand() {
        //Don't worry about this
    }

    @Override
    public void enable() {
        super.enable();
        elevatorEncoder.reset();
        elevatorEncoder.reset();
    }

    @Override
    protected double returnPIDInput() {
        return elevatorEncoder.getDistance();
    }

    @Override
    protected void usePIDOutput(double output){
        setElevatorSpeed(-output);
    }

    public void setElevatorSpeed(double speed){
        elevatorMotors.set(speed);
    }

    public boolean getElevatorTopLimitSwitch(){
        return elevatorTopLimitSwitch.get();

    }

    public boolean getElevatorBottomLimitSwitch(){
        return elevatorBottomLimitSwitch.get();
    }

    public void resetencoder(){
        elevatorEncoder.reset();
    }

    public void printEncoderOutputs(){
        System.out.println("Elevator Encoder: " + elevatorEncoder.getDistance());
    }


}
