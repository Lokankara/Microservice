package com.stack.number;

import static com.stack.number.TrafficColor.RED;

public class TrafficLight {

    private TrafficLight() {
    }

    public static long countRedLights(TrafficColor[] trafficLights) {
        int count = 0;
        if (trafficLights != null) {
            for (TrafficColor light : trafficLights) {
                if (light == null) {
                    return 0;
                }
                if (RED.equals(light)) {
                    count++;
                }
            }
        }
        return count;
    }
}
