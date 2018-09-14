package day04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Test05_Doudizhu {
    public static void main(String[] args) {
        HashMap<Integer,String> poker = new HashMap<>();
        ArrayList<Integer> pokerIndex = new ArrayList<>();

        String[] colors = {"♠","♥","♣","♦"};
        String[] numbers = {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};

        int key = 0;
        poker.put(key,"大王");
        pokerIndex.add(key);
        key++;

        poker.put(key,"小王");
        pokerIndex.add(key);
        key++;

        for(String num : numbers){
            for(String color : colors){
                poker.put(key,color+num);
                pokerIndex.add(key);
                key++;
            }
        }

        Collections.shuffle(pokerIndex);

        //System.out.println(pokerIndex);
        ArrayList<Integer> player01 = new ArrayList<>();
        ArrayList<Integer> player02 = new ArrayList<>();
        ArrayList<Integer> player03 = new ArrayList<>();
        ArrayList<Integer> player04 = new ArrayList<>();

        for (Integer i : pokerIndex) {
            Integer in = pokerIndex.get(i);

            if(i >= 51){
                player04.add(in);
            }
            else if(i%3 == 0){
                player01.add(in);
            }
            else if(i%3 == 1){
                player02.add(in);
            }
            else if(i%3 == 2){
                player03.add(in);
            }
        }

        Collections.sort(player01);
        Collections.sort(player02);
        Collections.sort(player03);
        Collections.sort(player04);

        getCard("楚云飞",poker,player01);
        getCard("李云龙",poker,player02);
        getCard("二营长",poker,player03);
        getCard("底牌",poker,player04);
    }
    public static void getCard(String name,HashMap<Integer,String> map,ArrayList<Integer> list){
        System.out.print(name+":");
        for (Integer i : list) {
            System.out.print(map.get(i)+" ");
        }
        System.out.println();
    }
}
