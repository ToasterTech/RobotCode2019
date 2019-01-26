package frc.team5332.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;

public class AngleDrive extends Command {
    double angle;
    double distancebetweenwheels=25;
    double wheeldistance;


    public AngleDrive(double angle){
        this.angle = angle;
        wheeldistance = (2 * Math.PI * distancebetweenwheels * 0.5 * angle) / 360.0;

    }
    protected void execute() {

        CMap.drivetrain.setLeftSetpoint(wheeldistance);
        CMap.drivetrain.setRightSetpoint(-wheeldistance);
    }
    protected boolean isFinished() {
        return CMap.drivetrain.PIDFinished();
    }

    protected void end() {

        CMap.drivetrain.disablePID();
    }

}


