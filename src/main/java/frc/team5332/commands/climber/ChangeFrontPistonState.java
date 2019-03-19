package frc.team5332.commands.climber;

import edu.wpi.first.wpilibj.command.Command;
import frc.team5332.robot.CMap;
import frc.team5332.subsystems.Climber;


public class ChangeFrontPistonState extends Command{
    boolean preferredState;
    boolean settingToPreferredState;





    public ChangeFrontPistonState(){
        preferredState = true;
        settingToPreferredState = true;
    }


    public ChangeFrontPistonState(boolean preferredState){
        settingToPreferredState = true;

    }


    protected void execute(){
        System.out.println("Running Change Front Piston State");
        System.out.println("Current State: " + CMap.climber.getState());
        System.out.println("Setting to Parameter: " + settingToPreferredState);
            if (!settingToPreferredState) {
                System.out.println("Running no Parameter");
                CMap.climber.ChangeFrontPistonState(preferredState);

            } else {
                System.out.println("Running Preferred");
                CMap.climber.ChangeFrontPistonState(preferredState);
            }
        }
    protected boolean isFinished() { return true; }


    protected void end() { settingToPreferredState = true; }



    }












