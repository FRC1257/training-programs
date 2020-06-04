package frc.robot;

import frc.robot.commands.rollerintake.RollerIntakeNeutralCommand;
import frc.robot.commands.rollerintake.RollerIntakeIntakeCommand;
import frc.robot.commands.rollerintake.RollerIntakeEjectCommand;

import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.SnailSubsystem;
import frc.robot.util.SnailController;
import frc.robot.subsystems.RollerIntake;
import edu.wpi.first.wpilibj.XboxController.Button;

import java.util.ArrayList;

import static frc.robot.Constants.ElectricalLayout.CONTROLLER_DRIVER_ID;
import static frc.robot.Constants.ElectricalLayout.CONTROLLER_OPERATOR_ID;
import static frc.robot.Constants.UPDATE_PERIOD;

public class RobotContainer {

    private final SnailController driveController;
    private final SnailController operatorController;

    private  RollerIntake rollerIntake;

    private ArrayList<SnailSubsystem> subsystems;

    public RobotContainer() {
        driveController = new SnailController(CONTROLLER_DRIVER_ID);
        operatorController = new SnailController(CONTROLLER_OPERATOR_ID);

        configureSubsystems();
        configureButtonBindings();
    }

    private void configureSubsystems() {

        rollerIntake = new RollerIntake();
        rollerIntake.setDefaultCommand(new RollerIntakeNeutralCommand(rollerIntake));

        subsystems = new ArrayList<>();

        subsystems.add(rollerIntake);
    }

    private void configureButtonBindings() {
        operatorController.getButton(Button.kX.value).whileActiveOnce(new RollerIntakeEjectCommand(rollerIntake));
        operatorController.getButton(Button.kA.value).whileActiveOnce(new RollerIntakeIntakeCommand(rollerIntake));
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
    }

    public void tuningInit() {
        for(SnailSubsystem subsystem : subsystems) {
            subsystem.tuningInit();
        }
    }

    public void tuningPeriodic() {
    }
}
