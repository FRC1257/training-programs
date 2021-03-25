package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import static frc.robot.Constants.ElectricalLayout.*;

public class Climb extends SnailSubsystem {
    
    public enum State {
        NEUTRAL,
        EXTENDED,
        BACK_EXTENDED
    }

    private DoubleSolenoid frontSolenoid;
    private DoubleSolenoid backSolenoid;

    private State state;

    public Climb() {
        frontSolenoid = new DoubleSolenoid(CLIMB_FRONT_FORWARD, CLIMB_FRONT_REVERSE);
        backSolenoid = new DoubleSolenoid(CLIMB_BACK_FORWARD, CLIMB_BACK_REVERSE);

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
