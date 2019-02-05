package frc.team5332.commands.vision;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;

public class DayToNight extends Command{
    public DayToNight(){

    }
    @Override
    protected void execute() {
        CMap.switchVisionMode.setBoolean(true);
        String currentstate = CMap.switchVisionMode.getString("day");

        if(currentstate == "day"){
            CMap.switchVisionMode.setString("night");
        }else{
            CMap.switchVisionMode.setString("day");
        }
    }



    @Override
    protected boolean isFinished(){ return true; }

    @Override
    protected void end() {

    }
}
