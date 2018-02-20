package org.usfirst.frc.team5951.robot.commands.auton;

import org.usfirst.frc.team5951.robot.commands.caliber.SquishCube;
import org.usfirst.frc.team5951.robot.commands.caliber.SwitchPosition;
import org.usfirst.frc.team5951.robot.commands.caliber.groups.CaliberShootOnly;
import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraight;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class StraightForwardAuton extends CommandGroup {

    public StraightForwardAuton() {
        addSequential(new SquishCube());
        addSequential(new SwitchPosition());
        addSequential(new DriveStraight(2.5));
//        addSequential(new DriveStraightTimed(1));
        addSequential(new CaliberShootOnly());
        addSequential(new WaitCommand(1.5));
        addSequential(new DriveStraight(-1));
    }
}
