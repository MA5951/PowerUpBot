package org.usfirst.frc.team5951.robot.commands.caliber.groups;

import org.usfirst.frc.team5951.robot.commands.brakes.LockBrakes;
import org.usfirst.frc.team5951.robot.commands.caliber.basic.SwitchPosition;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SwitchPositionGroup extends CommandGroup {

    public SwitchPositionGroup() {
//    	addSequential(new ReleaseBrakes());
//        addSequential(new SwitchPosition());
        addSequential(new LockBrakes());
//        addSequential(new WaitCommand(0.2));
//        addSequential(new StopCaliberMotor());
    }
}
