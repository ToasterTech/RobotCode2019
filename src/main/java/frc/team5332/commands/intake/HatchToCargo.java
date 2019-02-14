package frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;

public class HatchToCargo extends Command {
    public HatchToCargo(){

    }
    @Override
    protected void execute() {
        CMap.switchIntakeMode.setBoolean(true);
        String currentstate = CMap.switchIntakeMode.getString("Hatch");

        if (currentstate == "Hatch") {
            CMap.switchIntakeMode.setString("Cargo");
        } else {
            CMap.switchIntakeMode.setString("Hatch");
        }
    }

    @Override
    protected boolean isFinished(){ return true; }

    @Override
    protected void end() {

    }




}
