package frc.team5332.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team5332.robot.CMap;

public class Drivetrain extends Subsystem {
    PWMTalonSRX leftMotor1, leftmotor2, leftMotor3, rightMotor1,rightmotor2, rightMotor3;

    SpeedControllerGroup leftMotors, rightMotors;

    Encoder leftDriveEncoder, rightDriveEncoder;

    PIDController leftDrivePID, rightDrivePID;

    public Drivetrain(){
        leftMotor1  = new PWMTalonSRX(CMap.leftDriveMotor1);
        leftmotor2  = new PWMTalonSRX(CMap.leftDriveMotor2);
        leftMotor3 = new PWMTalonSRX(CMap.leftDriveMotor3);
        rightMotor1 = new PWMTalonSRX(CMap.rightDriveMotor1);
        rightmotor2 = new PWMTalonSRX (CMap.rightDriveMotor2);
        rightMotor3 = new PWMTalonSRX(CMap.rightDriveMotor3);

        leftMotors  = new SpeedControllerGroup(leftMotor1, leftmotor2, leftMotor3);
        rightMotors = new SpeedControllerGroup(rightMotor1, rightmotor2, rightMotor3);

        rightMotors.setInverted(true);

        leftDriveEncoder  = new Encoder(CMap.leftDriveEncoderA, CMap.leftDriveEncoderB, false, CounterBase.EncodingType.k4X);
        rightDriveEncoder = new Encoder(CMap.rightDriveEncoderA, CMap.rightDriveEncoderB, true, CounterBase.EncodingType.k4X);

        leftDriveEncoder.setDistancePerPulse((2*Math.PI*3)/(264*4));
        rightDriveEncoder.setDistancePerPulse((2*Math.PI*3)/(264*4));


        leftDrivePID = new PIDController(0.9, 0, 0, leftDriveEncoder, leftMotors);
        rightDrivePID = new PIDController(0.9, 0, 0, rightDriveEncoder, rightMotors);

        leftDrivePID.setAbsoluteTolerance(.1);
        rightDrivePID.setAbsoluteTolerance(.1);

        leftDrivePID.setOutputRange(-0.2, 0.2);
        rightDrivePID.setOutputRange(-0.2, 0.2);

        leftDrivePID.disable();
        rightDrivePID.disable();
    }

    @Override
    protected void initDefaultCommand() {

    }

    public void setTankDrive(double leftspeed, double rightspeed){
        leftMotors.set(leftspeed);
        rightMotors.set(rightspeed);
    }

    public void printEncoderOutputs(){
        System.out.println("Left Encoder: " + leftDriveEncoder.getDistance());
        System.out.println("Right Encoder: " + rightDriveEncoder.getDistance());
    }

    public void stopMotors(){

    }

    // Encoder Stuff

    public void resetEncoders(){

    }

    /// PID Stuff

    // Initialize the PID Controllers for Each Size (0.9 is a placeholder for now)


    public void setLeftSetpoint(double setpoint){
        leftDrivePID.enable();
        leftDrivePID.setSetpoint(setpoint);
    }

    public void setRightSetpoint(double setpoint){
        rightDrivePID.enable();
        rightDrivePID.setSetpoint(setpoint);
    }

    /**
     * This will check to see if the PID is finished. It will only check the PID that is running.
     * @return
     */
    public boolean PIDFinished(){
        boolean result;

        if (leftDrivePID.isEnabled() && rightDrivePID.isEnabled()){
            result = leftDrivePID.onTarget() && rightDrivePID.onTarget();
        } else if(leftDrivePID.isEnabled()){
            result = leftDrivePID.onTarget();
        } else if(rightDrivePID.isEnabled()){
            result = rightDrivePID.onTarget();
        } else {
            result = true;
            DriverStation.reportWarning("BOTH DRIVETRAIN PIDs ARE DISABLED", false);
        }

        return result;

    }

    public void disablePID(){
        leftDrivePID.disable();
        rightDrivePID.disable();

        leftDriveEncoder.reset();
        rightDriveEncoder.reset();
    }

}
