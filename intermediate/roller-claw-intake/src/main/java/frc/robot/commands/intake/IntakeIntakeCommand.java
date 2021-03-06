package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class IntakeIntakeCommand extends CommandBase {

    private final Intake intake;
    
    public IntakeIntakeCommand(Intake intake) {
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        intake.intake();
    }

    @Override
    public void end(boolean interrupted) {
        
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
