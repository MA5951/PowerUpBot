package org.usfirst.frc.team5951.robot.commands.auton;

import org.usfirst.frc.team5951.robot.commands.caliber.PushCube;
import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraight;
import org.usfirst.frc.team5951.robot.commands.chassis.TurnToAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TestAuton extends CommandGroup {

    public TestAuton() {
        addSequential(new DriveStraight(2.60));
//        addSequential(new WaitCommand(0.2));
        addSequential(new TurnToAngle(-90));
//        addSequential(new WaitCommand(0.2));
        addSequential(new DriveStraight(1.1));
//        addSequential(new WaitCommand(0.2));
//        addSequential(new TurnToAngle(90));
//        addSequential(new WaitCommand(0.2));
//        addSequential(new DriveStraight(1));
//        addSequential(new WaitCommand(0.2));
//        addSequential(new TurnToAngle(90));
//        addSequential(new WaitCommand(0.2));
//        addSequential(new DriveStraight(1));
//        addSequential(new WaitCommand(0.2));
//        addSequential(new TurnToAngle(90));
//        addSequential(new WaitCommand(0.2));
//        addSequential(new DriveStraight(1));
//        addSequential(new ArcadeDrive());
//    	addSequential(new TurnToAngle(-90));
        addSequential(new PushCube());
    }
}
