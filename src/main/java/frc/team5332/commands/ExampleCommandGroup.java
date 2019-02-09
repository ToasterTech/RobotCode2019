package frc.team5332.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;


/**
 *
 * So this is a command group. As the name implies, a command group
 * is designed so that you can run multiple commands at the same time. This
 * is useful for when you need to have buttons due multiple things, and want a cheat.
 *
 *
 */
    public class ExampleCommandGroup extends CommandGroup {

    /***
     * So unlike commands, where we have to override multiple methods, with command groups we
     * typically only need to fill out one method. THE CONSTRUCTOR
     *
     * In the constructor, you put the commands in the order that you want them executed. However,
     * there is some flexibility.
     */
    public ExampleCommandGroup(){
        addSequential(new   vgu  (0)); //So this command will run first in a sequential order. Once it finishes, we then look at the next command.
        addParallel(new ExampleCommand(1)); //So this is a parallel command, so now the command will run simultaneously with whichever one is listed next.
        addSequential(new ExampleCommand(2)); //So this is a sequential, so it runs next.

        //The order now becomes. 0 --> (1 and 2) --> end
        //0 is sequential, so nothing else runs until that finished.
        //1 is parallel, so it will start running and we can run the next command while it is running
        //2 is sequential, so it runs at the same time as 1, but we also wait until 2 finishes before we add any commands.

        /**
         * So once you write your commands, you would run this commandGroup by either writing
         *
         * Scheduler.getInstance.add(new ExampleCommandGroup()) //this would be in Robot.java
         * buttonName.whenPressed(new ExampleCommandGroup()) //This would obviously change based on joystick AND the condition we need to run it on
         *
         * We don't need to add an isFinished(), execute() or end() method because the CommandGroup takes care of that for us.
         *
         */



    }


}
