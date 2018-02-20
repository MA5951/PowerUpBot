package org.usfirst.frc.team5951.robot.commands.auton;

import org.usfirst.frc.team5951.robot.commands.caliber.ReleaseCube;
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
		addSequential(new TurnToAngleOneSide(32));
		
		addSequential(new DriveStraight(1.8));
		addSequential(new TurnToAngleOneSide(-21), 0.5);
		addSequential(new CaliberShootOnly());
		// Take anoter cube
		addSequential(new WaitCommand(0.4));
		addParallel(new DriveStraight(-1.5));
		addSequential(new LowerToGroundNoCubeGroup(), 2);
		addSequential(new TurnToAngle(-45.0));
		// Intake the cube
		addParallel(new DriveStraight(1.1));
		addSequential(new IntakeCube(), 2.0); 
		addSequential(new WaitCommand(0.4));
		addSequential(new ReleaseCube(), 1.0); 
		addSequential(new WaitCommand(0.4));
		addParallel(new IntakeCube(), 2.0); 
		addSequential(new RetractCube());
		addSequential(new WaitCommand(0.4));
		addSequential(new IntakeCube(), 2.0);
		addSequential(new WaitCommand(0.4));
		addSequential(new OpenIntakeGroup());
		addSequential(new SwitchPosition(), 10);
		addSequential(new CloseIntakeGroup());
		// Shoot another cube
		addSequential(new SquishCube());
		addSequential(new DriveStraight(-0.8));
		addSequential(new TurnToAngle(45.0));
		addSequential(new DriveStraight(1.1),4);
		addSequential(new WaitCommand(0.2));
		addSequential(new CaliberShootOnly());

	}
}
