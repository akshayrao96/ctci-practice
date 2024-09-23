public class SegmentTreeImp implements SegmentTree {

  protected Node head;

  protected static class Node {

    protected int val;
    protected int leftInterval;
    protected int rightInterval;

    protected Node left;
    protected Node right;

    public Node(int val, int leftInterval, int rightInterval) {
      this.val = val;
      this.leftInterval = leftInterval;
      this.rightInterval = rightInterval;
    }
  }

  public SegmentTreeImp(int[] arr) {

    this.buildTree(arr);
  }

  private void buildTree(int[] arr) {
    this.head = null;
    this.head = buildTree(arr, 0, arr.length - 1);
  }

  private Node buildTree(int[] arr, int left, int right) {
    if (left > right) {
      return null;
    }
    if (left == right) {
      return new Node(arr[left], left, right);
    }

    int mid = left + (right - left) / 2;
    Node leftNode = buildTree(arr, left, mid);
    Node rightNode = buildTree(arr, mid + 1, right);

    Node curr = new Node(0, left, right);

    if (leftNode != null) {
      curr.val += leftNode.val;
    }

    if (rightNode != null) {
      curr.val += rightNode.val;
    }

    curr.left = leftNode;
    curr.right = rightNode;
    return curr;
  }

  public int query(int left, int right) {
    Node curr = this.head;
    return query(curr, left, right);
  }

  private int query(Node curr, int left, int right) {
    if (left > curr.rightInterval || right < curr.leftInterval) {
      return 0;
    }
    if (curr.leftInterval == curr.rightInterval) {
      return curr.val;
    }
    if (left == curr.leftInterval && right == curr.rightInterval) {
      return curr.val;
    }
    int leftSum = query(curr.left, left, right);
    int rightSum = query(curr.right, left, right);
    return leftSum + rightSum;
  }

  public void update(int idx, int num) {
    Node curr = this.head;
    update(curr, idx, num);
  }

  private void update(Node curr, int idx, int num) {
    if (curr.leftInterval == curr.rightInterval) {
      if (curr.leftInterval != idx) {
        return;
      }
      curr.val = num;
    } else {
      if (idx < curr.leftInterval || idx > curr.rightInterval) {
        return;
      }
      update(curr.left, idx, num);
      update(curr.right, idx, num);
      curr.val = 0;
      if (curr.left != null) {
        curr.val += curr.left.val;
      }
      if (curr.right != null) {
        curr.val +=
            curr.right.val;
      }
    }
  }
}