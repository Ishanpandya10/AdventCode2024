package com.advent2024.Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3a {
    public static void main(String[] args) throws IOException {
        String lines = Files.readString(Paths.get("E:\\Projects\\AdventCode\\AdventCode2024\\Java\\advent-code\\src\\main\\java\\com\\advent2024\\Day3\\input.txt"));
        System.out.println(lines);

        Pattern pattern = Pattern.compile("mul\\(\\d+,\\d+\\)");
        Matcher matcher = pattern.matcher(lines);
        long result = 0;
        while (matcher.find()) {
            String group = matcher.group();
            int start = matcher.start();
            int end = matcher.end();
            System.out.println(group + " " + start + " " + end);

            String numbVal = group.replace("mul(", "").replace(")","");
            String[] split = numbVal.split(",");
            int res = Math.multiplyExact(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            result += res;
        }

        System.out.println(result);
    }
}
