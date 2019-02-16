package frc.team5332.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;
import frc.team5332.subsystems.Drivetrain;

public class SetElevator extends Command {
    double distance;

    public SetElevator(double distance) {


    }

    protected void execute() {

    }

    protected boolean isFinished() {
        return CMap.drivetrain.PIDFinished();
    }

    protected void end() {


    }

}
