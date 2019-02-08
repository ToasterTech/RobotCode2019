package frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;

public class ChangeGrabberState extends Command {
    DoubleSolenoid.Value preferredState;

    public ChangeGrabberState(){
        preferredState = null;
    }

    public ChangeGrabberState(DoubleSolenoid.Value preferredState){
        this.preferredState = preferredState;
    }

    @Override
    protected void execute() {
        if(preferredState != null){
            CMap.intake.changeHatchGrabberState(preferredState);
        } else {
            CMap.intake.changeHatchGrabberState();
        }
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end()  {

    }
}




