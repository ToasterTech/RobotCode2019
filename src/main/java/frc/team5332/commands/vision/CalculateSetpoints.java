package frc.team5332.commands.vision;

import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;

public class CalculateSetpoints extends Command {
    //All measurements are in feet and degrees
    double distanceBetweenWheels = 0;
    double setpointToAdd;
    double angleFromCenter;


    public CalculateSetpoints(){

    }

    @Override
    protected void execute() {
        setpointToAdd = (2 * Math.PI * distanceBetweenWheels * 0.5 * angleFromCenter) / 360.0;

        if (CMap.drivetrain.PIDFinished()){
            CMap.drivetrain.setLeftSetpoint(setpointToAdd);
            CMap.drivetrain.setRightSetpoint(setpointToAdd);
        }
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
