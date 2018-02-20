package org.usfirst.frc.team5951.robot.commands.auton;

import org.usfirst.frc.team5951.robot.commands.caliber.SquishCube;
import org.usfirst.frc.team5951.robot.commands.caliber.SwitchPosition;
import org.usfirst.frc.team5951.robot.commands.caliber.groups.CaliberShootOnly;
import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraight;
import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraightTimed;
import org.usfirst.frc.team5951.robot.commands.chassis.TurnToAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightSwitchRightAngle extends CommandGroup {

    public RightSwitchRightAngle() {
    	addSequential(new SquishCube());
    	addSequential(new SwitchPosition());
        addSequential(new DriveStraight(3.28));
        addSequential(new TurnToAngle(-90));
        addSequential(new DriveStraightTimed(0.5));
        addSequential(new CaliberShootOnly());
    }
}
