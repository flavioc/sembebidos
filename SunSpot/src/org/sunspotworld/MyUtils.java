package org.sunspotworld;

/**
 *
 * @author flaviocruz
 */
public class MyUtils {
    public static boolean betweenIntervalInt(int val, int min, int max)
    {
        return val >= min && val <= max;
    }

    public static boolean betweenIntervalDouble(double val, double min, double max)
    {
        return val >= min && val <= max;
    }

    public static boolean betweenIntervalIntDelta(int oldValue, int delta, int val)
    {
        return betweenIntervalInt(val, oldValue - delta, oldValue + delta);
    }

    public static boolean betweenIntervalDoubleDelta(double oldValue, double delta, double val)
    {
        return betweenIntervalDouble(val, oldValue - delta, oldValue + delta);
    }
}
