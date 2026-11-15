/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return helper(grid, 0, 0, grid.length);
    }
    
    private Node helper(int[][] grid, int r, int c, int length) {
        // Check if all cells in the current region are the same
        boolean isUniform = true;
        int val = grid[r][c];
        
        for (int i = r; i < r + length; i++) {
            for (int j = c; j < c + length; j++) {
                if (grid[i][j] != val) {
                    isUniform = false;
                    break;
                }
            }
            if (!isUniform) {
                break;
            }
        }
        
        // If uniform, return a leaf node
        if (isUniform) {
            return new Node(val == 1, true);
        }
        
        // If not uniform, create an internal node and divide into 4 quadrants
        Node node = new Node(true, false); // val can be true/false for internal nodes
        int mid = length / 2;
        
        node.topLeft = helper(grid, r, c, mid);
        node.topRight = helper(grid, r, c + mid, mid);
        node.bottomLeft = helper(grid, r + mid, c, mid);
        node.bottomRight = helper(grid, r + mid, c + mid, mid);
        
        return node;
    }
}