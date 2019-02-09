package frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class CargoMode extends CommandGroup {

    public CargoMode() {
        addSequential(new ChangeHoodState(DoubleSolenoid.Value.kForward));
        addSequential(new ChangeRollerIntakeState(DoubleSolenoid.Value.kReverse));

    }
}
