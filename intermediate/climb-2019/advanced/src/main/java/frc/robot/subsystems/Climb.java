package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import static frc.robot.Constants.ElectricalLayout.*;
import static frc.robot.Constants.Climb.*;
import static frc.robot.Constants.*;

public class Climb extends SnailSubsystem {
    
    public enum State {
        NEUTRAL,
        EXTENDED,
        BACK_EXTENDED
    }

    private DoubleSolenoid frontSolenoid;
    private DoubleSolenoid backSolenoid;

    private CANSparkMax frontMotor;
    private CANSparkMax backMotor;

    private State state;
    private double speed;

    public Climb() {
        frontSolenoid = new DoubleSolenoid(CLIMB_FRONT_FORWARD, CLIMB_FRONT_REVERSE);
        backSolenoid = new DoubleSolenoid(CLIMB_BACK_FORWARD, CLIMB_BACK_REVERSE);

        frontMotor = new CANSparkMax(CLIMB_FRONT_MOTOR_ID, MotorType.kBrushless);
        frontMotor.restoreFactoryDefaults();
        frontMotor.setSmartCurrentLimit(NEO_CURRENT_LIMIT);
        frontMotor.setIdleMode(IdleMode.kBrake);

        backMotor = new CANSparkMax(CLIMB_BACK_MOTOR_ID, MotorType.kBrushless);
        backMotor.restoreFactoryDefaults();
        backMotor.setSmartCurrentLimit(NEO_CURRENT_LIMIT);
        backMotor.setIdleMode(IdleMode.kBrake);
        backMotor.follow(frontMotor);

        state = State.NEUTRAL;
    }

    @Override
    public void update() {
        switch(state) {
            case NEUTRAL:
                frontSolenoid.set(Value.kReverse);
                backSolenoid.set(Value.kReverse);
                break;
            case EXTENDED:
                frontSolenoid.set(Value.kForward);
                backSolenoid.set(Value.kForward);
                break;
            case BACK_EXTENDED:
                frontSolenoid.set(Value.kReverse);
                frontSolenoid.set(Value.kForward);
                break;
        }

        if(state != State.NEUTRAL) {
            frontMotor.set(speed);
        }
        else {
            frontMotor.set(0);
        }
    }

    public void advance() {
        switch(state) {
            case NEUTRAL:
                state = State.EXTENDED;
                break;
            case EXTENDED:
                state = State.BACK_EXTENDED;
                break;
            case BACK_EXTENDED:
                state = State.NEUTRAL;
                break;
        }
    }

    public void back() {
        switch(state) {
            case NEUTRAL:
                state = State.BACK_EXTENDED;
                break;
            case EXTENDED:
                state = State.NEUTRAL;
                break;
            case BACK_EXTENDED:
                state = State.EXTENDED;
                break;
        }
    }

    public void drive(double speed) {
        this.speed = speed * CLIMB_MAX_SPEED;
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
