// There are N students in a class. Some of them are friends, while some are not. Their friendship
// is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of
// C, then A is an indirect friend of C. And we defined a friend circle is a group of students who
// are direct or indirect friends.

// Given a N*N matrix M representing the friend relationship between students in the class.
// If M[i][j]=1,then the ith and jth students are direct friends with each other,otherwise not.
// And you have to output the total number of friend circles among all the students.

// Example 1:
// Input:
// [[1,1,0],
// [1,1,0],
// [0,0,1]]
// Output:
// 2 Explanation:The 0 th and 1 st students are direct friends,so they are in a friend circle.
// The 2 nd student himself is in a friend circle.So return 2. Example 2:
//
// Input:
// [[1,1,0],
// [1,1,1],
// [0,1,1]]
// Output:1 Explanation:The 0 th and 1 st students are direct friends,the 1 st and 2 nd students are
// direct friends, so the 0 th and 2 nd students are indirect friends.All of them are in the same
// friend circle,so return 1.

class Solution {
  private int friendCircleCount;

  private int[] size;

  private int[] id;

  public int findCircleNum(int[][] M) {
    id = new int[M.length];
    size = new int[M.length];

    friendCircleCount = M.length;

    for (int i = 0; i < M.length; i++) {
      id[i] = i;
      size[i] = 1;
    }

    for (int i = 0; i < M.length; i++) {
      for (int j = i + 1; j < M.length; j++) {
        if (M[i][j] == 1) {
          union(i, j);
        }
      }
    }
    return friendCircleCount;
  }

  private void union(int p, int q) {
    int rootP = root(p);
    int rootQ = root(q);

    if (rootP == rootQ)
      return;

    if (size[rootP] < size[rootQ]) {
      id[rootP] = rootQ;
      size[rootQ] += size[rootP];
    } else {
      id[rootQ] = rootP;
      size[rootP] += size[rootQ];
    }

    friendCircleCount--;
  }

  private int root(int i) {
    while (i != id[i]) {
      id[i] = id[id[i]];
      i = id[i];
    }
    return i;
  }
}