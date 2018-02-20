package org.usfirst.frc.team5951.robot.commands.caliber.groups;

import org.usfirst.frc.team5951.robot.commands.caliber.CaliberOverSwitch;
import org.usfirst.frc.team5951.robot.commands.caliber.LowerToGround;
import org.usfirst.frc.team5951.robot.commands.caliber.PushCube;
import org.usfirst.frc.team5951.robot.commands.intake.OpenIntakeGroup;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class LowerToGroundNoCubeGroup extends CommandGroup {

    public LowerToGroundNoCubeGroup() {
    	addSequential(new CaliberOverSwitch());
    	addSequential(new WaitCommand(0.3));
    	addSequential(new OpenIntakeGroup());
    	addSequential(new WaitCommand(0.5));
    	addParallel(new PushCube());
    	addSequential(new LowerToGround());
    }

}
