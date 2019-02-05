package frc.team5332.commands.vision;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team5332.commands.drivetrain.AngleDrivePivot;
import frc.team5332.commands.drivetrain.JoystickDrive;
import frc.team5332.robot.CMap;

import java.sql.Driver;

public class VisionAlign extends Command {
    double visionAngle;
    boolean valueGrabbed = false;

    double wheeldistance;
    double distancebetweenwheels=25;

    public VisionAlign() {

    }

    @Override
    protected void execute() {
        if(!valueGrabbed){
            visionAngle = CMap.visionTable.getEntry("Angle").getDouble(0);
            visionAngle = visionAngle / 2.0;


            valueGrabbed = true;
            CMap.visionAlignmentInProgress = true;
            wheeldistance = (2 * Math.PI * distancebetweenwheels * visionAngle) / (360.0*4);


            System.out.println("Vision Angle: " + visionAngle);
            System.out.println("Wheel Distance: " + wheeldistance);
        }

        CMap.drivetrain.setLeftSetpoint(wheeldistance);
    }

    @Override
    protected boolean isFinished() {
        return CMap.drivetrain.PIDFinished();
    }

    @Override
    protected void end() {
        DriverStation.reportWarning("Vision Alignment Complete", false);

        valueGrabbed = false;
        CMap.visionAlignmentInProgress = false;

        CMap.drivetrain.disablePID();

    }
}