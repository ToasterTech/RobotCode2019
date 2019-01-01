package frc.team5332.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {
    SpeedControllerGroup leftMotors, rightMotors;

    Encoder leftDriveEncoder, rightDriveEncoder;

    public Drivetrain(){

    }

    @Override
    protected void initDefaultCommand() {

    }

    public void setTankDrive(double leftDrive, double rightDrive){

    }

    public void stopMotors(){

    }

    // Encoder Stuff

    public void resetEncoders(){

    }

    /// PID Stuff

    // Initialize the PID Controllers for Each Size (0.9 is a placeholder for now)
    PIDController leftDrivePID = new PIDController(0.9, 0, 0, leftDriveEncoder, leftMotors);
    PIDController rightDrivePID = new PIDController(0.9, 0, 0, rightDriveEncoder, rightMotors);


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
