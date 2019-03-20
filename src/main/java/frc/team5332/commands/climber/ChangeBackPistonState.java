package frc.team5332.commands.climber;

import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;
import frc.team5332.subsystems.Climber;


public class ChangeBackPistonState extends Command {

    public ChangeBackPistonState() {

    }


    protected void execute() {
        CMap.climber.changeBackPistonState();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {
        super.end();
    }
}