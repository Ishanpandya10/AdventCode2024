package com.advent2024.Day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day2b {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("E:\\Projects\\AdventCode\\AdventCode2024\\Java\\advent-code\\src\\main\\java\\com\\advent2024\\Day2\\input.txt"));
        int safeReportCount = 0;
        for (String line : lines) {
            String[] reportValues = line.split("\\s+");
            String order = "";
            // boolean flag = true;
            List<Boolean> flags = getSafeReportFlags(reportValues, order);
            long count = getUnsafeFlagCount(flags);

            System.out.print(line + " " + flags);
            if (count > 0) {

                //int unSafeIndex = getFirstUnSafeIndex(flags);
                for (int i = 0; i < reportValues.length; i++) {
                    List<String> subRepValues = new ArrayList<>(Arrays.asList(reportValues));
                    subRepValues.remove(i);

                    List<Boolean> updateSafeFlags = getSafeReportFlags(subRepValues.toArray(String[]::new), order);
                    long unsafeFlagCount = getUnsafeFlagCount(updateSafeFlags);
                    if(unsafeFlagCount == 0){
                        ++safeReportCount;
                         System.out.print(": Safe \n");
                        break;
                    } else {
                        System.out.println(": Unsafe:"+ subRepValues+ " - " +updateSafeFlags);
                    }
                }
            } else {
                if (count == 0) {
                    ++safeReportCount;
                    System.out.print(": Safe \n");
                } else {
                    System.out.println();
                }
            }


        }
        System.out.println("\n " + safeReportCount);
    }

    private static long getUnsafeFlagCount(List<Boolean> flags) {
        return flags.stream().filter(val -> !val).count();
    }

    private static int getFirstUnSafeIndex(List<Boolean> flags) {
        return flags.indexOf(false);
    }

    private static List<Boolean> getSafeReportFlags(String[] reports, String order) {
        List<Boolean> flags = new ArrayList<>();
        for (int r = 0; r < reports.length - 1; r++) {
            int diff = Integer.parseInt(reports[r]) - Integer.parseInt(reports[r + 1]);
            if (Math.abs(diff) > 3 || diff == 0) {
                //flag = false;
                flags.add(false);
                //break;
            } else {
                String currOrder = diff > 0 ? "decreasing" : "increasing";
                if (order.isEmpty()) {
                    order = currOrder;
                    flags.add(true);
                } else if (!order.equals(currOrder)) {
                    flags.add(false);
                } else {
                    flags.add(true);
                }
            }
        }
        return flags;
    }
}
