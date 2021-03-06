package frc.robot.commands.rollerintake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RollerIntake;

public class RollerIntakeNeutralCommand extends CommandBase {

    private RollerIntake rollerIntake;

    public RollerIntakeNeutralCommand(RollerIntake rollerIntake) {
        this.rollerIntake = rollerIntake;

        addRequirements(rollerIntake);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        rollerIntake.neutral();
    }

    @Override
    public void end(boolean interrupted) {
        
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}