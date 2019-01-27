package frc.team5332.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team5332.commands.HatchGrabber.ChangeGrabberState;
import frc.team5332.subsystems.Drivetrain;
import frc.team5332.subsystems.HatchGrabber;

public class CMap {
    // Joysticks
    public static Joystick gamepad = new Joystick(0);
    public static Joystick operatorStick = new Joystick(1);
    // Motors

    // Encoders

    // Pneumatics

    // Subsystems
    public static HatchGrabber hatchGrabber = new HatchGrabber();
    public static JoystickButton greenbutton = new JoystickButton(gamepad, 1);
    public static Drivetrain drivetrain = new Drivetrain();

    public static void setupJoystickButtons() {
        greenbutton.whenPressed(new ChangeGrabberState());
        System.out.println("setupjoystick");
    }
}
