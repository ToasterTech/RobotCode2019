package frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team5332.robot.CMap;
import frc.team5332.subsystems.Intake;

public class CargoMode extends CommandGroup {

    public CargoMode() {
        addSequential(new ChangeGrabberState(false));
        addSequential(new ChangeHoodState(false));
        addSequential(new ChangeRollerIntakeState(true));

    }

    protected void execute() {
        System.out.println("Cargo");
        CMap.intake.setCurrentState(Intake.State.CARGO);

        CMap.rightbumper = new JoystickButton(CMap.gamepad, 6);
        CMap.rightbumper.whileHeld(new IntakeCargo());
    }

}
