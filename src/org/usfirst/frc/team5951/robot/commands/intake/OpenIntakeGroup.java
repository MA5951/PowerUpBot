package org.usfirst.frc.team5951.robot.commands.intake;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class OpenIntakeGroup extends CommandGroup {

    public OpenIntakeGroup() {
    	addSequential(new OpenRightIntake());
    	addSequential(new WaitCommand(0.3));
    	addSequential(new OpenLeftIntake());
    }
}
