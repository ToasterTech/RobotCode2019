package frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team5332.robot.CMap;
import frc.team5332.subsystems.Intake;

public class HatchMode extends CommandGroup {

    public HatchMode() {
        addSequential(new ChangeHoodState(DoubleSolenoid.Value.kReverse));
        addSequential(new ChangeRollerIntakeState(DoubleSolenoid.Value.kForward));
    }

    @Override
    protected void execute() {
        CMap.intake.setCurrentState(Intake.State.HATCH);
    }
}
