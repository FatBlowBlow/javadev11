package ca.bytetube._13_greedy;

import java.util.Arrays;
import java.util.Comparator;

public class ArrangeMeeting {


    public static class Meeting{
        public int start;
        public int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


    public static int arrangeMeeting(int[] starts, int[] ends, int current){//current可以开启下一个会议的时间点
        Meeting[] meetings = meetingsCreate(starts, ends);
        Arrays.sort(meetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting m1, Meeting m2) {
                return m1.end - m2.end;//结束时间较早排序
            }
        });

        int count = 0;
        for (int i = 0; i < meetings.length; i++) {
            if (current <= meetings[i].start) {
                count++;
                current = meetings[i].end;
            }
        }
        return count;
    }



    private static Meeting[] meetingsCreate(int[] starts, int[] ends){
        Meeting[] meetings = new Meeting[starts.length];
        for (int i = 0; i < meetings.length ; i++) {
            meetings[i] = new Meeting(starts[i], ends[i]);
        }
        return meetings;
    }
}
