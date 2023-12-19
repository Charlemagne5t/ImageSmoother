public class Solution {
    public int[][] imageSmoother(int[][] img) {
        int[][] ans = new int[img.length][img[0].length];

        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                smooth(img, ans, i, j);
            }
        }
        return ans;
    }
    private void smooth(int[][] img, int[][] ans, int i, int j){
        int m = img.length;
        int n = img[0].length;
        int count = 1;
        double value = (double) img[i][j];
        if(i > 0 && j > 0){
            value = value + img[i - 1][j - 1];
            count++;
        }
        if(i > 0){
            value = value + img[i - 1][j];
            count++;
        }
        if(i > 0 && j < n - 1){
            value = value + img[i - 1][j + 1];
            count++;
        }
        if(j < n - 1){
            value = value + img[i][j + 1];
            count++;
        }

        if(i < m - 1 && j < n - 1){
            value = value + img[i + 1][j + 1];
            count++;
        }
        if(i < m - 1){
            value = value + img[i + 1][j];
            count++;
        }
        if(i < m - 1 && j > 0){
            value = value + img[i + 1][j - 1];
            count++;
        }
        if(j > 0){
            value = value + img[i][j - 1];
            count++;
        }

        ans[i][j] = (int)(value / count);
    }
}
