package com.advent2024.Day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Day1b {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("E:\\Projects\\AdventCode\\AdventCode2024\\Java\\advent-code\\src\\main\\java\\com\\advent2024\\Day1\\input.txt"));
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        for(String line: strings){
            String[] split = line.split("\\s+");
            leftList.add(Integer.valueOf(split[0]));
            rightList.add(Integer.valueOf(split[1]));
        }

        long result = leftList.stream().mapToLong(leftVal -> {
            long occurrence = rightList.stream().filter(val -> Objects.equals(val, leftVal)).count();
            return leftVal * occurrence;
        }).sum();

        /*leftList.sort(Comparator.naturalOrder());
        rightList.sort(Comparator.naturalOrder());

        long result = IntStream.range(0, leftList.size())
                .mapToLong(index -> Math.abs(rightList.get(index) - leftList.get(index)))
                .sum();*/

        System.out.println(result);


    }
}
