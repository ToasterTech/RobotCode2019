package frc.team5332.subsystems;


import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team5332.robot.CMap;

public class Climber extends Subsystem {
    Solenoid frontPistons;
    Solenoid backPistons;
    Solenoid airRegulator;

    public Climber(){
        frontPistons = new Solenoid(CMap.frontPistonsSolenoid);
        backPistons = new Solenoid(CMap.backPistonsSolenoid);
        airRegulator = new Solenoid(CMap.airRegulatorSolenoid);

    }

    @Override
    protected void initDefaultCommand() {

    }

    public void changeFrontPistonState(){
        boolean currentState = frontPistons.get();
        System.out.println("Old Front Piston State: " + currentState);
        frontPistons.set(!currentState);
        System.out.println("New Front Piston State: " + frontPistons.get());
    }

    public void changeBackPistonState(){
        boolean currentState = backPistons.get();
        System.out.println("Old Back Piston State: " + currentState);
        backPistons.set(!currentState);
        System.out.println("New Back Piston State: " + backPistons.get());
    }

    public void changeAirRegulatorState(){
        boolean currentState = airRegulator.get();
        System.out.println("Old Air Regulator State: " + currentState);
        airRegulator.set(!currentState);
        System.out.println("New Air Regulator State: " + airRegulator.get());
    }
}

