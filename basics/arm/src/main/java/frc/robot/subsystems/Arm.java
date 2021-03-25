package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import static frc.robot.Constants.ElectricalLayout.*;
import static frc.robot.Constants.Arm.*;
import static frc.robot.Constants.NEO_CURRENT_LIMIT;

public class Arm extends SnailSubsystem {

    private CANSparkMax motor;

    public enum State {
        MANUAL
    }
    
    public State state;
    private double speed;

    private boolean precisionEnabled;

    public Arm() {
        motor = new CANSparkMax(ARM_MOTOR_ID, MotorType.kBrushless); 
        motor.restoreFactoryDefaults();
        motor.setIdleMode(IdleMode.kBrake);
        motor.setSmartCurrentLimit(NEO_CURRENT_LIMIT);
        
        state = State.MANUAL;
        speed = 0;
        precisionEnabled = false;
    }

    @Override
    public void update() {
        switch(state) {
            case MANUAL:
                double adjustedSpeed = speed;
                if(this.precisionEnabled) adjustedSpeed *= ARM_PRECISION_MULT;

                motor.set(adjustedSpeed);
                break;
        }
    }
    
    public void manualControl(double speed) {
        state = State.MANUAL;
        this.speed = speed * ARM_MAX_OUTPUT;
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
