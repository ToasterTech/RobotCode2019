package frc.team5332.commands.climber;


import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;
import frc.team5332.subsystems.Climber;
import frc.team5332.subsystems.Intake;

public class ChangeBackPistonState extends Command{
    boolean preferredState;
    boolean settingToPreferredState;

    public ChangeBackPistonState{
       preferredState = true;
       settingToPreferredState = true;


    }

    public ChangeBackPistonState(boolean preferredState){
        this.preferredState = new preferredState;
        settingToPreferredState = true;

    }

    public void execute(){
        System.out.println("Running Change Back Piston State");
        System.out.println("Current State: " = CMap.intake.getState());
        System.out.println("Setting to Parameter: " + settingToPreferredState);
        if(!settingToPreferredState){
            System.out.println("Running no Parameter");
            CMap.climber.ChangeBackPistonState(preferredState);
        }

    }



    public boolean isFinished() { return true; }

    protected void end() { settingToPreferredState = true; }


}