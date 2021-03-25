package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be
 * declared globally (i.e. public static). Do not put anything functional in this class.
 *
 * It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 * 
 * Each subsystem should have its own static inner class to hold its constants
 */
public final class Constants {

    public static class ElectricalLayout {
        public final static int CONTROLLER_DRIVER_ID = 0;
        public final static int CONTROLLER_OPERATOR_ID = 1;

        // Elevator
        public final static int ELEVATOR_PRIMARY_MOTOR_ID = 0;
        public final static int ELEVATOR_SECONDARY_MOTOR_ID = 0;
    }

    public static class Autonomous {
        
    }

    public static class Elevator {
        public static double ELEVATOR_MAX_OUTPUT = 0.7;
        public static double ELEVATOR_PRECISION_MULT = 0.2;
    }

    public static double PI = 3.14159265;
    public static double UPDATE_PERIOD = 0.010; // seconds

    public static int NEO_CURRENT_LIMIT = 80; // amps
}
