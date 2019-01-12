package frc.team5332.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class HatchGrabber {
  DoubleSolenoid solenoid;
  public HatchGrabber(){
      solenoid = new DoubleSolenoid(0,1);
  }
  public void changstate() {
        DoubleSolenoid.Value currentstate = solenoid.get();
        if (currentstate == DoubleSolenoid.Value.kForward) {
            solenoid.set(DoubleSolenoid.Value.kReverse);
        } else {
            solenoid.set(DoubleSolenoid.Value.kForward);
        }
    }
}
