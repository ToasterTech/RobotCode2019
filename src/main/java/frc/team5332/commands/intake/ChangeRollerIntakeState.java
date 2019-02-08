package frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;

public class ChangeRollerIntakeState extends Command {
    DoubleSolenoid.Value preferredState;

    public ChangeRollerIntakeState(){
        preferredState = null;
    }

    public ChangeRollerIntakeState(DoubleSolenoid.Value preferredState){
        this.preferredState = preferredState;
    }
    
    @Override
    protected void execute() {
        if(preferredState != null){
            CMap.intake.changeHoodState(preferredState);
        } else {
            CMap.intake.changeHoodState();
        }
    }
    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {

    }
}




