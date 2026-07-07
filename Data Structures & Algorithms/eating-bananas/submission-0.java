class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left =1;
        int right = Arrays.stream(piles).max().getAsInt();
        int mintime = right;

        while(left<=right){
            int k = (left+right)/2;

            int total=0;
            for(int p: piles){
                total+= Math.ceil((double)p/k); //-> if you dont do double
                //p/k will give int ignoring the decimal and you'll lose the 2nd+ hours
            }

            if(total>h) //-> inc number of banana eating per hour(k)
                left = k+1;
            else{
                mintime = k; //if time is less than h, its a potential
                //min time, store it
                right=k-1;
            }
        }
        return mintime;
        
    }
}
