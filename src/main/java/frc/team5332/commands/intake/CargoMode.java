package frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team5332.robot.CMap;
import frc.team5332.subsystems.Intake;

public class CargoMode extends CommandGroup {

    public CargoMode() {
        addSequential(new ChangeHoodState(DoubleSolenoid.Value.kForward));
        addSequential(new ChangeRollerIntakeState(DoubleSolenoid.Value.kReverse));

    }

    protected void execute() {
        CMap.intake.setCurrentState(Intake.State.CARGO);
        CMap.rightbumper.whenPressed(new ChangeRollerIntakeState);
    }

}
