package frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team5332.robot.CMap;
import frc.team5332.subsystems.Intake;

public class HatchMode extends CommandGroup {

    public HatchMode() {
        addSequential(new ChangeHoodState(true));
        addSequential(new ChangeRollerIntakeState(false));
    }

    @Override
    protected void execute() {
        super.execute();
        System.out.println("hatch Mode");
        CMap.intake.setCurrentState(Intake.State.HATCH);
        CMap.rightbumper.whileHeld(new ChangeGrabberState());
    }

}
