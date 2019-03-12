package scs.Triangle;

import java.util.ArrayList;


public class Triangle {
    public static ArrayList<Integer> getMoney(int money){
        int[] avil = {1,1,2,3};
        ArrayList<Integer> compose = new ArrayList<>();
        while (money>=0)
        { if(money==0)
        {
            return compose;
        }
        else if(money>=50&&avil[0]>=1)
        {
            money = money-50;
            compose.add(50);
            avil[0]--;
        }
        else if(money>=20&&money<=50&&avil[1]>=1)
        {
            money = money-20;
            compose.add(20);
            avil[1]--;
        }
        else if(money>=5&&avil[2]>=1)
        {
            money = money-5;
            compose.add(5);
            avil[2]--;
        }
        else if(money>=1&avil[3]>=1)
        {
            money = money-1;
            compose.add(1);
            avil[3]--;
        }else {
            System.out.println("input error");
            compose.clear();
            break;
        }
        }
        return compose;
    }
//    public static void main(String[] args){
//        while(true) {
//            ArrayList<Integer> com = new ArrayList<>();
//            Scanner sc = new Scanner(System.in);
//            System.out.println("input your money: ");
//            int money = sc.nextInt();
//            com = getMoney(money);
//
//            for (int i : com) {
//                System.out.println(i);
//            }
//        }
//
//    }
}
