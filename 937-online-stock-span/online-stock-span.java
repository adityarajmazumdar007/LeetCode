class Pair{
    int value;
    int span;
    public Pair(int value,int span){
        this.value=value;
        this.span=span;
    }
}
class StockSpanner {
    Stack<Pair> st = new Stack<>();
    public StockSpanner() {
        
    }
    
    public int next(int price) {
        int newSpan=1;
        while(st.size()!=0 && st.peek().value<=price){
            newSpan+=st.pop().span;
        }
        st.push(new Pair(price,newSpan));
        return newSpan;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */