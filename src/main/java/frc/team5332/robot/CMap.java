package frc.team5332.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team5332.commands.intake.ChangeGrabberState;
import frc.team5332.subsystems.Drivetrain;
import frc.team5332.subsystems.Intake;

public class CMap {
    // Joysticks
    public static Joystick gamepad = new Joystick(0);
    public static Joystick operatorStick = new Joystick(1);

    // Motors
    public static int leftDriveMotor1 = 0;
    public static int leftDriveMotor2 = 2;
    public static int rightDriveMotor1 = 1;
    public static int rightDriveMotor2 = 3;

    // Encoders
    public static int leftDriveEncoderA = 0;
    public static int leftDriveEncoderB = 1;
    public static int rightDriveEncoderA = 2;
    public static int rightDriveEncoderB = 3;

    // Pneumatics

    // Subsystems
    public static Intake intake = new Intake();
    public static Drivetrain drivetrain = new Drivetrain();

    // Buttons
    public static JoystickButton greenbutton = new JoystickButton(gamepad, 1);

    public static void setupJoystickButtons() {
        greenbutton.whenPressed(new ChangeGrabberState());
        System.out.println("setupjoystick");
    }
}
