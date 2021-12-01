package org.simbotics.frc2017.auton.mode.step2Modes;

import org.simbotics.frc2017.auton.AutonOverride;
import org.simbotics.frc2017.auton.RobotComponent;
import org.simbotics.frc2017.auton.drive.DriveSetOutput;
import org.simbotics.frc2017.auton.drive.DriveStraightProfile;
import org.simbotics.frc2017.auton.drive.DriveTurnToAngleLeftSide;
import org.simbotics.frc2017.auton.mode.AutonBuilder;
import org.simbotics.frc2017.auton.mode.AutonMode;
import org.simbotics.frc2017.auton.turret.TurretMoveToAngle;
import org.simbotics.frc2017.auton.util.AutonWait;
import org.simbotics.frc2017.auton.util.AutonWaitUntilAutoTime;


public class MoveToHopperLeftGearHopper implements AutonMode {

	@Override
	public void addToMode(AutonBuilder ab) {
		ab.addCommand(new AutonOverride(RobotComponent.SHOOTER));
		
		ab.addCommand(new TurretMoveToAngle(90, 1500));
		ab.addCommand(new DriveTurnToAngleLeftSide(305,5,1000));
		ab.addCommand(new DriveStraightProfile(-16.0, 305, 0.01, 2500));
		ab.addCommand(new AutonWaitUntilAutoTime(14500));
		ab.addCommand(new AutonOverride(RobotComponent.DRIVE));
		ab.addCommand(new DriveSetOutput(0.3));
		ab.addCommand(new AutonWait(500));
		ab.addCommand(new DriveSetOutput(0.0));
	}

}
