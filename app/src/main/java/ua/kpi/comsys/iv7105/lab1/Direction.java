package ua.kpi.comsys.iv7105.lab1;

import androidx.annotation.NonNull;

public enum Direction {
    longitudeW(false, 'W'),
    longitudeE(false, 'E'),
    latitudeN(true, 'N'),
    latitudeS(true, 'S');

    private boolean isLatitude;
    private char dir;

    Direction(boolean isLatitude, char dir) {
        this.isLatitude = isLatitude;
        this.dir = dir;
    }

    public boolean isLatitude() {
        return isLatitude;
    }

    @NonNull
    @Override
    public String toString() {
        return String.valueOf(dir);
    }
}
