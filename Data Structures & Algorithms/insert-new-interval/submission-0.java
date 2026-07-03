class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        ArrayList<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        int i =0;
            
            //add all intervals that come befor newInterval
            while(i< intervals.length && newInterval[0]>intervals[i][1]){ //means intervals[i][1]
            //is before new interval so just add to ans
            
            ans.add(intervals[i]);
            i++;
            }
                while(i<intervals.length && intervals[i][0] <= newInterval[1]){
                    //merge -> The current interval starts before
                    // the new interval has completely finished.

                    newInterval[0]= Math.min(intervals[i][0],newInterval[0] );
                    newInterval[1] = Math.max(intervals[i][1],newInterval[1] );
                    i++;
                }
                ans.add(newInterval);

            //add all remaining intervals left after merging

            while(i<intervals.length){
            ans.add(intervals[i]);
            i++;
            }

        return ans.toArray(new int[ans.size()][]);
        
    }
}
