package com.stack.number;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.stack.number.TrafficColor.*;
import static com.stack.number.TrafficLight.countRedLights;

public class TrafficLightTest {

    @Test(dataProvider = "trafficLightData")
    public void testCountRedLightsWithValidTrafficLightData(
            TrafficColor[] trafficLights, int expectedCount) {
        Assert.assertEquals(countRedLights(trafficLights), expectedCount);
    }

    @Test(dataProvider = "invalidTrafficLightData")
    public void testCountWithInvalidTrafficLightData(
            TrafficColor[] trafficLights, int expectedCount) {
        Assert.assertEquals(countRedLights(trafficLights), expectedCount);
    }
    @DataProvider(name = "trafficLightData")
    public static Object[][] trafficLightData() {
        return new Object[][]{
                {new TrafficColor[]{RED, GREEN, YELLOW, RED, GREEN, RED}, 3},
                {new TrafficColor[]{GREEN, GREEN, YELLOW, RED, GREEN, GREEN}, 1},
                {new TrafficColor[]{RED, RED, RED, RED, RED, RED}, 6}
        };
    }

    @DataProvider(name = "invalidTrafficLightData")
    public static Object[][] invalidTrafficLightData() {
        return new Object[][]{
                {null, 0},
                {new TrafficColor[]{}, 0},
                {new TrafficColor[]{null}, 0},
                {new TrafficColor[]{RED, null, RED}, 0},
                {new TrafficColor[]{null, RED, RED}, 0},
                {new TrafficColor[]{GREEN, GREEN, YELLOW, YELLOW, GREEN, GREEN}, 0},
        };
    }
}
