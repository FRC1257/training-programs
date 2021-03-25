package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Elevator;

public class ElevatorTogglePrecision extends InstantCommand {

    private final Elevator elevator;
    
    public ElevatorTogglePrecision(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void initialize() {
        elevator.togglePrecision();
    }

    @Override
    public void end(boolean interrupted) {

    }
}
