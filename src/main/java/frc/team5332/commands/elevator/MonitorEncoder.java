package frc.team5332.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team5332.robot.CMap;

public class MonitorEncoder extends Command {
    boolean lastReset = false;
    boolean endCommand = false;

    boolean lastCyclePressed = false;

    public MonitorEncoder(){

    }

    @Override
    protected void execute() {
        if(CMap.elevator.getElevatorBottomLimitSwitch()){

            if(!lastCyclePressed){
                lastCyclePressed = true;
            } else {
                CMap.elevator.resetencoder();
                lastCyclePressed = false;
            }

        }

        System.out.println("Elevator Encoder: " + CMap.elevator.getPosition());


    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        super.end();
    }
}
