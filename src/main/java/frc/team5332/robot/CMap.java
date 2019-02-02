package frc.team5332.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team5332.commands.intake.ChangeGrabberState;
import frc.team5332.subsystems.Drivetrain;
import frc.team5332.subsystems.Intake;

public class CMap {


    // NetworkTables stuff
    public static NetworkTableInstance mainInstance;
    public static NetworkTable visionTable;

    public static NetworkTableEntry angle;
    public static NetworkTableEntry targetAcquired;
    public static NetworkTableEntry shutdownJetson;
    public static NetworkTableEntry jetsonConnected;

    // Global Variables
    public static boolean teleopExecuted;
    public static boolean visionAlignmentInProgress = false;

    // Joysticks
    public static Joystick gamepad = new Joystick(0);
    public static Joystick operatorStick = new Joystick(1);

    // Motors
    public static int leftDriveMotor1 = 1;
    public static int leftDriveMotor2 = 3;
    public static int rightDriveMotor1 = 0;
    public static int rightDriveMotor2 = 2;

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
    }

    public static void setupNetworkTables(){
        mainInstance = NetworkTableInstance.getDefault();
        visionTable = mainInstance.getTable("visionTable");

        angle = visionTable.getEntry("angle");
        shutdownJetson = visionTable.getEntry("shutdownJetson");
    }
}
