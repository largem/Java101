package net.largem.codewar.kata.c20190423;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.codewars.com/kata/thinkful-logic-drills-traffic-light?utm_source=newsletter&utm_medium=email&utm_campaign=weekly_coding_challenges&utm_term=2019-07-07
 * You're writing code to control your town's traffic lights. You need a function to handle each change from green, to yellow, to red, and then to green again.
 *
 * Complete the function that takes a string as an argument representing the current state of the light and returns a string representing the state the light should change to.
 *
 * For example, update_light('green') should return 'yellow'.
 */
public class TrafficLights {
    private static Map<String, String> TrafficLightStateMap = new HashMap<>();
    static {
        TrafficLightStateMap.put("green", "yellow'");
        TrafficLightStateMap.put("yellow", "red");
        TrafficLightStateMap.put("red", "green");
    }

    public static String updateLight(String current) {
        return TrafficLightStateMap.get(current);
    }
}