class Solution {
    
    public class Node{
        int x;
        int y;
        Node(int a,int b) {x=a;y=b;}
        
        @Override
        public boolean equals(Object obj)
        { 
            return (((Node) obj).x == this.x)&&(((Node) obj).y == this.y);
        }
        
        @Override
        public int hashCode(){
            return Objects.hash(x,y);
        }

    }
    
    public int minAreaRect(int[][] points) {
        int min=Integer.MAX_VALUE;
        Set<Node> ptset = new HashSet<>();
        for(int i=0;i<points.length;i++)
            ptset.add(new Node(points[i][0],points[i][1]));
        for(int i=0;i<points.length;i++)
            for(int j=i+1;j<points.length;j++)
            {
                int x1= points[i][0];
                int y1= points[i][1];
                int x2= points[j][0];
                int y2= points[j][1];
                Node pt3 = new Node(x1,y2);
                Node pt4 = new Node(x2,y1);
                if(ptset.contains(pt3) && ptset.contains(pt4))
                {   int area= Math.abs(x1-x2)*Math.abs(y1-y2);
                    
                    if(min>area && area!=0)
                        min=area;
                }
            }
        return (min==Integer.MAX_VALUE ? 0:min);
    }
}