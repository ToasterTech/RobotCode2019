package frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;

public class ChangeRollerIntakeState extends Command {
    public ChangeRollerIntakeState(){
    
    }
    @Override
    protected void execute() {
        CMap.intake.changeRollerIntakeState();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {

    }
}




