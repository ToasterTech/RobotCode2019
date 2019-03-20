package frc.team5332.commands.climber;

import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;
import frc.team5332.subsystems.Climber;


public class ChangeAirRegulatorState extends Command {

    public ChangeAirRegulatorState() {

    }


    protected void execute() {
        CMap.climber.changeAirRegulatorState();
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