public class SegmentTreeArray implements SegmentTree {

  private final int length;
  private final int[] arr;

  public SegmentTreeArray(int[] arr) {
    this.length = arr.length;
    this.arr = new int[this.length * 2];

    for (int i = this.length; i < this.arr.length; i++) {
      this.arr[i] = arr[i - this.length];
    }

    for (int i = this.length - 1; i >= 0; i--) {
      this.arr[i] = this.arr[i * 2] + this.arr[i * 2 + 1];
    }
  }

  @Override
  public void update(int idx, int val) {
    int getIdx = idx + this.length;
    this.arr[getIdx] = val;
    getIdx /= 2;
    while (getIdx != 0) {
      this.arr[getIdx] = this.arr[getIdx * 2] + this.arr[getIdx * 2 + 1];
      getIdx /= 2;
    }
  }

  @Override
  public int query(int l, int r) {
    int getLeft = l + this.length;
    int getRight = r + this.length;

    int sum = 0;

    while (getLeft <= getRight) {
      if (getLeft % 2 == 1) {
        sum += this.arr[getLeft];
        getLeft++;
      }
      if (getRight % 2 == 0) {
        sum += this.arr[getRight];
        getRight--;
      }
      getLeft /= 2;
      getRight /= 2;
    }

    return sum;
  }
}