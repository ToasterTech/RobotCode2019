package frc.team5332.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;
import frc.team5332.subsystems.Elevator;

public class SetElevator extends Command {
    double setpoint;


    public SetElevator(double setpoint) {

       this.setpoint = setpoint;


    }

    protected void execute() {
       CMap.elevator.setSetpoint(setpoint);

    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {

    }

}
