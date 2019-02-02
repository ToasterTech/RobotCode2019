package frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;

public class ChangeHoodState extends Command {
    public ChangeHoodState(){

    }
    @Override
    protected void execute() {
        CMap.intake.changeHoodState();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {

    }
}




