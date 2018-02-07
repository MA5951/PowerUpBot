package org.usfirst.frc.team5951.robot.triggers;

import org.usfirst.frc.team5951.robot.subsystems.Caliber;

import edu.wpi.first.wpilibj.buttons.Trigger;

public class CaliberUp extends Trigger {

	@Override
	public boolean get() {
		
		return Caliber.currentPosition > 0;
	}

}
