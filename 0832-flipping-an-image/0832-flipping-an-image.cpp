class Solution {
public:
    vector<vector<int>> flipAndInvertImage(vector<vector<int>>& image) {
        
        
        for(int idx = 0; idx < image.size(); idx++){
            reverse(image[idx].begin(), image[idx].end());
            
            for(int jdx = 0; jdx < image[0].size(); jdx++){
                if(image[idx][jdx] == 0)
                    image[idx][jdx] = 1;
                else
                    image[idx][jdx] = 0;
            }
        }
        
        return image;
    }
};