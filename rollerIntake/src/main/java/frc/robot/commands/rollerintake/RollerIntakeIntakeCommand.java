package frc.robot.commands.rollerintake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RollerIntake;

public class RollerIntakeIntakeCommand extends CommandBase {

    private RollerIntake rollerIntake;

    public RollerIntakeIntakeCommand(RollerIntake rollerIntake) {
        this.rollerIntake = rollerIntake;

        addRequirements(rollerIntake);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        rollerIntake.intake();
    }

    @Override
    public void end(boolean interrupted) {
        rollerIntake.neutral();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}