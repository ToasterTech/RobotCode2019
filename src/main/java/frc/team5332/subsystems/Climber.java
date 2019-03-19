package frc.team5332.subsystems;


import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team5332.robot.CMap;

public class Climber extends Subsystem {
    public static final Object State = ;
    Solenoid frontPistons;
    Solenoid backPistons;
    boolean ChangeFrontPistonState;


    public Climber(){
        frontPistons = new Solenoid(CMap.frontPistonsSolenoid);
        backPistons = new Solenoid(CMap.backPistonsSolenoid);


    }

    @Override
    protected void initDefaultCommand() {

    }


    public void ChangeFrontPistonState(boolean preferredState) {
    }

    public boolean getState() {
    }

    public void ChangeBackPistonState(boolean preferredState) {
    }
}

