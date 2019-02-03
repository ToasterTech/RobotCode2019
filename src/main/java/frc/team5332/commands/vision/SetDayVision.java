package frc.team5332.commands.vision;

import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;

public class SetDayVision extends Command {

    public SetDayVision() {


    }


    protected void execute() {

        CMap.setDayVision.setBoolean(true);
    }

    protected boolean isFinished() {
        return false;
    }


    protected void end() {super.end();}

}
