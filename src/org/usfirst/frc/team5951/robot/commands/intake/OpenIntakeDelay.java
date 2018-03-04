package org.usfirst.frc.team5951.robot.commands.intake;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class OpenIntakeDelay extends CommandGroup {

    public OpenIntakeDelay() {
    	addSequential(new OpenLeftIntake());
    	addSequential(new WaitCommand(0.5));
    	addSequential(new OpenRightIntake());
    }
}
