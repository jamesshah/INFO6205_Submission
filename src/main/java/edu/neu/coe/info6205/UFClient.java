package edu.neu.coe.info6205;
import edu.neu.coe.info6205.union_find.UF_HWQUPC;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class UFClient {

    public static int count(int n){
        UF_HWQUPC obj1 = new UF_HWQUPC(n, true);
        int count = 0;
        while (obj1.components() != 1) {
            int random_i = ThreadLocalRandom.current().nextInt(0, n);
            int random_j = ThreadLocalRandom.current().nextInt(0, n);
            if (!obj1.connected(random_i, random_j))
                obj1.union(random_i, random_j);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Please enter number of sites(n): ");
//        int n = sc.nextInt();
        int[] ns = {8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384};
        for (int n : ns) {
            int totalConnections = count(n);
            System.out.println("n:" + n + " Total connections generated: " + totalConnections);
        }
    }
}
