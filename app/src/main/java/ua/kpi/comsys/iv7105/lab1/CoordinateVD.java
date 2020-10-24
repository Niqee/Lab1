package ua.kpi.comsys.iv7105.lab1;

import androidx.annotation.NonNull;

public class CoordinateVD {
    private Direction direction;
    private int degrees;
    private int minutes;
    private int seconds;

    private final int MIN_LATITUDE_VALUE = -90;
    private final int MAX_LATITUDE_VALUE = 90;

    private final int MIN_LONGITUDE_VALUE = -180;
    private final int MAX_LONGITUDE_VALUE = 180;

    private final int MIN_MINUTES_VALUE = 0;
    private final int MAX_MINUTES_VALUE = 59;

    private final int MIN_SECONDS_VALUE = 0;
    private final int MAX_SECONDS_VALUE = 59;

    private static final Direction DEFAULT_DIRECTION = Direction.latitudeN;
    private static final int DEFAULT_DEGREES = 0;
    private static final int DEFAULT_MINUTES = 0;
    private static final int DEFAULT_SECONDS = 0;

    public CoordinateVD() {
        this(DEFAULT_DIRECTION, DEFAULT_DEGREES, DEFAULT_MINUTES, DEFAULT_SECONDS);
    }

    public CoordinateVD(Direction direction, int degrees, int minutes, int seconds) {
        this.direction = direction;
        this.degrees = direction.isLatitude() ?
                getValidOrDefault(
                        degrees,
                        MIN_LATITUDE_VALUE,
                        MAX_LATITUDE_VALUE,
                        DEFAULT_DEGREES) :
                getValidOrDefault(
                        degrees,
                        MIN_LONGITUDE_VALUE,
                        MAX_LONGITUDE_VALUE,
                        DEFAULT_DEGREES);
        this.minutes = getValidOrDefault(
                minutes,
                MIN_MINUTES_VALUE,
                MAX_MINUTES_VALUE,
                DEFAULT_MINUTES);
        this.seconds = getValidOrDefault(
                seconds,
                MIN_SECONDS_VALUE,
                MAX_SECONDS_VALUE,
                DEFAULT_SECONDS);
    }

    public String getInFormatA() {
        return String.format("%02d°%02d′%02d″ %s", degrees, minutes, seconds, direction.toString());
    }

    public String getInFormatB() {
        return String.format("%07.4f° %s", getDecimal(), direction.toString());
    }

    public CoordinateVD getBetween(CoordinateVD that) {
        return CoordinateVD.getBetween(this, that);
    }

    public static CoordinateVD getBetween(CoordinateVD a, CoordinateVD b) {
        if (a.direction.isLatitude() != b.direction.isLatitude() ||
                !a.direction.toString().equals(b.direction.toString()))
            return null;

        double mid = (a.getDecimal() + b.getDecimal()) / 2;

        int newDegrees = (int) mid;
        mid = (mid - (int) mid) * 60;
        int newMinutes = (int) mid;
        mid = (mid - (int) mid) * 60;
        int newSeconds = (int) mid;

        return new CoordinateVD(
                a.direction,
                newDegrees,
                newMinutes,
                newSeconds);
    }

    private double getDecimal() {
        return degrees + (double) minutes / 60 + (double) seconds / 3600;
    }

    private int getValidOrDefault(int value, int min, int max, int defaultValue) {
        return value >= min && value <= max ? value : defaultValue;
    }
}
