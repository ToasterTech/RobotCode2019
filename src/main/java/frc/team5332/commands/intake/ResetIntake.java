package frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team5332.robot.CMap;
import frc.team5332.subsystems.Intake;

public class ResetIntake extends CommandGroup {

    public ResetIntake() {

        addSequential(new ResetHatchGrabber());
        //addSequential(new ChangeGrabberState(false));
        addSequential(new ChangeRollerIntakeState(false));
        addSequential(new ChangeHoodState(false));

    }

    protected void execute() {
        CMap.intake.setCurrentState(Intake.State.RESET);
        CMap.intake.changeHatchGrabberState(false);

        System.out.println("Reset Intake State");
        //CMap.intake.setCurrentState(Intake.State.RESET);
    }

    @Override
    protected boolean isFinished() {
        return !CMap.intake.getGrabberState();
    }
}
