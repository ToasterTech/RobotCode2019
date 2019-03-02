package frc.team5332.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team5332.robot.CMap;

public class Drivetrain extends PIDSubsystem {
    PWMTalonSRX leftMotor1, leftmotor2, leftMotor3, rightMotor1,rightmotor2, rightMotor3;

    SpeedControllerGroup leftMotors, rightMotors;

    AHRS gyro;


    public Drivetrain(){
        super(0.2, 0, 0);

        leftMotor1  = new PWMTalonSRX(CMap.leftDriveMotor1);
        leftmotor2  = new PWMTalonSRX(CMap.leftDriveMotor2);
        leftMotor3 = new PWMTalonSRX(CMap.leftDriveMotor3);
        rightMotor1 = new PWMTalonSRX(CMap.rightDriveMotor1);
        rightmotor2 = new PWMTalonSRX (CMap.rightDriveMotor2);
        rightMotor3 = new PWMTalonSRX(CMap.rightDriveMotor3);

        leftMotors  = new SpeedControllerGroup(leftMotor1, leftmotor2, leftMotor3);
        rightMotors = new SpeedControllerGroup(rightMotor1, rightmotor2, rightMotor3);

        rightMotors.setInverted(true);

        gyro = new AHRS(SPI.Port.kMXP);

    }

    @Override
    protected void initDefaultCommand() {

    }


    public void setTankDrive(double leftspeed, double rightspeed){
        leftMotors.set(leftspeed);
        rightMotors.set(rightspeed);
    }



    @Override
    protected double returnPIDInput() {
        return gyro.getAngle();
    }

    @Override
    protected void usePIDOutput(double output) {
        setTankDrive(-output, output);
    }

    public double getAngle(){
        return gyro.getAngle();
    }


}
