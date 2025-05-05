class RandomizedCollection {
     List<Integer> list = new LinkedList<>();
    public RandomizedCollection() {

    }
    
    public boolean insert(int val) {
     if(list.contains(val)){
        list.add(val);
        return false;
        }
        else{
            list.add(val);
        }
     return true; 

    }
    
    public boolean remove(int val) {
       return list.remove(Integer.valueOf(val)); 
    }
    
    public int getRandom() {
        if(list.isEmpty()){return -1;}
        Random rand = new Random();
        int index = (rand.nextInt(list.size()));
        return list.get(index);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */