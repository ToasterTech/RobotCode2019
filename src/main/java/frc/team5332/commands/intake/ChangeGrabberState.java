package frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;

public class ChangeGrabberState extends Command {
    public ChangeGrabberState(){

    }
    @Override
    protected void execute() {
        CMap.intake.changeHatchGrabberState();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end  {

    }
}




