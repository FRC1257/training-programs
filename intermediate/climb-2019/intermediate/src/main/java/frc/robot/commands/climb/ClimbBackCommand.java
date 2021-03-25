package frc.robot.commands.climb;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Climb;

public class ClimbBackCommand extends InstantCommand {
    
    private Climb climb;

    public ClimbBackCommand(Climb climb) {
        this.climb = climb;
        addRequirements(climb);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        climb.back();
    }

    @Override
    public void end(boolean interrupted) {
        
    }
}
