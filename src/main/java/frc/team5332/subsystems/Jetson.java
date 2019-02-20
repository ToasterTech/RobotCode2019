package frc.team5332.subsystems;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import frc.team5332.robot.CMap;

public class Jetson implements PIDSource {
    private PIDSourceType type;

    public Jetson(){
        type = PIDSourceType.kDisplacement;
    }

    @Override
    public void setPIDSourceType(PIDSourceType pidSource) {
        type = pidSource;
    }

    @Override
    public PIDSourceType getPIDSourceType() {
        return type;
    }

    @Override
    public double pidGet() {
        return CMap.visionTable.getEntry("Angle").getDouble(0);
    }
}
