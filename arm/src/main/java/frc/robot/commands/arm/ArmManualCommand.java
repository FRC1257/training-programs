package frc.robot.commands.arm;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

import java.util.function.DoubleSupplier;

public class ArmManualCommand extends CommandBase {

    private final Arm arm;
    private final DoubleSupplier speedSupplier;

    public ArmManualCommand(Arm arm, DoubleSupplier speedSupplier) {
        this.arm = arm;
        this.speedSupplier = speedSupplier;

        addRequirements(arm);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        arm.setArmSpeed(speedSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}