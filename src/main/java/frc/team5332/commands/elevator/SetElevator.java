package frc.team5332.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;
import frc.team5332.subsystems.Elevator;

public class SetElevator extends Command {
    double leftDistance , rightDistance;

    public SetElevator(double leftdist, double rightdist) {

       leftDistance = leftdist;
       rightDistance = rightdist;


    }

    protected void execute() {


    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {


    }

}
