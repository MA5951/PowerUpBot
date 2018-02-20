package org.usfirst.frc.team5951.robot.commands.auton;

import org.usfirst.frc.team5951.robot.commands.caliber.RetractCube;
import org.usfirst.frc.team5951.robot.commands.caliber.SquishCube;
import org.usfirst.frc.team5951.robot.commands.caliber.SwitchPosition;
import org.usfirst.frc.team5951.robot.commands.caliber.groups.CaliberShootOnly;
import org.usfirst.frc.team5951.robot.commands.caliber.groups.LowerToGroundNoCubeGroup;
import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraight;
import org.usfirst.frc.team5951.robot.commands.chassis.TurnToAngle;
import org.usfirst.frc.team5951.robot.commands.chassis.TurnToAngleOneSide;
import org.usfirst.frc.team5951.robot.commands.intake.IntakeCube;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class MiddleToRightTwoCubeAuto extends CommandGroup {

    public MiddleToRightTwoCubeAuto() {
    	addSequential(new SquishCube());
    	addSequential(new SwitchPosition());
        addSequential(new TurnToAngleOneSide(35));
        addSequential(new DriveStraight(1.7));
        addSequential(new TurnToAngleOneSide(-21),0.5);
        addSequential(new CaliberShootOnly());
        addSequential(new WaitCommand(0.4));
        addParallel(new DriveStraight(-1.2));
        addSequential(new LowerToGroundNoCubeGroup(),2);
        addSequential(new TurnToAngle(-45.0));
        addParallel(new DriveStraight(1));
        addSequential(new IntakeCube(),4);
        addParallel(new RetractCube());
        addSequential(new IntakeCube(),7);
        addSequential(new SquishCube());
        addSequential(new SwitchPosition(),2);
        addSequential(new DriveStraight(-0.5));
        addSequential(new TurnToAngle(45.0));
        addParallel(new DriveStraight(0.8),3);
        
        
        
    }
}
