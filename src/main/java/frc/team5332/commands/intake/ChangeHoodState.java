package frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;

public class ChangeHoodState extends Command {
    DoubleSolenoid.Value preferredState;

    public ChangeHoodState(){
        preferredState = null;
    }

    public ChangeHoodState(DoubleSolenoid.Value preferredState){
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




