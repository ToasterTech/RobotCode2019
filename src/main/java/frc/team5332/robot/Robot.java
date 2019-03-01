package frc.team5332.robot;

import edu.wpi.cscore.HttpCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team5332.commands.drivetrain.JoystickDrive;
import frc.team5332.commands.elevator.JoystickElevator;
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
    HttpCamera jetsonCamera = new HttpCamera("outputStreamServer", "http://tegra-ubuntu.local:5800/stream.mjpg?compression=10");
    cameraServer.startAutomaticCapture(jetsonCamera);
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
   Scheduler.getInstance().add(new JoystickElevator());

    comp_.clearAllPCMStickyFaults();

  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    //System.out.println(CMap.intake.getLimitSwitch());
  }


  @Override
  public void disabledInit() {
    Scheduler.getInstance().removeAll();
    if(DriverStation.getInstance().isFMSAttached() && CMap.teleopExecuted){
      Scheduler.getInstance().add(new ShutdownJetson());
    } else {
      Scheduler.getInstance().add(new ListenForJetsonConnection());
    }
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}


