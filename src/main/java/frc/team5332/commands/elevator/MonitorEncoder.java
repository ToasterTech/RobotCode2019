package frc.team5332.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team5332.robot.CMap;

public class MonitorEncoder extends Command {
    boolean lastReset = false;
    boolean endCommand = false;

    public MonitorEncoder(){

    }

    @Override
    protected void execute() {
        if(CMap.elevator.getElevatorBottomLimitSwitch()) {
            System.out.println("Resetting Encoder");
            CMap.elevator.resetencoder();

            lastReset = true;
        } else if(!CMap.elevator.getElevatorBottomLimitSwitch() && lastReset){
            endCommand = true;
        }

    }

    @Override
    protected boolean isFinished() {
        return endCommand;
    }

    @Override
    protected void end() {
        super.end();
    }
}
