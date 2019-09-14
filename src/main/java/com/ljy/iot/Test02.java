package com.ljy.iot;

import java.util.Scanner;

/**
 * @author : 夕
 * @date : 2019/9/11
 */
public class Test02 {
    public static void main(String[] args) {

        String[] skills1 = {"东风破","时空穿梭","元气炮"};
        String[] skills2 = {"虚空清道","湮灭之锁","轮回吞噬"};

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入参战者1");
        String player1 = scanner.nextLine();


        System.out.println("请输入参战者2");
        String player2 = scanner.nextLine();

        int lifeValue1 = 100;
        int lifeValue2 = 100;

        int attack1 = 0;
        int attack2 = 0;

        System.out.println("------GO------");
        while (true){
            if(lifeValue1 < 0 || lifeValue2 < 0) {
                break;
            }
            int r1 = (int) (Math.random()*3);
            int r2 = (int) (Math.random()*3);

            attack1 = (int) (Math.random()*100000%11+5);
            attack2 = (int) (Math.random()*100000%11+5);

            if(attack1%3 == 0){
                attack1 = 0;
                System.out.println(player1 + "技能被"+ player2+ "躲避" );
            }else if(attack2%2 == 0){
                attack2 = 0;
                System.out.println(player2 + "技能被"+ player1+ "躲避" );
            }
            if(attack1%3 == 0 || attack2%3 ==0){
                attack1 = (int) (Math.random()*100000%11+5);
                attack2 = (int) (Math.random()*100000%11+5);
            }
            lifeValue2 -= attack1;
            System.out.println(player1+"发出："+skills1[r1] + " " + player2 + "被干掉" + attack1 + "滴血");

            lifeValue1 -= attack2;
            System.out.println(player2+"发出："+skills2[r1] + " " + player1 + "被干掉" + attack1 + "滴血");


        }
        if(lifeValue1 < 0 || lifeValue2>=0){
            System.out.println("WINNER IS " + player2);
        }else {
            System.out.println("WINNER IS " + player1);
        }
        System.out.println(player1 + " 剩余血量："+lifeValue1);
        System.out.println(player2 + " 剩余血量："+lifeValue2);
    }

}
