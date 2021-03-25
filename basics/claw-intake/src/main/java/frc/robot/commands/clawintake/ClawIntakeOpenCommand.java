package frc.robot.commands.clawintake;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.ClawIntake;

public class ClawIntakeOpenCommand extends InstantCommand {
    
    private ClawIntake clawIntake;

    public ClawIntakeOpenCommand(ClawIntake clawIntake) {
        this.clawIntake = clawIntake;

        addRequirements(clawIntake);
    }

    @Override
    public void initialize() {
        clawIntake.open();
    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {
    
    }
}
