package sensorval;

import java.util.List;

public class SensorValidator 
{
	static final double SOC_MAX_DELTA=0.05;
	static final double CURRENT_MAX_DELTA=0.1;
	
    private static boolean deltaExceedsLimit(double value, double nextValue, double maxDelta) {
        return Math.abs(nextValue - value) > maxDelta; 
    }
    public static boolean validateSOCreadings(List<Double> values) {
    	return isValid(values)? validateReadings(values,SOC_MAX_DELTA):false;
    }
    private static boolean isValid(List<Double> values) {
		return notNull(values) && noNullContent(values);
	}
	private static boolean noNullContent(List<Double> values) {
		return !values.contains(null) && !values.contains(Double.NaN);
	}
	public static boolean validateCurrentreadings(List<Double> values) {
    	return isValid(values)? validateReadings(values,CURRENT_MAX_DELTA):false;
    }
    
    private static boolean notNull(List<Double> values) {
    	return (values!=null && values.size()>0);
    }
    
    private static boolean validateReadings(List<Double> values, Double maxDelta) {
        int lastButOneIndex = values.size() - 1;
        for(int i = 0; i < lastButOneIndex; i++)
            if(deltaExceedsLimit(values.get(i), values.get(i + 1), maxDelta))
            	return false;
        return true;
    }
}
