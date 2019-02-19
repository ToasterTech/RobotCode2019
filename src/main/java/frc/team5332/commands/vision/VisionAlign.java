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
        CMap.drivetrain.enable();
        CMap.drivetrain.setSetpoint(0);
    }

    @Override
    protected boolean isFinished() {
        return CMap.drivetrain.onTarget();
    }

    @Override
    protected void end() {
        DriverStation.reportWarning("Vision Alignment Complete", false);

        valueGrabbed = false;
        CMap.visionAlignmentInProgress = false;

        CMap.drivetrain.disable();

    }
}