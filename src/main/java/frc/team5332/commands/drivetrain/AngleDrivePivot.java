package frc.team5332.commands.drivetrain;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;

public class AngleDrivePivot extends Command {
    double angle;
    double distancebetweenwheels=25;
    double wheeldistance;


    public AngleDrivePivot(double angle){
        this.angle = angle;
        wheeldistance = ((2 * Math.PI * distancebetweenwheels * angle) / (360.0*4));
        DriverStation.reportWarning("Wheel Distance: " + wheeldistance, false);

    }
    protected void execute() {
        /*
        if(angle > 0){
            CMap.drivetrain.setLeftSetpoint(wheeldistance);
            DriverStation.reportWarning("Left Setpoint: " + wheeldistance, false);
        } else {
            CMap.drivetrain.setRightSetpoint(wheeldistance);
            DriverStation.reportWarning("Right Setpoint: " + -wheeldistance, false);
        }*/

        CMap.drivetrain.setLeftSetpoint(wheeldistance);



    }
    protected boolean isFinished() {
        return CMap.drivetrain.PIDFinished();
    }

    protected void end() {
        DriverStation.reportWarning("Angle Drive Finished", false);
        CMap.drivetrain.disablePID();
    }

}


