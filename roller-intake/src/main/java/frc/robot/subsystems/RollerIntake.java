package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class RollerIntake extends SnailSubsystem {

    private CANSparkMax rollerIntakeMotor;

    public enum State {
        INTAKING,
        EJECTING,
        NEUTRAL
    }

    State state = State.NEUTRAL;

    public RollerIntake() {
        rollerIntakeMotor = new CANSparkMax(2, MotorType.kBrushless);
        rollerIntakeMotor.restoreFactoryDefaults();
        rollerIntakeMotor.setIdleMode(IdleMode.kBrake);
        rollerIntakeMotor.setSmartCurrentLimit(25);
    }

    @Override
    public void update() {
        switch(state) {
            case NEUTRAL:
                rollerIntakeMotor.set(0.0);
                break;
            case INTAKING:
                rollerIntakeMotor.set(1.0);
                break;
            case EJECTING:
                rollerIntakeMotor.set(-1.0);
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