package frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team5332.robot.CMap;
import frc.team5332.subsystems.Intake;

public class CargoMode extends CommandGroup {

    public CargoMode() {
        addSequential(new ChangeHoodState(false));
        addSequential(new ChangeRollerIntakeState(true));

    }

    protected void execute() {
        System.out.println("CARGO MODE");
        CMap.intake.setCurrentState(Intake.State.CARGO);
        CMap.rightbumper.whileHeld(new IntakeCargo());
    }

}
