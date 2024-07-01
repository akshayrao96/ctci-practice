public class QuickFind {

  public int[] arr;

  public QuickFind(int n) {
    this.arr = new int[n];
    this.fill();

  }

  public void union(int p, int q) {
    int a = this.arr[p];
    int b = this.arr[q];
    for (int i = 0; i < this.arr.length; i++) {
      if (this.arr[i] == b) {
        this.arr[i] = this.arr[a];
      }
    }
  }

  public boolean connected(int p, int q) {
    return this.arr[p] == this.arr[q];
  }

  private void fill() {
    for (int i = 0; i < this.arr.length; i++) {
      this.arr[i] = i;
    }
  }
}
