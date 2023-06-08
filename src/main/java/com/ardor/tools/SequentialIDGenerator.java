package com.ardor.tools;

import java.util.UUID;

// UUID 생성후 8자로 줄인뒤 자동증가시키는 클래스(고유식별자 생성용)
public class SequentialIDGenerator {
	private static final int SHORT_UUID_LENGTH = 8;
    private static long sequence = 0;

    public static String generateSequentialID() {
        UUID uuid = UUID.randomUUID();
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();

        // Increase the sequence
        sequence++;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SHORT_UUID_LENGTH; i++) {
            long value;
            if (i < 4) {
                value = mostSignificantBits & 0x3F;
                mostSignificantBits >>= 6;
            } else {
                value = leastSignificantBits & 0x3F;
                leastSignificantBits >>= 6;
            }
            sb.append((char) ('0' + value));
        }

        // Append the sequence
        sb.append(String.format("%04d", sequence % 10000));

        return sb.toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String sequentialID = generateSequentialID();
            System.out.println(sequentialID);
        }
    }
}
