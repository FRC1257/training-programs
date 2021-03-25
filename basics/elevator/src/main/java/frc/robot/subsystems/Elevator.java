package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import static frc.robot.Constants.ElectricalLayout.*;
import static frc.robot.Constants.Elevator.*;
import static frc.robot.Constants.NEO_CURRENT_LIMIT;

public class Elevator extends SnailSubsystem {

    private CANSparkMax primaryMotor;
    private CANSparkMax secondaryMotor;

    public enum State {
        MANUAL
    }
    
    public State state;
    private double speed;

    private boolean precisionEnabled;

    public Elevator() {
        primaryMotor = new CANSparkMax(ELEVATOR_PRIMARY_MOTOR_ID, MotorType.kBrushless); 
        primaryMotor.restoreFactoryDefaults();
        primaryMotor.setIdleMode(IdleMode.kBrake);
        primaryMotor.setSmartCurrentLimit(NEO_CURRENT_LIMIT);

        secondaryMotor = new CANSparkMax(ELEVATOR_SECONDARY_MOTOR_ID, MotorType.kBrushless);
        secondaryMotor.restoreFactoryDefaults();
        secondaryMotor.setIdleMode(IdleMode.kBrake);
        secondaryMotor.setSmartCurrentLimit(NEO_CURRENT_LIMIT);
        secondaryMotor.follow(primaryMotor);
        
        state = State.MANUAL;
        speed = 0;
        precisionEnabled = false;
    }

    @Override
    public void update() {
        switch(state) {
            case MANUAL:
                double adjustedSpeed = speed;
                if(this.precisionEnabled) adjustedSpeed *= ELEVATOR_PRECISION_MULT;

                primaryMotor.set(adjustedSpeed);
                break;
        }
    }
    
    public void manualControl(double speed) {
        state = State.MANUAL;
        this.speed = speed * ELEVATOR_MAX_OUTPUT;
    }

    public void togglePrecision() {
        this.precisionEnabled = !this.precisionEnabled;
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
