package frc.team5332.subsystems;


import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team5332.robot.CMap;

public class Climber extends Subsystem {
    Solenoid frontPistons;
    Solenoid backPistons;



    public Climber(){
        frontPistons = new Solenoid(CMap.frontPistonsSolenoid);
        backPistons = new Solenoid(CMap.backPistonsSolenoid);


    }

    @Override
    protected void initDefaultCommand() {

    }


}

