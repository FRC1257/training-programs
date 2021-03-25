package frc.robot.commands.drivetrain;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DrivetrainManualCommand extends CommandBase {
    
    private final Drivetrain drivetrain;
    private final DoubleSupplier forwardSupplier;
    private final DoubleSupplier turnSupplier;

    public DrivetrainManualCommand(Drivetrain drivetrain, DoubleSupplier forwardSupplier, DoubleSupplier turnSupplier) {
        this.drivetrain = drivetrain;
        this.forwardSupplier = forwardSupplier;
        this.turnSupplier = turnSupplier;

        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        drivetrain.manualDrive(forwardSupplier.getAsDouble(), turnSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
