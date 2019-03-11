package frc.team5332.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;

public class JoystickElevator extends Command {

    public JoystickElevator(){

    }

    @Override
    protected void execute() {

        System.out.println(CMap.elevator.getElevatorLimitSwitch());

        if(CMap.elevator.getElevatorLimitSwitch() && (CMap.operatorStick.getY() > 0)){
            System.out.println("Running Limit Switch Code");
            CMap.elevator.setElevatorSpeed(0);
        } else {
            CMap.elevator.setElevatorSpeed(-CMap.operatorStick.getY());
            System.out.println("Not");
        }

        //CMap.elevator.setElevatorSpeed(CMap.operatorStick.getY());
    }






    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {

    }
}
