package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Intake;

public class IntakeOpenCommand extends InstantCommand {

    private final Intake intake;
    
    public IntakeOpenCommand(Intake intake) {
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        intake.open();
    }

    @Override
    public void end(boolean interrupted) {
        
    }
}
