package frc.team5332.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;

public class JoystickDrive extends Command {

    public JoystickDrive(){

    }

    @Override
    protected void execute() {

        double leftTriggerOutput = CMap.gamepad.getRawAxis(CMap.leftTriggerAxis); //Go Backward
        double rightTriggerOutput = CMap.gamepad.getRawAxis(CMap.rightTriggerAxis); //Go Forward


        if(leftTriggerOutput > 0.2 || rightTriggerOutput > 0.2) {
            CMap.driveStraightActive = true;
            if (leftTriggerOutput > 0) {
                CMap.drivetrain.setTankDrive(-leftTriggerOutput, -leftTriggerOutput);
            } else if (rightTriggerOutput > 0) {
                CMap.drivetrain.setTankDrive(rightTriggerOutput, rightTriggerOutput);
            }
        } else {
            CMap.drivetrain.setTankDrive(-CMap.gamepad.getRawAxis(1) * .8, -CMap.gamepad.getRawAxis(5) * .8);
        }

        //System.out.println("toast");

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
