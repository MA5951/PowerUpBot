package org.usfirst.frc.team5951.robot.commands.auton;

import org.usfirst.frc.team5951.robot.commands.caliber.RetractCube;
import org.usfirst.frc.team5951.robot.commands.caliber.SquishCube;
import org.usfirst.frc.team5951.robot.commands.caliber.SwitchPosition;
import org.usfirst.frc.team5951.robot.commands.caliber.groups.CaliberShootOnly;
import org.usfirst.frc.team5951.robot.commands.caliber.groups.LowerToGroundNoCubeGroup;
import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraight;
import org.usfirst.frc.team5951.robot.commands.chassis.ResetGyro;
import org.usfirst.frc.team5951.robot.commands.chassis.TurnToAngle;
import org.usfirst.frc.team5951.robot.commands.chassis.TurnToAngleOneSide;
import org.usfirst.frc.team5951.robot.commands.intake.CloseIntakeGroup;
import org.usfirst.frc.team5951.robot.commands.intake.IntakeCube;
import org.usfirst.frc.team5951.robot.commands.intake.OpenIntakeGroup;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class MiddleToRightTwoCubeAuto extends CommandGroup {

	public MiddleToRightTwoCubeAuto() {
		// Shoot cube
		addSequential(new SquishCube());
		addSequential(new SwitchPosition());
		addSequential(new TurnToAngleOneSide(35));
		
		addSequential(new DriveStraight(1.7));
		addSequential(new TurnToAngleOneSide(-21), 0.5);
		addSequential(new CaliberShootOnly());
		// Take anoter cube
		addSequential(new WaitCommand(0.4));
		addParallel(new DriveStraight(-1.5));
		addSequential(new LowerToGroundNoCubeGroup(), 2);
		addSequential(new TurnToAngle(-45.0));
		// Intake the cube
		addParallel(new DriveStraight(1.1));
		addSequential(new IntakeCube(), 2.0); // TODO test
		addSequential(new RetractCube());
		addSequential(new WaitCommand(0.4));
		addSequential(new IntakeCube(), 2.0);
		addSequential(new WaitCommand(0.4));
		// Shoot another cube
		addSequential(new OpenIntakeGroup());
		addSequential(new SwitchPosition(), 10);
		addSequential(new CloseIntakeGroup());
		addSequential(new SquishCube());
		addSequential(new DriveStraight(-0.8));
		addSequential(new TurnToAngle(45.0));
		addParallel(new DriveStraight(0.8), 3);
		addSequential(new WaitCommand(1.2));
		addSequential(new CaliberShootOnly());

	}
}
