package frc.team5332.commands.vision;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team5332.commands.drivetrain.AngleDrive;
import frc.team5332.commands.drivetrain.JoystickDrive;
import frc.team5332.robot.CMap;

import java.sql.Driver;

public class VisionAlign extends CommandGroup {
    double visionAngle;
    boolean valueGrabbed = false;

    public VisionAlign() {

    }

    @Override
    protected void execute() {
        if(!valueGrabbed){
            visionAngle = CMap.angle.getDouble(0);
            DriverStation.reportWarning("Vision Angle: " + visionAngle, false);
            addSequential(new AngleDrive(visionAngle));

            valueGrabbed = true;
            CMap.visionAlignmentInProgress = true;
        }

        super.execute();
    }

    @Override
    protected void end() {
        DriverStation.reportWarning("Vision Alignment Complete", false);
        CMap.visionAlignmentInProgress = false;
    }
}