package frc.team5332.commands.drivetrain;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;

public class AngleDriveTank extends Command {
    double angle;
    double distancebetweenwheels=25;
    double wheeldistance;


    public AngleDriveTank(double angle){
        this.angle = angle;
        wheeldistance = (2 * Math.PI * distancebetweenwheels * 0.5 * angle) / 360.0;

    }
    protected void execute() {
        DriverStation.reportWarning("Left Setpoint: " + wheeldistance, false);
        DriverStation.reportWarning("Right Setpoint: " + -wheeldistance, false);

        CMap.drivetrain.setLeftSetpoint(wheeldistance);
        CMap.drivetrain.setRightSetpoint(-wheeldistance);
    }
    protected boolean isFinished() {
        return CMap.drivetrain.PIDFinished();
    }

    protected void end() {
        DriverStation.reportWarning("Angle Drive Finished", false);
        CMap.drivetrain.disablePID();
    }

}


