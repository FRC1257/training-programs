package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import static frc.robot.Constants.ElectricalLayout.*;
import static frc.robot.Constants.Elevator.*;
import static frc.robot.Constants.NEO_550_CURRENT_LIMIT;


public class Elevator extends SnailSubsystem {

    private CANSparkMax elevatorMotor;
    private CANSparkMax elevatorFollowerMotor;

    public enum State {
        MANUAL
    }

    State state = State.MANUAL;
    private double speed = 0;

    public Elevator() {
        elevatorMotor = new CANSparkMax(ELEVATOR_ID, MotorType.kBrushless); // can you make this a constant in Constants.java pls
        elevatorMotor.restoreFactoryDefaults();
        elevatorMotor.setIdleMode(IdleMode.kBrake);
        elevatorMotor.setSmartCurrentLimit(NEO_CURRENT_LIMIT); // in amps

        elevatorFollowerMotor = new CANSparkMax(ELEVATOR_ID, MotorType.kBrushless); // can you make this a constant in Constants.java pls
        elevatorFollowerMotor.restoreFactoryDefaults();
        elevatorFollowerMotor.setIdleMode(IdleMode.kBrake);
        elevatorFollowerMotor.setSmartCurrentLimit(NEO_CURRENT_LIMIT); // in amps  
        followerMotor.follow(elevatorMotor, false);
 
    }

    @Override
    public void update() {
        switch(state) {
            case MANUAL:
                elevatorMotor.set(speed);
                break;
        }
    }
    
    public void setElevatorSpeed(double speed){
        this.speed = speed;
        state = State.MANUAL;
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