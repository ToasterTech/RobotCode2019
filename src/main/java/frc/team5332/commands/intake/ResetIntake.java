package frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team5332.robot.CMap;
import frc.team5332.subsystems.Intake;

public class ResetIntake extends CommandGroup {

    public ResetIntake() {
        addSequential(new ChangeHoodState(false));
        addSequential(new ChangeRollerIntakeState(false));
        addSequential(new ChangeGrabberState(false));

    }

    protected void execute() {
        CMap.intake.setCurrentState(Intake.State.RESET);
    }
}
