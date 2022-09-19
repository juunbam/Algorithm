package ds.dfsbfs;

import java.util.Arrays;

public class Solution6 {

    public static void find(double[] n, double total, String result) {
        if (total == 0)
            System.out.println(result);
        if (total > 0) {
            for (int i = n.length - 1; i >= 0; i--) {
                find(Arrays.copyOfRange(n, 0, i + 1), total - n[i], result + n[i] + " ");
            }
        }
    }

    public static void main(String[] args) {

        double[] n = { 8.0, 13.5, 14.0, 15.0, 17.0, 18.0, 20.0, 24.0, 25.0,
                28.0, 32.0, 34.0, 35.0, 38.0, 39.5,
                40.0, 45.0, 48.0, 49.0, 49.5, 50.0, 52.0, 55.0,
                58.0, 59.0, 59.5, 60.0, 62.99, 64.0, 64.5, 65.0, 66.0, 68.0, 69.0, 69.5,
                70.0, 72.0, 74.0, 74.99, 75.0, 76.0, 78.0, 79.0, 79.5, 80.0, 85.0,
                88.0, 89.5, 90.0, 95.0, 98.0, 98.5, 99.5, 100.0, 100.8, 102.0,
                105.0, 106.0, 108.5, 109.0, 110.0, 115.0, 116.0, 118.0, 120.0, 122.0,
                124.0, 125.0, 126.0, 128.0, 130.0, 134.99, 135.0, 140.0, 145.0,
                148.0, 150.0, 155.0, 160.0, 165.0, 168.0, 170.0, 175.0,
                178.0, 180.0, 185.0, 188.0, 189.99, 190.0, 195.0, 198.0, 200.0,
                210.0, 215.0, 220.0, 225.0, 228.0, 230.0, 240.0,
                245.0, 248.0, 250.0, 255.0, 265.0, 268.0, 270.0, 275.0, 280.0,
                290.0, 295.0, 298.0};
        double total = 300;

        Solution6.find(n, total, "");
    }

}

//https://www.ralphlauren.com/women/sale?ab=en_US_SLP_Slot_1_S1_L2_SHOP&srule=women-sale&viewallproducts=true