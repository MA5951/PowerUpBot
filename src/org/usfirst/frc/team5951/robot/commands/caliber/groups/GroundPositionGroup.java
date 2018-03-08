package org.usfirst.frc.team5951.robot.commands.caliber.groups;

import org.usfirst.frc.team5951.robot.commands.brakes.ReleaseBrakes;
import org.usfirst.frc.team5951.robot.commands.caliber.basic.GroundPosition;
import org.usfirst.frc.team5951.robot.commands.intake.OpenIntakeDelay;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class GroundPositionGroup extends CommandGroup {

    public GroundPositionGroup() {
    	addSequential(new OpenIntakeDelay());
        addSequential(new ReleaseBrakes());
        addSequential(new WaitCommand(0.2));
        addSequential(new GroundPosition());
    }
}
