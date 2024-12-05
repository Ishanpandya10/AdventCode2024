package com.advent2024.Day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day2a {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("E:\\Projects\\AdventCode\\AdventCode2024\\Java\\advent-code\\src\\main\\java\\com\\advent2024\\Day2\\input.txt"));
        int safeReportCount = 0;
        for (String line : lines) {
            String[] reports = line.split("\\s+");
            String order = "";
            boolean flag = true;
            for (int r = 0; r < reports.length - 1; r++) {
                int diff = Integer.parseInt(reports[r]) - Integer.parseInt(reports[r + 1]);
                if (Math.abs(diff) > 3 || diff == 0) {
                    flag = false;
                    break;
                } else {
                    String currOrder = diff > 0 ? "decreasing" : "increasing";
                    if (order.isEmpty()) {
                        order = currOrder;
                    } else if (!order.equals(currOrder)) {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) ++safeReportCount;
            System.out.println(flag);
        }
        System.out.println(safeReportCount);
    }
}
