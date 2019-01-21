package frc.team5332.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;

public class TimeDrive extends Command {
    double time, leftspeed, rightspeed;

    public TimeDrive(double time, double leftspeed, double rightspeed) {
        this.time = time;
        this.leftspeed = leftspeed;
        this.rightspeed = rightspeed;


    }

    @Override
    protected void execute() {
        CMap.drivetrain.setTankDrive( leftspeed, rightspeed);
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
