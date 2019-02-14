package frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;

public class ChangeHoodState extends Command {
    boolean preferredState;
    boolean settingToPreferredState;

    public ChangeHoodState(){
        preferredState = false;
        settingToPreferredState = false;
    }

    public ChangeHoodState(boolean preferredState){
        this.preferredState = preferredState;
        settingToPreferredState = true;
    }

    @Override
    protected void execute() {
        if(!settingToPreferredState){
            CMap.intake.changeHoodState();
        } else {
            CMap.intake.changeHoodState(preferredState);
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




