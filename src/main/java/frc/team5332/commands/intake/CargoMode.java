package frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team5332.robot.CMap;
import frc.team5332.subsystems.Intake;

public class CargoMode extends CommandGroup {

    public CargoMode() {
        //addSequential(new ChangeGrabberState(false));

        addSequential(new ResetHatchGrabber());
        //addSequential(new ChangeGrabberState(false));
        addSequential(new ChangeHoodState(false));
        addSequential(new ChangeRollerIntakeState(true));
        //addSequential(new ChangeGrabberState(false));


    }

    protected void execute() {
        System.out.println("Cargo Mode");
        CMap.intake.setCurrentState(Intake.State.CARGO);


        //CMap.rightbumper.close();
        //CMap.rightbumper = new JoystickButton(CMap.gamepad, 6);
        //CMap.rightbumper.whileHeld(new IntakeCargo());

        return;


        /*
        CMap.elevatorController1 = new JoystickButton(CMap.elevatorController, 1);
        CMap.elevatorController2 = new JoystickButton(CMap.elevatorController, 2);
        CMap.elevatorController3 = new JoystickButton(CMap.elevatorController, 3);
        CMap.elevatorController4 = new JoystickButton(CMap.elevatorController, 4);



        CMap.elevatorController1.whenPressed(new SetElevator(CMap.elevator.ROCKET_LEVEL_3_CARGO, false));
        CMap.elevatorController2.whenPressed(new SetElevator(CMap.elevator.ROCKET_LEVEL_2_CARGO, false));
        CMap.elevatorController3.whenPressed(new SetElevator(CMap.elevator.ROCKET_LEVEL_1_CARGO, false));
        CMap.elevatorController4.whenPressed(new SetElevator(CMap.elevator.CARGO_SHIP_SCORING, false));
        */
    }
}
