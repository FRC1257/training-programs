package frc.robot.commands.clawintake;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.ClawIntake;

public class ClawIntakeCloseCommand extends InstantCommand {
    
    private ClawIntake clawIntake;

    public ClawIntakeCloseCommand(ClawIntake clawIntake) {
        this.clawIntake = clawIntake;

        addRequirements(clawIntake);
    }

    @Override
    public void initialize() {
        clawIntake.close();
    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {
    
    }
}
