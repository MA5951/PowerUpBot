package org.usfirst.frc.team5951.robot.commands.caliber.groups;

import org.usfirst.frc.team5951.robot.commands.brakes.LockBrakes;
import org.usfirst.frc.team5951.robot.commands.brakes.ReleaseBrakes;
import org.usfirst.frc.team5951.robot.commands.caliber.basic.BackwardPosition;
import org.usfirst.frc.team5951.robot.commands.caliber.basic.StopCaliberMotor;
import org.usfirst.frc.team5951.robot.commands.intake.CloseIntakeDelay;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class BackwardPositionGroup extends CommandGroup {

    public BackwardPositionGroup() {
        addSequential(new ReleaseBrakes());
        addSequential(new BackwardPosition());
        addSequential(new LockBrakes());
        addSequential(new WaitCommand(0.2));
        addSequential(new StopCaliberMotor());
        addSequential(new CloseIntakeDelay());
    }
}
