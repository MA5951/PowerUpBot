package org.usfirst.frc.team5951.robot.commands.auton;

import org.usfirst.frc.team5951.robot.commands.caliber.RetractCube;
import org.usfirst.frc.team5951.robot.commands.caliber.SquishCube;
import org.usfirst.frc.team5951.robot.commands.caliber.SwitchPosition;
import org.usfirst.frc.team5951.robot.commands.caliber.groups.CaliberShootOnly;
import org.usfirst.frc.team5951.robot.commands.caliber.groups.LowerCaliberGroup;
import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraight;
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
public class MiddleToLeftTwoCubeAuto extends CommandGroup {

    public MiddleToLeftTwoCubeAuto() {
    	// Shoot cube
    			addSequential(new SquishCube());
    	    	addSequential(new SwitchPosition());
    	        addSequential(new TurnToAngleOneSide(-22.4));
    	        addSequential(new DriveStraight(2.2),3);
    	        addSequential(new TurnToAngleOneSide(21), 0.5);
    	        addSequential(new CaliberShootOnly());
    	        addSequential(new WaitCommand(2));
    	        addSequential(new DriveStraight(-1.5));
    	        addSequential(new LowerCaliberGroup(),2.0);
    			addSequential(new TurnToAngle(45.0));
    			// Intake the cube
    			addParallel(new DriveStraight(0.9));
    			addSequential(new IntakeCube(), 2.0);
    			addParallel(new TurnToAngle(25));
    			addSequential(new IntakeCube(), 1.0);
    			addParallel(new DriveStraight(-0.3));
    			addSequential(new IntakeCube(), 1.0);
    			addParallel(new IntakeCube(), 0.5);
    			addSequential(new RetractCube());
    			//addSequential(new WaitCommand(0.2));
    			addSequential(new OpenIntakeGroup());		
    			addSequential(new SwitchPosition(), 2.0);
    			addSequential(new CloseIntakeGroup());
    			// Shoot another cube
    			addSequential(new SquishCube());
    			//addSequential(new WaitCommand(0.2));
    			addSequential(new DriveStraight(-0.4),3);
    			addSequential(new TurnToAngle(-70.0));
    			addSequential(new CloseIntakeGroup());
    			addSequential(new DriveStraight(1.4),2);
    			//addSequential(new WaitCommand(0.2));
    			addSequential(new CaliberShootOnly());

    }
}
