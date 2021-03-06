package frc.team5332.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team5332.commands.climber.ChangeBackPistonState;
import frc.team5332.commands.climber.ChangeFrontPistonState;
import frc.team5332.commands.drivetrain.DriveStraight;
import frc.team5332.commands.intake.*;
import frc.team5332.commands.vision.DayToNight;
import frc.team5332.commands.vision.VisionAlign;
import frc.team5332.subsystems.*;

public class CMap {


    // NetworkTables stuff
    public static NetworkTableInstance mainInstance;
    public static NetworkTable visionTable;

    public static NetworkTableEntry angle;
    public static NetworkTableEntry targetAcquired;
    public static NetworkTableEntry shutdownJetson;
    public static NetworkTableEntry jetsonOnline;
    public static NetworkTableEntry cameraRunning;
    public static NetworkTableEntry visionMode;
    public static NetworkTableEntry switchVisionMode;
    public static NetworkTableEntry switchIntakeMode;
    public static NetworkTableEntry robotConnected;

    // Global Variables
    public static boolean teleopExecuted;
    public static boolean visionAlignmentInProgress = false;

    // Joysticks
    public static Joystick gamepad = new Joystick(0);
    public static Joystick operatorStick = new Joystick(1);

    // Motors
    public static int leftDriveMotor1 = 0;
    public static int leftDriveMotor2 = 1;
    public static int leftDriveMotor3 = 2;
    public static int rightDriveMotor1 = 3;
    public static int rightDriveMotor2 = 4;
    public static int rightDriveMotor3 = 5;
    public static int elevatorWenchMotor1 = 6;
    public static int elevatorWenchMotor2 = 7;
    public static int intakeMotor1 = 8;


    //DIO
    public static int rightDriveEncoderA = 0;
    public static int rightDriveEncoderB = 1;
    public static int leftDriveEncoderA = 2;
    public static int leftDriveEncoderB = 3;

    public static int elevatorEncoderA = 5;
    public static int elevatorEncoderB = 6;
    public static int intakeLimitSwitch = 4;
    public static int elevatorTopLimitSwitch = 8;
    public static int elevatorBottomLimitSwitch = 9;
    // Pneumatics
    public static int hatchGrabberSolenoid = 1;
    public static int hoodSolenoid = 0;
    public static int rollerSolenoid = 2;
    public static int frontPistonsSolenoid = 3;
    public static int backPistonsSolenoid = 4;


    // Subsystems
    public static Intake intake = new Intake();
    public static Drivetrain drivetrain = new Drivetrain();
    public static Elevator elevator = new Elevator();
    public static Jetson jetson = new Jetson();
    public static Climber climber = new Climber();
    public static ChangeFrontPistonState changeFrontPistonState = new ChangeFrontPistonState();
    public static ChangeBackPistonState changeBackPistonState = new ChangeBackPistonState();


    // Buttons
    public static JoystickButton greenbutton = new JoystickButton(gamepad, 1);
    public static JoystickButton leftbumper = new JoystickButton(gamepad, 5);
    public static JoystickButton rightbumper = new JoystickButton(gamepad, 6);
    public static JoystickButton bluebutton = new JoystickButton(gamepad, 2);
    public static JoystickButton yellowbutton = new JoystickButton(gamepad, 3);


    public static JoystickButton operator1 = new JoystickButton(operatorStick,1);
    public static JoystickButton operator2 = new JoystickButton(operatorStick, 2);

    public static JoystickButton operator3 = new JoystickButton(operatorStick, 3);
    public static JoystickButton operator4 = new JoystickButton(operatorStick, 4);
    public static JoystickButton operator5 = new JoystickButton(operatorStick, 5);
    public static JoystickButton operator6 = new JoystickButton(operatorStick, 6);
    public static JoystickButton operator7 = new JoystickButton(operatorStick, 7);
    public static JoystickButton operator8 = new JoystickButton(operatorStick, 8);
    public static JoystickButton operator9 = new JoystickButton(operatorStick, 9);
    public static JoystickButton operator10 = new JoystickButton(operatorStick, 10);


    public static void setupJoystickButtons() {
        //leftbumper.whenPressed(new VisionAlign());
        //rightbumper.whenPressed(new IntakeCargo());

        operator3.whileHeld(new ExpelCargoBottom());
        operator4.whenPressed(new HatchMode());
        operator5.whenPressed(new CargoMode());
        operator8.whenPressed(new ResetIntake());
        operator1.whileHeld(new ExpelCargo());
        greenbutton.whileHeld(new DriveStraight());
        bluebutton.whileHeld(new ChangeFrontPistonState());
        greenbutton.whileHeld(new ChangeBackPistonState());
    }
        public static void setupNetworkTables(){
            mainInstance = NetworkTableInstance.getDefault();

            visionTable = mainInstance.getTable("vision_table");

            visionMode = visionTable.getEntry("visionMode");
            jetsonOnline = visionTable.getEntry("JetsonOnline");
            cameraRunning = visionTable.getEntry("CameraRunning");
            robotConnected = visionTable.getEntry("RobotConnected");

            jetsonOnline.setBoolean(false);
            robotConnected.setBoolean(true);

            angle = visionTable.getEntry("Angle");
            shutdownJetson = visionTable.getEntry("Shutdown");


        }

}