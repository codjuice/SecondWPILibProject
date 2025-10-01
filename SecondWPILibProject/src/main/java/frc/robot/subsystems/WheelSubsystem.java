package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/** A wheel subsystem that does something. */
public class WheelSubsystem extends SubsystemBase {
    // Use Bill Pugh Singleton Pattern for efficient lazy initialization (thread-safe !)
        private static class WheelSubsystemHolder {
            private static final WheelSubsystem INSTANCE = new WheelSubsystem();
        }
        TalonFX drivingMotor = new TalonFX(10);
        TalonFX turningMotor = new TalonFX(9);
        CANcoder turningEncoder = new CANcoder(3);
    
    
        /** Always use this method to get the singleton instance of this subsystem. */
        public static WheelSubsystem getInstance() {
            return WheelSubsystemHolder.INSTANCE;
        }
    
    
        private WheelSubsystem() {
            super("WheelSubsystem");
        }

        public void setDrivingSpeed(double speed) {
            drivingMotor.set(speed);
        }

        public void setTurningSpeed(double speed) {
            turningMotor.set(speed);
        }

        public double getTurningPosition() {
            return Units.radiansToDegrees(turningEncoder.getAbsolutePosition().getValueAsDouble());
        }
    
        @Override
        public void periodic() {}
    }
    