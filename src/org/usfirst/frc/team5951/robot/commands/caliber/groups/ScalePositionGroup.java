package org.usfirst.frc.team5951.robot.commands.caliber.groups;

import org.usfirst.frc.team5951.robot.commands.brakes.LockBrakes;
import org.usfirst.frc.team5951.robot.commands.brakes.ReleaseBrakes;
import org.usfirst.frc.team5951.robot.commands.caliber.basic.ScalePosition;
import org.usfirst.frc.team5951.robot.commands.caliber.basic.StopCaliberMotor;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ScalePositionGroup extends CommandGroup {

    public ScalePositionGroup() {
        addSequential(new ReleaseBrakes());
        addSequential(new ScalePosition());
        addSequential(new LockBrakes());
        addSequential(new StopCaliberMotor());
    }
}
