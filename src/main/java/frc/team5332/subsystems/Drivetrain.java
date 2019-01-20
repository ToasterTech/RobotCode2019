package frc.team5332.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {
    PWMTalonSRX leftMotor1, leftmotor2, rightMotor1,rightmotor2;

    SpeedControllerGroup leftMotors, rightMotors;

    Encoder leftDriveEncoder, rightDriveEncoder;

    public Drivetrain(){
        leftMotor1  = new PWMTalonSRX(1);
        leftmotor2  = new PWMTalonSRX(3);
        rightMotor1 = new PWMTalonSRX(0);
        rightmotor2 = new PWMTalonSRX (2);

        leftMotors  = new SpeedControllerGroup(leftMotor1, leftmotor2);
        rightMotors = new SpeedControllerGroup(rightMotor1, rightmotor2);

        leftDriveEncoder  = new Encoder(0, 1, true, CounterBase.EncodingType.k4X);
        rightDriveEncoder = new Encoder(2, 3, true, CounterBase.EncodingType.k4X);
    }

    @Override
    protected void initDefaultCommand() {

    }

    public void setTankDrive(double leftspeed, double rightspeed){
        leftMotor1.set(leftspeed);
        leftmotor2.set(leftspeed);
        System.out.println(leftspeed);
        rightMotor1.set(rightspeed);
        rightmotor2.set(rightspeed);
        System.out.println(rightspeed);
    }

    public void printEncoderOutputs(){
        System.out.println("Left Encoder: " + leftDriveEncoder.getRaw());
        System.out.println("Right Encoder: " + rightDriveEncoder.getRaw());
    }

    public void stopMotors(){

    }

    // Encoder Stuff

    public void resetEncoders(){

    }

    /// PID Stuff

    // Initialize the PID Controllers for Each Size (0.9 is a placeholder for now)
    PIDController leftDrivePID; // = new PIDController(0.9, 0, 0, leftDriveEncoder, leftMotors);
    PIDController rightDrivePID; // = new PIDController(0.9, 0, 0, rightDriveEncoder, rightMotors);


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
