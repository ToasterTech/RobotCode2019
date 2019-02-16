package frc.team5332.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;

public class JoystickDrive extends Command {

    public JoystickDrive(){

    }

    @Override
    protected void execute() {
        if(!CMap.visionAlignmentInProgress) {
            CMap.drivetrain.setTankDrive(-CMap.gamepad.getRawAxis(1) * .5, -CMap.gamepad.getRawAxis(5) * .5);
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
