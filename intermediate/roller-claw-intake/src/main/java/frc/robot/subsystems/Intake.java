package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import static frc.robot.Constants.ElectricalLayout.*;
import static frc.robot.Constants.Intake.*;
import static frc.robot.Constants.*;

public class Intake extends SnailSubsystem {

	private CANSparkMax intakeMotor;

	private DoubleSolenoid leftSolenoid;
	private DoubleSolenoid rightSolenoid;

	public enum IntakeState {
		INTAKING,
		NEUTRAL,
		EJECTING
	}
	private IntakeState intakeState = IntakeState.NEUTRAL;

	public enum ClawState {
		OPEN,
		CLOSED
	}
	private ClawState clawState = ClawState.CLOSED;

	public Intake() {
		intakeMotor = new CANSparkMax(ElectricalLayout.INTAKE_MOTOR_ID, MotorType.kBrushless);
		intakeMotor.restoreFactoryDefaults();
		intakeMotor.setSmartCurrentLimit(NEO_550_CURRENT_LIMIT);
		intakeMotor.setIdleMode(IdleMode.kBrake);
		
		leftSolenoid = new DoubleSolenoid(INTAKE_LEFT_SOLENOID_FORWARD_ID, INTAKE_LEFT_SOLENOID_REVERSE_ID);
		rightSolenoid = new DoubleSolenoid(INTAKE_RIGHT_SOLENOID_FORWARD_ID, INTAKE_RIGHT_SOLENOID_REVERSE_ID);
	}

	@Override
	public void update() {
		switch (intakeState) {
			case NEUTRAL:
				intakeMotor.set(INTAKE_EJECT_SPEED);
				break;
			case INTAKING:
				intakeMotor.set(INTAKE_INTAKE_SPEED);
				break;
			case EJECTING:
				intakeMotor.set(INTAKE_EJECT_SPEED);
				break;
		}

		switch (clawState) {
			case OPEN:
				leftSolenoid.set(Value.kForward);
				rightSolenoid.set(Value.kForward);
				break;
			case CLOSED:
				leftSolenoid.set(Value.kReverse);
				rightSolenoid.set(Value.kReverse);
				break;
		}
	}

	public void intake() {
		intakeState = IntakeState.INTAKING;
	}

	public void neutral() {
		intakeState = IntakeState.NEUTRAL;
	}
  
	public void eject() {
		intakeState = IntakeState.EJECTING;
	}

	public void open() {
		clawState = ClawState.OPEN;
	}

	public void close() {
		clawState = ClawState.CLOSED;
	}

	public IntakeState getIntakeState() {
		return intakeState;
	}

	public ClawState getClawState() {
		return clawState;
	}
  
	@Override
	public void simulationPeriodic() {
	
	}

	@Override
	public void outputValues() {

	}

	@Override
	public void setUpConstantTuning() {

	}

	@Override
	public void getConstantTuning() {

	}
}
