package org.usfirst.frc.team5951.robot.util;

import org.usfirst.frc.team5951.robot.util.UnitConverter.Unit;

/**
 * Constants of the field and robot
 * E.g. Distances, lengths
 * @author Yair Ziv
 */
public class Constants {
	
	public static final double ROBOT_LENGTH = UnitConverter.convert(971.1, Unit.MILIMETER, Unit.METER);
	
	//TODO: remove unneeded constants
	public static final double RETROREFLECTIVE_HEIGHT = UnitConverter.convert(15.3, Unit.INCH, Unit.METER);
	public static final double RETROREFLECTIVE_WIDTH = UnitConverter.convert(2, Unit.INCH, Unit.METER);

	/**
	 * Distances between parts of the field
	 * @author Yair Ziv
	 */
	public static class Distances{
		public static final double WALL_TO_SWITCH = UnitConverter.convert(138, Unit.INCH, Unit.METER); 
		public static final double WALL_TO_SCALE = UnitConverter.convert(321, Unit.INCH, Unit.METER);
		public static final double SWITCH_TO_SWITCH = UnitConverter.convert(125.5, Unit.INCH, Unit.METER);
		public static final double WALL_TO_AUTON_LINE = UnitConverter.convert(119, Unit.INCH, Unit.METER);
		public static final double AUTON_LINE_TO_SCALE = UnitConverter.convert(201.5, Unit.INCH, Unit.METER);
		public static final double AUTON_LINE_TO_SWITCH = UnitConverter.convert(18.5, Unit.INCH, Unit.METER);
		public static final double SWITCH_TO_PYRAMID = UnitConverter.convert(54.6, Unit.INCH, Unit.METER);
		public static final double SWITCH_TO_DATA_CABLE = UnitConverter.convert(80, Unit.INCH, Unit.METER);
	}
	
}
