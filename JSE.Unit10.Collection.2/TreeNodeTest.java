public class TreeNodeTest {

  public static void main(String[] args) {
    TreeNode<String> root = new TreeNode<>("0");

    TreeNode<String> node1 = new TreeNode<>("1.0");
    root.addChild(node1);
    root.addChild(new TreeNode<>("1.1"));
    root.addChild(new TreeNode<>("1.2"));
    root.addChild(new TreeNode<>("1.3"));

    TreeNode<String> node2 = node1.getNextSibling();
    System.out.println("next sibling of " + node1.getValue() + " is " + node2.getValue());

    TreeNode<String> node3 = node2.getNextSibling();
    System.out.println("next sibling of " + node2.getValue() + " is " + node3.getValue());
  }

}
