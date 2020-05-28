package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import static frc.robot.Constants.ElectricalLayout.*;
import static frc.robot.Constants.NEO_550_CURRENT_LIMIT;


public class Arm extends SnailSubsystem {

    private CANSparkMax armMotor;
    private double speed = 0;

    public enum State {
        MANUAL
    }
    public State defaultState = State.MANUAL;
    public State state = defaultState;

    public Arm() {
        armMotor = new CANSparkMax(ARM_ID, MotorType.kBrushless); 
        armMotor.restoreFactoryDefaults();
        armMotor.setIdleMode(IdleMode.kBrake);
        armMotor.setSmartCurrentLimit(NEO_550_CURRENT_LIMIT); 
    }

    @Override
    public void update() {
        switch(state) {
            case MANUAL:
                armMotor.set(speed);
                break;
        }
    }
    
    public void setArmSpeed(double speed){
        this.speed = speed;
        state = State.MANUAL;
    }

    @Override
    public void displayShuffleboard() {
        SmartDashboard.putString("Arm State", state.name());
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
