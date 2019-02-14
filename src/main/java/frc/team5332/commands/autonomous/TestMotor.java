package frc.team5332.commands.autonomous;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;

public class TestMotor extends Command {
    SpeedControllerGroup leftMotors;

    VictorSP motor;
    double speed;

    public TestMotor(int motorPort, double speed){
        //leftMotors = new SpeedControllerGroup(new VictorSP(CMap.leftDriveMotor1), new VictorSP(CMap.leftDriveMotor2), new VictorSP(CMap.leftDriveMotor3));

        motor = new VictorSP(motorPort);
        this.speed = speed;
    }

    @Override
    protected void execute() {
        motor.set(speed);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        super.end();
    }
}
