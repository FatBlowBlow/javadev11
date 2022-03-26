package ca.bytetube.day20_review;

import java.util.Scanner;

/**
 * 90~100 excellent
 * 80~89 very good
 * 70~79 good
 * 60~69 pass
 * <60 fail
 */
public class IfDemo {

    public static void main(String[] args) throws Exception {
        System.out.println(grading(getScore()));

    }

    public static Double getScore (){
        System.out.println("please input your score: ");
        return new Scanner(System.in).nextDouble();
    }

    public static String grading (Double score) throws Exception {
        if (score < 0 || score > 100) throw new Exception("error score");
        if (score >= 90 && score <= 100) return "excellent";
        else if (score >= 80 && score < 90) return "very good";
        else if (score >= 70 && score < 80) return "good";
        else if (score >= 60 && score < 70) return "pass";
        else return "fail";
    }
}
