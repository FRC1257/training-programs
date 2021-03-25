package frc.robot.commands.climb;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climb;

public class ClimbDriveCommand extends CommandBase {
    
    private Climb climb;
    private DoubleSupplier speedSupplier;

    public ClimbDriveCommand(Climb climb, DoubleSupplier speedSupplier) {
        this.climb = climb;
        addRequirements(climb);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        climb.drive(speedSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
