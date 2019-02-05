package frc.team5332.commands.vision;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;

public class ShutdownJetson extends Command {

    public ShutdownJetson(){

    }

    @Override
    protected void execute() {
        CMap.shutdownJetson.setBoolean(true);
        DriverStation.reportWarning("Shutdown Command sent to Jetson", false);
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
