package frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;

public class ChangeRollerIntakeState extends Command {
    boolean preferredState;
    boolean settingToPreferredState;

    public ChangeRollerIntakeState(){
        preferredState = false;
        settingToPreferredState = false;
    }

    public ChangeRollerIntakeState(boolean preferredState){
        this.preferredState = preferredState;
        settingToPreferredState = true;
    }
    
    @Override
    protected void execute() {
        if(!settingToPreferredState){
            CMap.intake.changeRollerIntakeState();
        } else {
            CMap.intake.changeRollerIntakeState(preferredState);
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




