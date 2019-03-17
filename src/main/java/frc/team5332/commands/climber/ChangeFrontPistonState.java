package frc.team5332.commands.climber;

import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;

public class ChangeFrontPistonState extends Command {
    boolean preferredState;
    boolean settingToPreferredState;


    public ChangeFrontPistonState() {
        preferredState = true;
        settingToPreferredState = true;

    }

    @Override
    protected void execute(){

    }


    public ChangeFrontPistonState(boolean preferredState) {
        this.preferredState = preferredState;
        settingToPreferredState = true;
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}



