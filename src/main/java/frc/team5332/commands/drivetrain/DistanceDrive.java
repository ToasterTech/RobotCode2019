package frc.team5332.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;
import frc.team5332.subsystems.Drivetrain;

public class DistanceDrive extends Command {
   double leftdistance , rightdistance;

   public DistanceDrive(double leftdist , double rightdist) {

       leftdistance = leftdist;
       rightdistance = rightdist;
   }

    protected void execute() {

        CMap.drivetrain.setLeftSetpoint(leftdistance);
        CMap.drivetrain.setRightSetpoint(rightdistance);
    }

    protected boolean isFinished() {
       return CMap.drivetrain.PIDFinished();
    }

    protected void end() {

       CMap.drivetrain.disablePID();
    }

}
