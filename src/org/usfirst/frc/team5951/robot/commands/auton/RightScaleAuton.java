package org.usfirst.frc.team5951.robot.commands.auton;

import org.usfirst.frc.team5951.robot.commands.caliber.groups.ReleaseAndShoot;
import org.usfirst.frc.team5951.robot.commands.caliber.groups.ScalePositionGroup;
import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraight;
import org.usfirst.frc.team5951.robot.commands.chassis.TurnToAngle;
import org.usfirst.frc.team5951.robot.commands.shooter.RollUp;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightScaleAuton extends CommandGroup {

    public RightScaleAuton() {
    	addParallel(new ScalePositionGroup());
        addSequential(new DriveStraight(3.0));
        addParallel(new TurnToAngle(-20));
        addSequential(new RollUp());
        addParallel(new RollUp(), 4.0);
        addSequential(new  ReleaseAndShoot());        
    }
}
