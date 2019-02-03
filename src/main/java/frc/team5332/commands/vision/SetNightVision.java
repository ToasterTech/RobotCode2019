package frc.team5332.commands.vision;


import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;

public class SetNightVision extends Command {

    public SetNightVision() {


    }


    protected void execute() {

        CMap.setNightVision.setBoolean(true);
    }

    protected boolean isFinished() {
        return false;
    }


    protected void end() {super.end();}

}