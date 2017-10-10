public class TestNode {

  private void test(Node<?> node) {
    while (node != null) {
      System.out.println("value is '" + node.getValue() + "'");
      node = node.next;
    }
  }

  public static void main(String[] args) {
    Node<String> root = new Node<>("Step 1");
    Node<String> node1 = new Node<>("Step 2");
    root.next = node1;

    new TestNode().test(root);

    Node<Integer> root2 = new Node<>(99, new Node<>(23, new Node<>(11)));

    new TestNode().test(root2);
  }
}
