package frc.robot;

import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.intake.IntakeCloseCommand;
import frc.robot.commands.intake.IntakeOpenCommand;
import frc.robot.commands.intake.IntakeEjectCommand;
import frc.robot.commands.intake.IntakeIntakeCommand;
import frc.robot.commands.intake.IntakeNeutralCommand;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.SnailSubsystem;
import frc.robot.util.SnailController;

import java.util.ArrayList;

import static frc.robot.Constants.ElectricalLayout.CONTROLLER_DRIVER_ID;
import static frc.robot.Constants.ElectricalLayout.CONTROLLER_OPERATOR_ID;
import static frc.robot.Constants.UPDATE_PERIOD;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the Robot
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

    private SnailController driveController;
    private SnailController operatorController;
    
    private ArrayList<SnailSubsystem> subsystems;
    private Intake intake;
    
    private Notifier updateNotifier;
    private int outputCounter;

    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        driveController = new SnailController(CONTROLLER_DRIVER_ID);
        operatorController = new SnailController(CONTROLLER_OPERATOR_ID);

        configureSubsystems();
        configureAutoChoosers();
        configureButtonBindings();
        
        outputCounter = 0;

        SmartDashboard.putBoolean("Testing", false);

        updateNotifier = new Notifier(this::update);
        updateNotifier.startPeriodic(UPDATE_PERIOD);
    }

    /**
     * Declare all of our subsystems and their default bindings
     */
    private void configureSubsystems() {
        // declare each of the subsystems here
        intake = new Intake();
        intake.setDefaultCommand(new IntakeNeutralCommand(intake));

        // add each of the subsystems to the arraylist here
        subsystems = new ArrayList<>();
        subsystems.add(intake);
    }

    /**
     * Define button -> command mappings.
     */
    private void configureButtonBindings() {
        operatorController.getButton(Button.kA.value).whileHeld(new IntakeIntakeCommand(intake)); 
        operatorController.getButton(Button.kB.value).whileHeld(new IntakeEjectCommand(intake));
        
        // ensure these commands aren't interruptible
        operatorController.getButton(Button.kX.value).whenPressed(new IntakeOpenCommand(intake), false);
        operatorController.getButton(Button.kY.value).whenPressed(new IntakeCloseCommand(intake), false);
    }

    /**
     * Set up the choosers on shuffleboard for autonomous
     */
    public void configureAutoChoosers() {
        
    }

    /**
     * Do the logic to return the auto command to run
     */
    public Command getAutoCommand() {
        return null;
    }

    /**
     * Update all of the subsystems
     * This is run in a separate loop at a faster rate to:
     * a) update subsystems faster
     * b) prevent packet delay from driver station from delaying response from our robot
     */
    private void update() {
        for(SnailSubsystem subsystem : subsystems) {
            subsystem.update();
        }
    }

    public void displayShuffleboard() {
        if(outputCounter % 3 == 0) {
            subsystems.get(outputCounter / 3).outputValues();
        }

        outputCounter = (outputCounter + 1) % (subsystems.size() * 3);
    }

    public void tuningInit() {
        for(SnailSubsystem subsystem : subsystems) {
            subsystem.setUpConstantTuning();
        }
    }

    public void tuningPeriodic() {
        if(outputCounter % 3 == 0) {
            subsystems.get(outputCounter / 3).getConstantTuning();
        }
    }
}