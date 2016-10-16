package misc;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    
    class Stat {
        String category;
        int frequency;
        
        public Stat(String category, int frequency) {
            this.category = category;
            this.frequency = frequency;
        }
        
        @Override
        public boolean equals(Object o) {
            if(o instanceof Stat) {
                Stat other = (Stat) o;
                return this.category.equals(other.category);
            }
            return false;
        }
        
        @Override
        public String toString() {
            return String.format("%s: %d", category, frequency);
        }
    }
    
    class Date {
        String year;
        int yearNum;
        String month;
        int monthNum;
        String day;
        int dayNum;
        
        public Date(String year, String month, String day) {
            this.year = year;
            this.month = month;
            this.day = day;
            this.yearNum = Integer.parseInt(year);
            this.monthNum = Integer.parseInt(month);
            this.dayNum = Integer.parseInt(day);
        }
        
        boolean isEarlierThan(Date other) {
            return (this.yearNum < other.yearNum) ||
                   (this.yearNum == other.yearNum && this.monthNum < other.monthNum) ||
                   (this.yearNum == other.yearNum && this.monthNum == other.monthNum && this.dayNum < other.dayNum);
        }
        
        @Override
        public boolean equals(Object o) {
            if(o instanceof Date) {
                Date other = (Date) o;
                return this.yearNum == other.yearNum && this.monthNum == other.monthNum;
            }
            return false;
        }
        
        @Override
        public String toString() {
            return String.format("%s-%s", year, month);
        }
    }
    
    Date convertStringToDate(String s) {
        String[] split = s.split("-");
        String year = split[0];
        String month = split[1];
        String day = (split.length == 3) ? split[2] : "-1";
        return new Date(year, month, day);
    }
    
    boolean dateInRange(Date start, Date end, Date date) {
        return start.isEarlierThan(date) && date.isEarlierThan(end);
    }
    
    String formatEntry(Entry<Date, Map<String, Integer>> entry) {
        StringBuilder output = new StringBuilder();
        output.append(entry.getKey());
        for(Entry<String, Integer> stat : entry.getValue().entrySet()) {
            output.append(String.format(", %s, %d", stat.getKey(), stat.getValue()));
        }
        return output.toString();
    }
    
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Solution s = new Solution();
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("\n");
        String firstLine = scan.next();
        String[] ranges = firstLine.split(",");
        Date start = s.convertStringToDate(ranges[0]);
        Date end = s.convertStringToDate(ranges[1]);
        
        Map<Date, Map<String, Integer>> input = new TreeMap<>(new Comparator<Date>() {

            @Override
            public int compare(Date d1, Date d2) {
                int yCompare = Integer.compare(d2.yearNum, d1.yearNum);
                if(yCompare != 0) {
                    return yCompare;
                } else {
                    return Integer.compare(d2.monthNum, d1.monthNum);
                }
            }
            
        });
        
        while(scan.hasNext()) {
            String line = scan.next();
            String[] split = line.split(",");
            Date date = s.convertStringToDate(split[0]);
            if(s.dateInRange(start, end, date)) {
                String category = split[1].trim();
                int frequency = Integer.parseInt(split[2].trim());
                if(input.containsKey(date)) {
                    int newFrequency = input.get(date).getOrDefault(category, 0) + frequency;
                    input.get(date).put(category, newFrequency);
                } else {
                    Map<String, Integer> stats = new TreeMap<>();
                    stats.put(category, frequency);
                    input.put(date, stats);
                }
            }
            
            for(Entry<Date, Map<String, Integer>> entry : input.entrySet()) {
                System.out.println(s.formatEntry(entry));
            }
        }
        
        scan.close();
    }
}