package org.usfirst.frc.team5951.robot.commands.caliber.groups;

import org.usfirst.frc.team5951.robot.commands.caliber.LowerToGround;
import org.usfirst.frc.team5951.robot.commands.intake.OpenIntakeGroup;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class LowerToGroundGroup extends CommandGroup {

    public LowerToGroundGroup() {
    	addSequential(new OpenIntakeGroup());
    	addSequential(new WaitCommand(0.5));
    	addSequential(new LowerToGround());
    }
}
