import java.util.Arrays;

public class UnionFindMain {

  public static void main(String[] args) {
    WeightedPathCompression u = new WeightedPathCompression(7);
    System.out.println(u.connected(1, 3) + "  expected:  false"); // false
    u.union(1, 3);
    System.out.println(u.connected(1, 3) + "  expected:  true"); // true
    u.union(3, 5);
    u.union(6, 4);
    u.union(2, 3);

    System.out.println(u.connected(0, 1) + "  expected:  false"); // false
    System.out.println(u.connected(0, 2) + "  expected:  false"); // false
    System.out.println(u.connected(2, 4) + "  expected:  false"); // false

    System.out.println(u.connected(4, 5) + "  expected:  false"); // false

    u.union(6, 0);

    System.out.println(u.connected(4, 0) + "  expected:  true"); // true
    System.out.println(u.connected(5, 2) + "  expected:  true"); // true

    System.out.println(u.connected(3, 2) + "  expected:  true"); // true

    System.out.println(u.connected(5, 1) + "  expected:  true"); // true
    System.out.println(u.connected(5, 0) + "  expected:  false"); // false


    System.out.println(Arrays.toString(u.arr));


  }

}
