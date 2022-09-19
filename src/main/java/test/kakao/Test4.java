package test.kakao;

public class Test4 {

	public static int min(int n[]) {
	    int min = n[0];

	    for (int i = 1; i < n.length; i++)
	      if (n[i] < min) min = n[i];

	    return min;
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] food_times = {3, 1, 2};
		long k = 5;
		int answer = 0;
        int tot=0;
        for(int i=0;i<food_times.length;i++)
            tot+=food_times[i];
        if(tot<=k){
            System.out.println(-1);;
        }
        int min = min(food_times);
        if(k/food_times.length >= min) {
        	int last=0;
        	for(int i=(int) (k*food_times.length);i<k;i++){
                int j=last;
                while(true){
                    if(food_times[j%food_times.length]!=0){
                        food_times[j%food_times.length]--;
                        last=j%food_times.length+1;
                        System.out.println(food_times+" "+last);
                        break;
                    }
                    else{
                        j++;
                    }
                }
            }
        }
        answer++;
        System.out.println(answer);
	}

}
