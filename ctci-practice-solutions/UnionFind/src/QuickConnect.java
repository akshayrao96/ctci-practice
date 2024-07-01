/*
Steps for UnionConnect

first have our arrays, that represents the root
union: put first int below second int, so that it creates a tree like structure
only need to change the value of the roots

 */

public class QuickConnect {

  public int[] arr;

  public QuickConnect(int n) {
    this.arr = new int[n];
    this.fill();
  }

  public void union(int p, int q) {
    int a = this.getRoot(p);
    int b = this.getRoot(q);
    if (a != b) {
      this.arr[a] = b;
    }
  }

  public boolean connected(int p, int q) {
    return this.getRoot(p) == this.getRoot(q);
  }

  private int getRoot(int p) {
    while (p != this.arr[p]) {
      p = this.arr[p];
    }
    return p;
  }

  private void fill() {
    for (int i = 0; i < this.arr.length; i++) {
      this.arr[i] = i;
    }
  }
}
