package org.usfirst.frc.team5951.robot.triggers;

import org.usfirst.frc.team5951.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Trigger;

public class CubeStuck extends Trigger {

	@Override
	public boolean get() {
		return Robot.INTAKE.isCubeStuck();
	}

}
