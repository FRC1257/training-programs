package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import static frc.robot.Constants.ElectricalLayout.*;

public class Climb extends SnailSubsystem {
    
    public enum State {
        NEUTRAL,
        EXTENDED
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
        }
    }

    public void toggle() {
        if(state == State.EXTENDED) state = State.NEUTRAL;
        if(state == State.NEUTRAL) state = State.EXTENDED;
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
