package org.usfirst.frc.team5951.robot.commands.caliber.groups;

import org.usfirst.frc.team5951.robot.commands.caliber.CaliberOverSwitch;
import org.usfirst.frc.team5951.robot.commands.caliber.LowerToGround;
import org.usfirst.frc.team5951.robot.commands.intake.OpenIntakeGroup;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class LowerToGroundCubeGroup extends CommandGroup {

    public LowerToGroundCubeGroup() {
    	addSequential(new CaliberOverSwitch());
    	addSequential(new WaitCommand(0.3));
    	addSequential(new OpenIntakeGroup());
    	addSequential(new WaitCommand(0.8));
    	addSequential(new LowerToGround());
    }
}
