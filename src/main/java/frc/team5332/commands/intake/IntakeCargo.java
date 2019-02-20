package frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;
import frc.team5332.subsystems.Intake;

public class IntakeCargo extends Command {
    boolean checkedSwitch = false;
    boolean expelling = false;
    public IntakeCargo(){
    }

    @Override
    protected void execute() {
        System.out.println(CMap.intake.getState());
        if(CMap.intake.getState() == Intake.State.CARGO) {
            if (checkedSwitch) {
                CMap.intake.setRollerSpeed(-0.5);
            }

            if (CMap.intake.getLimitSwitch()) {
                System.out.println("Limit Switch True");
            }
        }

    }

    @Override
    protected boolean isFinished() {
        System.out.println(CMap.intake.getLimitSwitch());
        checkedSwitch = true;
        return CMap.intake.getLimitSwitch();

    }

    @Override
    protected void end() {
        checkedSwitch = false;
        CMap.intake.stopMotors();

    }
}
