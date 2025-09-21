package LeetCodeDaily;

import java.util.*;

public class ImplementRouter3508 {

    public static class Packet {
        int source;
        int destination;
        int timestamp;

        public Packet(int source, int destination, int timestamp) {
            this.source = source;
            this.destination = destination;
            this.timestamp = timestamp;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            Packet packet = (Packet) obj;
            return source == packet.source &&
                    destination == packet.destination &&
                    timestamp == packet.timestamp;
        }

        @Override
        public int hashCode() {
            return Objects.hash(source, destination, timestamp);
        }
    }

    Set<Packet> packetSet;
    Queue<Packet> packetQueue;
    Map<Integer, List<Integer>> destinationTimestampsMap;
    int limit;

    public ImplementRouter3508(int memoryLimit) {
        this.limit = memoryLimit;

        this.packetSet = new HashSet<>();
        this.packetQueue = new ArrayDeque<>();
        this.destinationTimestampsMap = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet packet = new Packet(source, destination, timestamp);

        if (packetSet.contains(packet)) return false;

        if (packetQueue.size() == limit) {
            Packet p = packetQueue.poll();
            packetSet.remove(p);

            List<Integer> timestamps = destinationTimestampsMap.get(p.destination);
            timestamps.removeFirst();
            if (timestamps.isEmpty()) destinationTimestampsMap.remove(p.destination);
        }
        packetSet.add(packet);
        packetQueue.offer(packet);
        destinationTimestampsMap.computeIfAbsent(destination, k -> new LinkedList<>());
        destinationTimestampsMap.get(destination).add(timestamp);

        return true;
    }

    public int[] forwardPacket() {
        if (packetQueue.isEmpty()) {
            return new int[0];
        }

        Packet packet = packetQueue.poll();
        packetSet.remove(packet);

        List<Integer> timestamps = destinationTimestampsMap.get(packet.destination);
        timestamps.removeFirst();
        if (timestamps.isEmpty()) {
            destinationTimestampsMap.remove(packet.destination);
        }

        return new int[]{ packet.source, packet.destination, packet.timestamp };
    }

    public int getCount(int destination, int startTime, int endTime) {
        if (!destinationTimestampsMap.containsKey(destination)) return 0;

        List<Integer> timestamps = destinationTimestampsMap.get(destination);
        int lowerBound = lowerBound(timestamps, startTime);
        int upperBound = upperBound(timestamps, endTime);
        return upperBound - lowerBound;
    }

    private int upperBound(List<Integer> timestamps, int target) {
        int start = 0;
        int end = timestamps.size();
        while (start < end) {
            int mid = (start + end) / 2;
            if (timestamps.get(mid) <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    private int lowerBound(List<Integer> timestamps, int target) {
        int start = 0;
        int end = timestamps.size();
        while (start < end) {
            int mid = (start + end) / 2;
            if (timestamps.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        ImplementRouter3508 router = new ImplementRouter3508(3);
        System.out.println(router.addPacket(1, 4, 90));
        System.out.println(router.addPacket(2, 5, 90));
        System.out.println(router.addPacket(1, 4, 90));
        System.out.println(router.addPacket(3, 5, 95));
        System.out.println(router.addPacket(4, 5, 105));
        System.out.println(Arrays.toString(router.forwardPacket()));
        System.out.println(router.addPacket(5, 2, 110));
        System.out.println(router.getCount(5, 100, 110));
    }
}
