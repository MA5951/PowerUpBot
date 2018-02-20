package org.usfirst.frc.team5951.robot.commands.auton;

import org.usfirst.frc.team5951.robot.commands.caliber.SquishCube;
import org.usfirst.frc.team5951.robot.commands.caliber.SwitchPosition;
import org.usfirst.frc.team5951.robot.commands.caliber.groups.CaliberShootOnly;
import org.usfirst.frc.team5951.robot.commands.caliber.groups.LowerCaliberGroup;
import org.usfirst.frc.team5951.robot.commands.caliber.groups.LowerToGroundNoCubeGroup;
import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraight;
import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraightTimed;
import org.usfirst.frc.team5951.robot.commands.chassis.TurnToAngle;
import org.usfirst.frc.team5951.robot.commands.chassis.TurnToAngleOneSide;
import org.usfirst.frc.team5951.robot.commands.intake.IntakeCube;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class MiddleToLeftTwoCubeAuto extends CommandGroup {

    public MiddleToLeftTwoCubeAuto() {
    	addSequential(new SquishCube());
    	addSequential(new SwitchPosition());
        addSequential(new TurnToAngleOneSide(-23));
        addSequential(new DriveStraight(2.1));
        addSequential(new TurnToAngleOneSide(21),0.5);
        addSequential(new CaliberShootOnly());
        addSequential(new WaitCommand(0.5));
        addSequential(new DriveStraight(-1));
        addSequential(new LowerToGroundNoCubeGroup());
        addSequential(new TurnToAngle(30.0));
        addParallel(new DriveStraight(1));
        addSequential(new IntakeCube(),5);
        //addSequential(new DriveStraight(-1));

    }
}
