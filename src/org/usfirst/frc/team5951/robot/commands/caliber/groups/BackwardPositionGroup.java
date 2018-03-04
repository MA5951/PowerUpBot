package org.usfirst.frc.team5951.robot.commands.caliber.groups;

import org.usfirst.frc.team5951.robot.commands.brakes.LockBrakes;
import org.usfirst.frc.team5951.robot.commands.brakes.ReleaseBrakes;
import org.usfirst.frc.team5951.robot.commands.caliber.basic.BackwardPosition;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class BackwardPositionGroup extends CommandGroup {

    public BackwardPositionGroup() {
        addSequential(new ReleaseBrakes());
        addSequential(new BackwardPosition());
        addSequential(new LockBrakes());
    }
}
