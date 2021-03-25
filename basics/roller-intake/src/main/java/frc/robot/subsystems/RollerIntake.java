package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import static frc.robot.Constants.ElectricalLayout.*;
import static frc.robot.Constants.RollerIntake.*;
import static frc.robot.Constants.NEO_550_CURRENT_LIMIT;

public class RollerIntake extends SnailSubsystem {

    private CANSparkMax rollerIntakeMotor;

    public enum State {
        INTAKING,
        EJECTING,
        NEUTRAL
    }

    State state;

    public RollerIntake() {
        rollerIntakeMotor = new CANSparkMax(ROLLER_INTAKE_MOTOR_ID, MotorType.kBrushless);
        rollerIntakeMotor.restoreFactoryDefaults();
        rollerIntakeMotor.setIdleMode(IdleMode.kBrake);
        rollerIntakeMotor.setSmartCurrentLimit(NEO_550_CURRENT_LIMIT);

        state = State.NEUTRAL;
    }

    @Override
    public void update() {
        switch(state) {
            case NEUTRAL:
                rollerIntakeMotor.set(ROLLER_INTAKE_NEUTRAL_SPEED);
                break;
            case INTAKING:
                rollerIntakeMotor.set(ROLLER_INTAKE_INTAKE_SPEED);
                break;
            case EJECTING:
                rollerIntakeMotor.set(ROLLER_INTAKE_EJECT_SPEED);
                break;
        }
    }

    public void neutral() {
        state = State.NEUTRAL;
    }

    public void eject() {
        state = State.EJECTING;
    }

    public void intake() {
        state = State.INTAKING;
    }

    @Override
    public void displayShuffleboard() {

    }

    @Override
    public void tuningInit() {

    }

    @Override
    public void tuningPeriodic() {

    }

    public State getState() {
        return state;
    }
}