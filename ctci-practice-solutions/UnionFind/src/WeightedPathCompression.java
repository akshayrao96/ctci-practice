import java.util.Arrays;

public class WeightedPathCompression {
  public int[] arr;
  public int[] size;

  public WeightedPathCompression(int n) {
    this.arr = new int[n];
    this.size = new int[n];
    this.fill();
    Arrays.fill(this.size, 1);
  }

  public void union(int p, int q) {
    int a = this.getRoot(p);
    int b = this.getRoot(q);
    if (a != b) {
      if (this.size[a] < this.size[b]) {
        this.arr[a] = b;
        this.size[b] += this.size[a];
      } else {
        this.arr[b] = a;
        this.size[a] += this.size[b];
      }
    }
  }

  public boolean connected(int p, int q) {
    return this.getRoot(p) == this.getRoot(q);
  }

  private int getRoot(int p) {
    while (p != this.arr[p]) {
      p = this.arr[p];
      this.arr[p] = this.arr[this.arr[p]];
    }
    return p;
  }

  private void fill() {
    for (int i = 0; i < this.arr.length; i++) {
      this.arr[i] = i;
    }
  }
}
