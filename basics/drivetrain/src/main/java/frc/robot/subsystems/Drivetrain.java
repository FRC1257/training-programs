package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import static frc.robot.Constants.ElectricalLayout.*;
import static frc.robot.Constants.Drivetrain.*;
import static frc.robot.Constants.NEO_CURRENT_LIMIT;

public class Drivetrain extends SnailSubsystem {

    private final CANSparkMax frontLeftMotor;
    private final CANSparkMax frontRightMotor;
    private final CANSparkMax backLeftMotor;
    private final CANSparkMax backRightMotor;

    private final DifferentialDrive drivetrain;

    public enum State {
        MANUAL
    }
    
    private State state;
    private double speedForward;
    private double speedTurn;

    private boolean reverseEnabled;
    private boolean slowTurnEnabled;

    public Drivetrain() {
        frontLeftMotor = new CANSparkMax(DRIVE_FRONT_LEFT, MotorType.kBrushless);
        frontRightMotor = new CANSparkMax(DRIVE_FRONT_RIGHT, MotorType.kBrushless);
        backLeftMotor = new CANSparkMax(DRIVE_BACK_LEFT, MotorType.kBrushless);
        backRightMotor = new CANSparkMax(DRIVE_BACK_RIGHT, MotorType.kBrushless);

        backLeftMotor.follow(frontLeftMotor);
        backRightMotor.follow(frontRightMotor);

        frontLeftMotor.restoreFactoryDefaults();
        frontRightMotor.restoreFactoryDefaults();
        backLeftMotor.restoreFactoryDefaults();
        backRightMotor.restoreFactoryDefaults();

        frontLeftMotor.setSmartCurrentLimit(NEO_CURRENT_LIMIT);
        frontRightMotor.setSmartCurrentLimit(NEO_CURRENT_LIMIT);
        backLeftMotor.setSmartCurrentLimit(NEO_CURRENT_LIMIT);
        backRightMotor.setSmartCurrentLimit(NEO_CURRENT_LIMIT);

        frontLeftMotor.setIdleMode(IdleMode.kBrake);
        frontRightMotor.setIdleMode(IdleMode.kBrake);
        backLeftMotor.setIdleMode(IdleMode.kCoast);
        backRightMotor.setIdleMode(IdleMode.kCoast);

        drivetrain = new DifferentialDrive(frontLeftMotor, frontRightMotor);

        state = State.MANUAL;
        speedForward = 0;
        speedTurn = 0;

        reverseEnabled = false;
        slowTurnEnabled = false;
    }

    @Override
    public void update() {
        switch (state) {
            case MANUAL:
                double adjustedSpeedForward = speedForward;
                if(reverseEnabled) speedForward *= -1;

                double adjustedSpeedTurn = speedTurn;
                if(slowTurnEnabled) speedTurn *= DRIVETRAIN_SLOW_TURN_MULT;

                drivetrain.arcadeDrive(adjustedSpeedForward, adjustedSpeedTurn);
                break;
        }
    }

    public void manualDrive(double speedForward, double speedTurn) {
        this.speedForward = speedForward;
        this.speedTurn = speedTurn;

        state = State.MANUAL;
    }

    public void toggleReverse() {
        this.reverseEnabled = !this.reverseEnabled;
    }

    public void toggleSlowTurn() {
        this.slowTurnEnabled = !this.slowTurnEnabled;
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
}