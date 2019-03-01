package frc.team5332.commands.drivetrain;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;

public class AngleDriveTank extends Command {
    double angle;

    public AngleDriveTank(double angle){
        this.angle = angle;

    }
    protected void execute() {
        CMap.drivetrain.setSetpointRelative(angle);
    }
    protected boolean isFinished() {
        return CMap.drivetrain.onTarget();
    }

    protected void end() {
        DriverStation.reportWarning("Angle Drive Finished", false);
        CMap.drivetrain.disable();
    }

}


