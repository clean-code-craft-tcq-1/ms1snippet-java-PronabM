package sensorval;

import static org.junit.Assert.*;
import jdk.nashorn.internal.AssertsEnabled;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class SensorValidatorTest 
{
    @Test
    public void reportsErrorWhenSOCjumpsUp()
    {
        Double[] readings = {0.0, 0.01, 0.5, 0.51};
        List<Double> socs = Arrays.asList(readings);
        assertFalse(SensorValidator.validateSOCreadings(socs));
    }
    @Test
    public void reportsErrorWhenCurrentjumpsUp()
    {
        Double[] readings = {0.03, 0.03, 0.03, 0.33};
        List<Double> currents = Arrays.asList(readings);
        assertFalse(SensorValidator.validateCurrentreadings(currents));
    }
    @Test
    public void reportsErrorWhenSOCjumpsDown()
    {
        Double[] readings = {0.5, 0.01, 0.05, 0.1};
        List<Double> socs = Arrays.asList(readings);
        assertFalse(SensorValidator.validateSOCreadings(socs));
    }
    @Test
    public void reportsErrorWhenCurrentjumpsDown()
    {
        Double[] readings = {0.1, 0.2, 0.3, 0.1};
        List<Double> currents = Arrays.asList(readings);
        assertFalse(SensorValidator.validateCurrentreadings(currents));
    }
    @Test
    public void reportsErrorWhenCurrentIsNull()
    {
       List<Double> readings = null;
       assertFalse(SensorValidator.validateCurrentreadings(readings));
    }
    @Test
    public void reportsErrorWhenCurrentIsEmpty()
    {
       List<Double> readings = Collections.emptyList();
       assertFalse(SensorValidator.validateCurrentreadings(readings));
    }
    @Test
    public void reportsErrorWhenCurrentContainsNull()
    {
        Double[] readings = {0.03, 0.03, null, 0.33};
        List<Double> currents = Arrays.asList(readings);
        assertFalse(SensorValidator.validateCurrentreadings(currents));
    }
    @Test
    public void reportsErrorWhenCurrentContainsNaN()
    {
        Double[] readings = {0.03, 0.03, Double.NaN, 0.33};
        List<Double> currents = Arrays.asList(readings);
        assertFalse(SensorValidator.validateCurrentreadings(currents));
    }
    @Test
    public void reportsErrorWhenSOCIsNull()
    {
       List<Double> readings = null;
       assertFalse(SensorValidator.validateSOCreadings(readings));
    }
    @Test
    public void reportsErrorWhenSOCIsEmpty()
    {
       List<Double> readings = Collections.emptyList();
       assertFalse(SensorValidator.validateSOCreadings(readings));
    }
    @Test
    public void reportsErrorWhenSOCContainsNull()
    {
        Double[] readings = {0.03, 0.03, null, 0.33};
        List<Double> socs = Arrays.asList(readings);
        assertFalse(SensorValidator.validateSOCreadings(socs));
    }
    @Test
    public void reportsErrorWhenSOCContainsNaN()
    {
        Double[] readings = {0.03, 0.03, Double.NaN, 0.33};
        List<Double> socs = Arrays.asList(readings);
        assertFalse(SensorValidator.validateSOCreadings(socs));
    }
    @Test
    public void reportsSuccessWhenSOCSteady()
    {
        Double[] readings = {0.0, 0.05, 0.1, 0.15};
        List<Double> socs = Arrays.asList(readings);
        assertTrue(SensorValidator.validateSOCreadings(socs));
    }
    @Test
    public void reportsSuccessWhenCurrentSteady()
    {
        Double[] readings = {0.03, 0.13, 0.23, 0.33};
        List<Double> currents = Arrays.asList(readings);
        assertTrue(SensorValidator.validateCurrentreadings(currents));
    }
}
