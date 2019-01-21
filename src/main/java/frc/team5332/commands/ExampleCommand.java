package frc.team5332.commands;

import edu.wpi.first.wpilibj.command.Command;

public class ExampleCommand extends Command {
    //Place Class Variables here
    double exampleVariable;


    public ExampleCommand(double number){
        //This is your constructor. Make sure the name of it matches the Classname AND any parameters you need are included.
        exampleVariable = number;
    }

    @Override
    protected void execute() {
        //Do Stuff, so the method we would call and any extra stuff
    }

    @Override
    protected boolean isFinished() {
        return false; //Replace false with whatever variable or condition
    }

    @Override
    protected void end() {
        //Add any special commands here
    }
}
