package frc.robot.subsystems;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import static frc.robot.Constants.ElectricalLayout.*;

public class ClawIntake extends SnailSubsystem {

    private DoubleSolenoid rightSolenoid;
    private DoubleSolenoid leftSolenoid;

    public enum State {
       CLOSED,
       OPEN
    }

    State state;

    public ClawIntake() {
        leftSolenoid = new DoubleSolenoid(CLAW_LEFT_FORWARD_ID, CLAW_LEFT_REVERSE_ID);
        rightSolenoid = new DoubleSolenoid(CLAW_RIGHT_FORWARD_ID, CLAW_RIGHT_REVERSE_ID);

        state = State.OPEN;
    }

    @Override
    public void update() {
        switch(state) {
            case CLOSED:
                leftSolenoid.set(Value.kForward);
                rightSolenoid.set(Value.kForward);
                break;
            case OPEN:
                leftSolenoid.set(Value.kReverse);
                rightSolenoid.set(Value.kReverse);
                break;
        }
    }

    public void open() {
        state = State.OPEN;
    }

    public void close() {
        state = State.CLOSED;
    }

    public void displayShuffleboard() {

    }

    public void tuningInit() {

    }

    public void tuningPeriodic() {

    }

    public State getState() {
        return state;
    }
}
