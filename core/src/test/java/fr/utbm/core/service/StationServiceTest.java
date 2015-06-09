package fr.utbm.core.service;

import fr.utbm.core.entity.Station;
import java.util.List;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class StationServiceTest
        extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public StationServiceTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(StationServiceTest.class);
    }
    
    public void testGetStations(){
       StationService ss = new StationService();
       List<Station> res = ss.getAllStations();
        assertTrue(res instanceof List);
    }
}
