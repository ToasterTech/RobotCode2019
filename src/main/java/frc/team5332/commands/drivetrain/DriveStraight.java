package frc.team5332.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;

public class DriveStraight extends Command {

    public DriveStraight(){

    }
    @Override
    protected void execute(){
        CMap.drivetrain.setTankDrive(.5,.5);
    }
    @Override
    protected boolean isFinished() {return false;}

    protected void end() {
    }








}
