package frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;
import frc.team5332.subsystems.Intake;

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
        System.out.println("Running Change Grabber State");
        System.out.println("Current State: " + CMap.intake.getState());
        System.out.println("Setting to Parameter: " + settingToPreferredState);
        if(CMap.intake.getState() == Intake.State.HATCH) {
            if (!settingToPreferredState) {
                System.out.println("Runnning No Paramerter");;
                CMap.intake.changeHatchGrabberState();
            } else {
                System.out.println("Running Preffered");
                CMap.intake.changeHatchGrabberState(preferredState);
            }
        }
    }
    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {
        settingToPreferredState = false;
    }
}




