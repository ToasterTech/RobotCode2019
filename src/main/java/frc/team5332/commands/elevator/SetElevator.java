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

        if(buttonID == 5) {
            if(CMap.elevator.isEnabled()){
                CMap.elevator.disable();
            }

            if(!CMap.elevator.getElevatorBottomLimitSwitch()){
                CMap.elevator.setElevatorSpeed(0.2);
            }

        } else if(CMap.intake.getState() == Intake.State.HATCH){

            switch (buttonID){

                case 1:
                    CMap.elevator.setSetpoint(CMap.elevator.ROCKET_LEVEL_3_HATCH);
                    break;

                case 2:
                    CMap.elevator.setSetpoint(CMap.elevator.ROCKET_LEVEL_2_HATCH);
                    break;

                case 3:
                    CMap.elevator.setSetpoint(CMap.elevator.HATCH_ZERO);
                    break;

                case 4:
                    CMap.elevator.setSetpoint(CMap.elevator.HATCH_ZERO);
                    break;

            }

        } else if(CMap.intake.getState() == Intake.State.CARGO){
            switch (buttonID){

                case 1:
                    CMap.elevator.setSetpoint(CMap.elevator.ROCKET_LEVEL_3_CARGO);
                    break;

                case 2:
                    CMap.elevator.setSetpoint(CMap.elevator.ROCKET_LEVEL_2_CARGO);
                    break;

                case 3:
                    CMap.elevator.setSetpoint(CMap.elevator.ROCKET_LEVEL_1_CARGO);
                    break;

                case 4:
                    CMap.elevator.setSetpoint(CMap.elevator.CARGO_SHIP_SCORING);
                    break;

            }
        } else if(buttonID == 6) {
            CMap.elevator.setSetpointRelative(1.5);
        } else if(buttonID == 7){
            CMap.elevator.setSetpointRelative(-1.5);
        }

        /*

        System.out.println("SETTING NEW SETPOINT");
        if(setRelative) {
            System.out.println("Setting New Setpoint: " + setpoint);
            CMap.elevator.setSetpoint(setpoint);
        } else {
            System.out.println("Setting New Relative Setpoint: " + setpoint);
            CMap.elevator.setSetpointRelative(setpoint);
        }*/

    }

    protected boolean isFinished() {
        if(buttonID == 5){
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
