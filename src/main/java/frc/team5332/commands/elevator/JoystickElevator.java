package frc.team5332.commands.elevator;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;

import java.awt.*;

public class JoystickElevator extends Command {
    boolean previouslyReset = false;

    public JoystickElevator(){

    }

    @Override
    protected void execute() {
        if(CMap.elevator.isEnabled()){
            CMap.elevator.disable();
        }
        System.out.println(CMap.elevator.getElevatorTopLimitSwitch());

        if (CMap.elevator.getElevatorTopLimitSwitch() && (CMap.operatorStick.getY() > 0)) {
            System.out.println("Running Limit Switch Code");
            CMap.elevator.setElevatorSpeed(0);
        } else {
            CMap.elevator.setElevatorSpeed(-CMap.operatorStick.getY());
            System.out.println("Not");
        }

        //CMap.elevator.setElevatorSpeed(CMap.operatorStick.getY());

        //CMap.elevator.setElevatorSpeed(CMap.operatorStick.getY());






    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        CMap.elevator.enable();
        CMap.elevator.setSetpointRelative(0);

    }
}
