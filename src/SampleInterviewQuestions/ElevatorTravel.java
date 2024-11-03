package SampleInterviewQuestions;

public class ElevatorTravel {
    public static int elevatorDistance(int[] requests, int capacity) {
        // Initialize current floor to 0 and total distance to 0
        int currentFloor = 0;
        int totalDistance = 0;

        // We only process up to the elevator's capacity
        int numberOfRequests = Math.min(requests.length, capacity);

        // Iterate through each requested floor up to the elevator's capacity
        for (int i = 0; i < numberOfRequests; i++) {
            // Add the absolute difference between current floor and requested floor
            totalDistance += Math.abs(requests[i] - currentFloor);
            // Update the current floor to the requested floor
            currentFloor = requests[i];
        }

        return totalDistance;
    }

    public static void main(String[] args) {
        // Example usage
        int[] requests = {3, 2, 6, 4, 7};  // Floors the elevator needs to visit
        int capacity = 3;  // Elevator can only handle 3 requests at a time

        // This will only consider the first 3 requests {3, 2, 6}
        System.out.println("Total distance traveled: " + elevatorDistance(requests, capacity));
    }
}
