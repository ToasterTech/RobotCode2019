package frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;

public class ChangeGrabberState extends Command {
    boolean preferredState;
    boolean settingToPreferredState;

    public ChangeGrabberState(){
        preferredState = false;
        settingToPreferredState = false;
    }

    public ChangeGrabberState(boolean preferredState){
        this.preferredState = preferredState;
        settingToPreferredState = true;
    }

    @Override
    protected void execute() {
        if(!settingToPreferredState){
            CMap.intake.changeHatchGrabberState();
        } else {
            CMap.intake.changeHatchGrabberState(preferredState);
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




