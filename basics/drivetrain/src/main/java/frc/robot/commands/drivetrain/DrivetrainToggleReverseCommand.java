package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Drivetrain;

public class DrivetrainToggleReverseCommand extends InstantCommand {

    private final Drivetrain drivetrain;

    public DrivetrainToggleReverseCommand(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;

        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        drivetrain.toggleReverse();
    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {

    }
}
