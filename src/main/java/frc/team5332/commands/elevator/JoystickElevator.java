package frc.team5332.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;

public class JoystickElevator extends Command {

    public JoystickElevator(){

    }

    @Override
    protected void execute() {
        CMap.elevator.setElevatorSpeed(CMap.operatorStick.getY());
    }






    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {

    }
}
