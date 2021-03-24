package sensorval;

import java.util.List;

public class SensorValidator 
{
	static final double SOC_MAX_DELTA=0.05;
	static final double CURRENT_MAX_DELTA=0.1;
	
    public static boolean deltaExceedsLimit(double value, double nextValue, double maxDelta) {
        return Math.abs(nextValue - value) > maxDelta; 
    }
    public static boolean validateSOCreadings(List<Double> values) {
    	return notNull(values)? validateReadings(values,SOC_MAX_DELTA):false;
    }
    public static boolean validateCurrentreadings(List<Double> values) {
    	return notNull(values)? validateReadings(values,CURRENT_MAX_DELTA):false;
    }
    
    public static boolean notNull(List<Double> values) {
    	return (values!=null && !values.contains(null) && values.size()>0);
    }
    
    public static boolean validateReadings(List<Double> values, Double maxDelta) {
        int lastButOneIndex = values.size() - 1;
        for(int i = 0; i < lastButOneIndex; i++)
            if(deltaExceedsLimit(values.get(i), values.get(i + 1), maxDelta))
            	return false;
        return true;
    }
}
