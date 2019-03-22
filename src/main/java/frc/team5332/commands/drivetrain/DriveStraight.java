package frc.team5332.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;

public class DriveStraight extends Command {

    public DriveStraight(){

    }
    @Override
    protected void execute(){
        double leftTriggerOutput = CMap.gamepad.getRawAxis(CMap.leftTriggerAxis); //Go Backward
        double rightTriggerOutput = CMap.gamepad.getRawAxis(CMap.rightTriggerAxis); //Go Forward

        if(leftTriggerOutput > 0 || rightTriggerOutput > 0) {
            CMap.driveStraightActive = true;
            if (leftTriggerOutput > 0) {
                CMap.drivetrain.setTankDrive(-leftTriggerOutput, -leftTriggerOutput);
            } else if (rightTriggerOutput > 0) {
                CMap.drivetrain.setTankDrive(rightTriggerOutput, rightTriggerOutput);
            }
        }

    }
    @Override
    protected boolean isFinished() {return false;}

    protected void end() {
        CMap.driveStraightActive = false;
    }








}
