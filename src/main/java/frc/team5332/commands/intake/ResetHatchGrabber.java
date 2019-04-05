package frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;

public class ResetHatchGrabber extends Command {

    public ResetHatchGrabber(){

    }

    @Override
    protected void execute() {
        CMap.intake.changeHatchGrabberState(false);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {
        super.end();
    }
}
