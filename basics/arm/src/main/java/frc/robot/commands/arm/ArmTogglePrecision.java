package frc.robot.commands.arm;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Arm;

public class ArmTogglePrecision extends InstantCommand {

    private final Arm arm;
    
    public ArmTogglePrecision(Arm arm) {
        this.arm = arm;
    }

    @Override
    public void initialize() {
        arm.togglePrecision();
    }

    @Override
    public void end(boolean interrupted) {

    }
}
