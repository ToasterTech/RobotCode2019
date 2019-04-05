package frc.team5332.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;
import frc.team5332.subsystems.Elevator;
import frc.team5332.subsystems.Intake;

public class SetElevator extends Command {
    double setpoint;
    boolean setRelative;

    int buttonID = -1;

    public SetElevator(double setpoint, boolean setRelative) {
       this.setpoint = setpoint;
       this.setRelative = setRelative;


    }

    public SetElevator(int buttonID){
        this.buttonID = buttonID;
        this.setRelative = setRelative;
    }

    protected void execute() {

        if(buttonID == 10){
            CMap.elevator.setElevatorSpeed(0.2);
        } else if(buttonID == 6){
            CMap.elevator.setSetpoint(CMap.elevator.CARGO_SHIP_SCORING);
        } else if(buttonID == 7){
            CMap.elevator.setSetpoint(CMap.elevator.HATCH_ZERO);
        }

    }

    protected boolean isFinished() {
        if(buttonID == 10){
            return CMap.elevator.getElevatorBottomLimitSwitch();
        } else {
            return true;
        }

    }

    protected void end() {
        if(buttonID == 5){
            CMap.elevator.enable();
        }
        System.out.println("New Setpoint: " + CMap.elevator.getSetpoint());
    }

}
