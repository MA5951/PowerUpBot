package org.usfirst.frc.team5951.robot.commands.intake;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class OpenIntakeGroup extends CommandGroup {

    public OpenIntakeGroup() {
    	addSequential(new OpenIntake());
    }
}
