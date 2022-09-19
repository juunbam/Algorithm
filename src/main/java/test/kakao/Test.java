package test.kakao;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Test {
	class failProb{
		double f;
		int s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String answer = "";
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
        HashMap<String, Integer> a = new HashMap<String, Integer>();

        for(int i=0;i<participant.length;i++){
            if(a.containsKey(participant[i])){
                a.put(participant[i], a.get(participant[i])+1);
            }
            else{
                a.put(participant[i], 1);
            }
        }
        for(int i=0;i<completion.length;i++) {
        	if(a.containsKey(completion[i])) {
        		if(a.get(completion[i])-1 == 0) {
        			a.remove(completion[i]);
        		}
        		else {
        			a.put(completion[i], a.get(completion[i])-1);
        		}
        	}
        }

        answer = (String) a.keySet().toArray()[0];
        System.out.println(answer);


//		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
//		int N = 5;
//
//		int[] answer = new int[N];
//
//		int[] stage_num=new int[N+2];
//
//		double[] fail=new double[N+2];
//		double[] fail2=new double[N+2];
//		for(int i=0;i<stages.length;i++) {
//			stage_num[stages[i]]++;
//		}
//		for(int i=1;i<stage_num.length-1;i++) {
//			int tot=0;
//			for(int j=i;j<stage_num.length;j++) {
//				tot+=stage_num[j];
//			}
//			if(stage_num[i]!=0) {
//				fail[i] = (double) stage_num[i]/tot;
//				fail2[i] = fail[i];
//			}
//			else {
//				fail[i] = 0.0;
//				fail2[i] = 0;
//			}
//		}
//
//		int max_index=0;
//		double max=0.0;
//		Arrays.sort(fail2);
//		int k=0;
//		for(int i=0;i<fail2.length;i++) {
//			System.out.println(fail2[i]);
//		}
//		for(int j=fail2.length-1;j>1;j--) {
//			for(int i=1;i<fail.length-1;i++){
//				if(fail[i] == fail2[j]) {
//					answer[k] = i;
//					fail[i]=-1.0;
//					k++;
//					break;
//				}
//			}
//		}
//		for(int i=0;i<N;i++)
//			System.out.println(answer[i]);
	}
}
