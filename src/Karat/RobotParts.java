package Karat;

import java.util.*;

public class RobotParts {
    public static ArrayList<String> getRobots(String[] allParts, String requiredParts) {
        HashMap<String, ArrayList<String>> robotPartsMap = getRobotsPartsMap(allParts);

        List<String> parts = Arrays.asList(requiredParts.split(","));

        ArrayList<String> result = new ArrayList<>();

        for(Map.Entry<String, ArrayList<String>> entry: robotPartsMap.entrySet()) {
            ArrayList<String> currentParts = entry.getValue();

            if (currentParts.containsAll(parts)) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    public static HashMap<String, ArrayList<String>> getRobotsPartsMap(String[] allParts) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < allParts.length; i++) {
            String current = allParts[i];

            List<String> splitted = Arrays.asList(current.split("_"));

            if (!map.containsKey(splitted.get(0))) {
                ArrayList<String> part = new ArrayList<>();
                part.add(splitted.get(1));
                map.put(splitted.get(0), part);
            } else {
                map.get(splitted.get(0)).add(splitted.get(1));
            }
        }

        return map;
    }

    public static void main(String[] argv) {
        String required_parts_1 = "sensors,case,speaker,wheels";
        String required_parts_2 = "sensors,case,speaker,wheels,claw";
        String required_parts_3 = "sensors,case,screws";

        String[] all_parts = {
                "Rosie_claw",
                "Rosie_sensors",
                "Dustie_case",
                "Optimus_sensors",
                "Rust_sensors",
                "Rosie_case",
                "Rust_case",
                "Optimus_speaker",
                "Rosie_wheels",
                "Rosie_speaker",
                "Dustie_case",
                "Dustie_arms",
                "Rust_claw",
                "Dustie_case",
                "Dustie_speaker",
                "Optimus_case",
                "Optimus_wheels",
                "Rust_legs",
                "Optimus_sensors"};

        System.out.println(getRobots(all_parts, required_parts_1));
        System.out.println(getRobots(all_parts, required_parts_2));
        System.out.println(getRobots(all_parts, required_parts_3));
    }
}
