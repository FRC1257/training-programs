// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

public final class Constants {

    public static class ElectricalLayout {
        public final static int CONTROLLER_DRIVER_ID = 0;
        public final static int CONTROLLER_OPERATOR_ID = 1;

        public static final int INTAKE_MOTOR_ID = 0;

        public static final int INTAKE_LEFT_SOLENOID_FORWARD_ID = 1;
        public static final int INTAKE_LEFT_SOLENOID_REVERSE_ID = 2;  
        public static final int INTAKE_RIGHT_SOLENOID_FORWARD_ID = 3;  
        public static final int INTAKE_RIGHT_SOLENOID_REVERSE_ID = 4;  
    }

    public static class Intake {
        public static final double INTAKE_INTAKE_SPEED = -0.7;
		public static final double INTAKE_NEUTRAL_SPEED = -0.2;
		public static final double INTAKE_EJECT_SPEED = 0.9;
    }

    public static double PI = 3.14159265;
    public static double UPDATE_PERIOD = 0.010; // seconds
    public static int NEO_550_CURRENT_LIMIT = 25;
}
