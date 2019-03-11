package frc.team5332.commands.vision;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;

public class ListenForJetsonConnection extends Command {


    public ListenForJetsonConnection(){

    }

    @Override
    protected void execute() {
        System.out.println("Listening");
    }

    @Override
    protected boolean isFinished() {
        return CMap.jetsonOnline.getBoolean(false) && CMap.cameraRunning.getBoolean(false);
    }

    @Override
    protected void end(){
        DriverStation.reportWarning("Jetson Online", false);
    }
}
