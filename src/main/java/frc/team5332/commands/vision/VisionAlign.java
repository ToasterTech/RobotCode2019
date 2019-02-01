package frc.team5332.commands.vision;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team5332.commands.drivetrain.AngleDrive;
import frc.team5332.robot.CMap;

import java.sql.Driver;

public class VisionAlign extends CommandGroup {
    double visionAngle;

    public VisionAlign() {
        visionAngle = CMap.angle.getDouble(0);
        DriverStation.reportWarning("Vision Angle: " + visionAngle, false);

        addSequential(new AngleDrive(visionAngle));
    }

    @Override
    protected void end() {
        DriverStation.reportWarning("Vision Alignment Complete", false);
    }
}