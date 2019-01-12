package frc.team5332.commands.HatchGrabber;

import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;

public class ChangeGrabberState extends Command {
    @Override
    protected void execute() {
        CMap.hatchGrabber.changstate();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {
        end();
    }
}




