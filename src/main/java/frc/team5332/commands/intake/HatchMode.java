package frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class HatchMode extends CommandGroup {

        public HatchMode(){
            addSequential(new ChangeHoodState(DoubleSolenoid.Value.kReverse));
            addSequential(new ChangeRollerIntakeState(DoubleSolenoid.Value.kForward));


        }
