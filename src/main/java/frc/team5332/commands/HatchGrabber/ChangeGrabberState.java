package frc.team5332.commands.HatchGrabber;

import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;

public class ChangeGrabberState extends Command {
    public ChangeGrabberState(){
        System.out.println("constructer ram");

    }
    @Override
    protected void execute() {
        CMap.hatchGrabber.changstate();
        System.out.println("execute");
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {
        System.out.println("end");
    }
}




