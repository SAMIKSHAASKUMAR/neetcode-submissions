class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int arr[] = new int[k];

        for(int i: nums){
            int val = map.getOrDefault(i, 0);
            map.put(i, val+1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> Integer.compare(map.get(a), map.get(b)));

        for(Integer key: map.keySet()){
            queue.add(key);

            //first add and then remove the min freq element
            if(queue.size()>k)
                queue.poll();
            
        }

        for(int j=0;j<k;j++){ //it should be k and not queue.size()
        //cause once poll happend, queue.size() changes dynamicaaly
        //and your code fails
        arr[j] = queue.poll();
       }
        
        return arr;
        
        
    }
}
