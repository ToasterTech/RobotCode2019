package frc.team5332.robot;

import edu.wpi.cscore.HttpCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team5332.commands.drivetrain.AngleDrivePivot;
import frc.team5332.commands.drivetrain.AngleDriveTank;
import frc.team5332.commands.drivetrain.DriveStraight;
import frc.team5332.commands.drivetrain.JoystickDrive;
import frc.team5332.commands.elevator.JoystickElevator;
import frc.team5332.commands.elevator.MonitorEncoder;
import frc.team5332.commands.elevator.SetElevator;
import frc.team5332.commands.vision.ListenForJetsonConnection;
import frc.team5332.commands.vision.ShutdownJetson;

import java.beans.Encoder;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  Compressor compressor;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    CMap.setupJoystickButtons();
    CMap.setupNetworkTables();

    CameraServer cameraServer = CameraServer.getInstance();
    cameraServer.startAutomaticCapture(0);

    //HttpCamera jetsonCamera = new HttpCamera("outputStreamServer", "http://tegra-ubuntu.local:5800/stream.mjpg?compression=10");
    //cameraServer.startAutomaticCapture(jetsonCamera);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {

  }


  @Override
  public void autonomousInit() {
    Scheduler.getInstance().add(new JoystickDrive());
    Scheduler.getInstance().add(new DriveStraight());
    Scheduler.getInstance().add(new JoystickElevator());
    Scheduler.getInstance().add(new MonitorEncoder());
    //Scheduler.getInstance().add(new MonitorEncoder());
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }


  private Compressor comp_ = new Compressor();
  @Override
  public void teleopInit(){
   Scheduler.getInstance().removeAll();
   Scheduler.getInstance().add(new JoystickDrive());
   //Scheduler.getInstance().add(new SetElevator(CMap.elevator.HATCH_ZERO, false));
   Scheduler.getInstance().add(new DriveStraight());
   //Scheduler.getInstance().add(new JoystickElevator());
   Scheduler.getInstance().add(new MonitorEncoder());


   //Scheduler.getInstance().add(new SetElevator(15.24977));

   //CMap.elevator.resetencoder();
   //Scheduler.getInstance().add(new SetElevator(8.5));
   // Scheduler.getInstance().add(new AngleDriveTank(90));
    comp_.clearAllPCMStickyFaults();

  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
      //System.out.println(CMap.drivetrain.getAngle());
      System.out.println("Bottom Limit Switch: " + CMap.elevator.getElevatorBottomLimitSwitch());
      CMap.elevator.printEncoderOutputs();
    Scheduler.getInstance().run();
    //System.out.println(CMap.intake.getLimitSwitch());
  }


  @Override
  public void disabledInit() {

  }

  @Override
  public void disabledPeriodic() {

    //System.out.println("Listener Running");
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}


