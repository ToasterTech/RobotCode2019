package frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;

public class IntakeCargo extends Command {
    public IntakeCargo(){

    }

    @Override
    protected void execute() {
        CMap.intake.setRollerSpeed(1.0);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {

    }
}
