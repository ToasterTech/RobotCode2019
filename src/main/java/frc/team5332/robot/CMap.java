package frc.team5332.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team5332.commands.HatchGrabber.ChangeGrabberState;
import frc.team5332.subsystems.HatchGrabber;

public class CMap {
    // Joysticks
    public static Joystick gamepad = new Joystick(0);

    // Motors

    // Encoders

    // Pneumatics

    // Subsystems
 public static HatchGrabber hatchGrabber = new HatchGrabber();
    public static void setupJoystickButtons(){
        JoystickButton greenbutton = new JoystickButton(gamepad,0);
                greenbutton.whenPressed(new ChangeGrabberState());
    }
}
