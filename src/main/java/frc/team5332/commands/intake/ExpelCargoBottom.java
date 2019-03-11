package frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;

public class ExpelCargoBottom extends Command {

    public ExpelCargoBottom(){

    }

    @Override
    protected void execute() {
        System.out.println("Expel Cargo Bottom Mode");
        CMap.intake.setRollerSpeed(1.0);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        CMap.intake.stopMotors();
    }
}
