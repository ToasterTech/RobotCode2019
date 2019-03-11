package frc.team5332.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;
import frc.team5332.subsystems.Elevator;

public class SetElevator extends Command {
    double setpoint;

    boolean enabled = false;

    public SetElevator(double setpoint) {

       this.setpoint = setpoint;


    }

    protected void execute() {
        if(!enabled) {
            CMap.elevator.enable();
            enabled = true;
        }
        CMap.elevator.setSetpoint(setpoint);

    }

    protected boolean isFinished() {
        return CMap.elevator.onTarget();
    }

    protected void end() {

        enabled = false;
    }

}
