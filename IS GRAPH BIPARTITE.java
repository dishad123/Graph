class Solution {
    public boolean isBipartite(int[][] g) {
        int[] colors = new int[g.length];
        for (int i = 0; i < g.length; i++)
            if (colors[i] == 0 && !validColor(g, colors, 1, i))
                return false;
        return true;
    }

    boolean validColor(int[][] g, int[] colors, int color, int node) {
        if (colors[node] != 0) //already visited
            return colors[node] == color; //checking with the matched color
        colors[node] = color; else colouring with the fav color
        for (int adjacent : g[node]) //coloring the adjacent nodes
            if (!validColor(g, colors, -color, adjacent)) // coloring with the opposite color 
                return false;
        return true;
    }
}

Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
Output: false
Explanation: There is no way to partition the nodes into two independent sets such that every edge connects a node in one and a node in the other.

Input: graph = [[1,3],[0,2],[1,3],[0,2]]
Output: true
Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.
