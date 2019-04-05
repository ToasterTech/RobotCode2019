package frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;

public class ReadBumperPress extends Command {

    public ReadBumperPress(){

    }

    @Override
    protected void execute() {
        CMap.rightBumperPressed = true;


    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        CMap.rightBumperPressed = false;
    }
}
