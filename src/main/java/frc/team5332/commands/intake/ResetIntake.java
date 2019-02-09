package frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ResetIntake extends CommandGroup {

    public ResetIntake(){
        addSequential(new ChangeHoodState(DoubleSolenoid.Value.kForward));
        addSequential(new ChangeRollerIntakeState(DoubleSolenoid.Value.kForward));

    }
