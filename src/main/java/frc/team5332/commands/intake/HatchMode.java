package frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
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
        System.out.println("Hatch Mode");
        CMap.intake.setCurrentState(Intake.State.HATCH);

        //CMap.rightbumper.close();
        //CMap.rightbumper = new JoystickButton(CMap.gamepad, 6);
        //CMap.rightbumper.whenReleased(new ChangeGrabberState());

        /*
        CMap.elevatorController1 = new JoystickButton(CMap.elevatorController, 1);
        CMap.elevatorController2 = new JoystickButton(CMap.elevatorController, 2);
        CMap.elevatorController3 = new JoystickButton(CMap.elevatorController, 3);
        CMap.elevatorController4 = new JoystickButton(CMap.elevatorController, 4);

        CMap.elevatorController1.whenPressed(new SetElevator(CMap.elevator.ROCKET_LEVEL_3_HATCH, false));
        CMap.elevatorController2.whenPressed(new SetElevator(CMap.elevator.ROCKET_LEVEL_2_HATCH, false));
        CMap.elevatorController3.whenPressed(new SetElevator(CMap.elevator.HATCH_ZERO, false));
        CMap.elevatorController4.whenPressed(new SetElevator(CMap.elevator.HATCH_ZERO, false));

         **/

        return;

    }

    /*
    @Override public boolean isFinished(){
        return CMap.intake.getState() != CMap.intake.State.HATCH;
    }*/
}
