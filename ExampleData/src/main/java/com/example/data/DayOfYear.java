package com.example.data;

import org.junit.Test;
import java.util.Scanner;
public class DayOfYear {
    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            int t=0;
            System.out.println("请输入年月bai日：");
            int year=sc.nextInt();
            int month=sc.nextInt();
            int day=sc.nextInt();
            switch(month) {
                case 1:t=day;
                    break;
                case 2:t=31+day ;
                    break;
                case 3:t=31+28+day;
                    break;
                case 4:t=31+28+31+day;
                    break;
                case 5:t=31+28+31+30+day;
                    break;
                case 6:t=31+28+31+30+31+day;
                    break;
                case 7:t=31+28+31+30+31+30+day;
                    break;
                case 8:t=31+28+31+30+31+30+31+day;
                    break;
                case 9:t=31+28+31+30+31+30+31+31+day;
                    break;
                case 10:t=31+28+31+30+31+30+31+31+30+day;
                    break;
                case 11:t=31+28+31+30+31+30+31+31+30+31+day;
                    break;
                case 12:t=31+28+31+30+31+30+31+31+30+31+30+day;
                    break;
                default:
                    System.out.println("出错du了");
            }
            if (year%4==0&&year!=0&&month>=3)
            {t += 1;}
            System.out.println("你输入的zhi日期是这一dao年的第:"+t+"天");
    }

}
