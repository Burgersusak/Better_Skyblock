package net.dusan.better_skyblock.system.mining.capability.mining_speed;

public class MiningSpeedCapability {
    private float miningSpeed = 0;

    public float getMiningSpeed() {
        return miningSpeed;
    }

    public void setMiningSpeed(float miningSpeed) {
        this.miningSpeed = miningSpeed;
    }

    public void addMiningSpeed(float amount) {
        this.miningSpeed += amount;
    }

    public void resetMiningSpeed() {
        this.miningSpeed = 0;
    }
}
