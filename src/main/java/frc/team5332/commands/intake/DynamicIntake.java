package frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;
import frc.team5332.subsystems.Intake.State;

public class DynamicIntake extends Command {
    boolean isPressed = false;

    boolean checkedSwitch = false;


    public DynamicIntake(){

    }

    @Override
    protected void execute() {

        if(CMap.rightBumperPressed) {
            if (CMap.intake.getState() == State.HATCH) {

                if (!CMap.intake.dynamicHatchIntakeRanBefore) {
                    CMap.intake.changeHatchGrabberState();
                    CMap.intake.dynamicHatchIntakeRanBefore = true;
                }

            } else if (CMap.intake.getState() == State.CARGO) {
                CMap.intake.setRollerSpeed(-0.8);
            }
        }
    }

    @Override
    protected boolean isFinished() {
        if(CMap.intake.getState() == State.HATCH || CMap.intake.getState() == State.RESET){
            return true;
        } else {
            return CMap.intake.getLimitSwitch();
        }
    }

    @Override
    protected void end() {
        if(CMap.intake.getState() == State.CARGO){

            for(int i = 0; i < 18; i++) {
                CMap.intake.setRollerSpeed(-0.4);
            }

            CMap.intake.stopMotors();

        } else {
            CMap.intake.dynamicHatchIntakeRanBefore = false;
        }
    }
}
