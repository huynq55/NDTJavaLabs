public class TreeNode<T> {

  private T value;

  private TreeNode<T> nextSibling;
  private TreeNode<T> firstChild;
  private TreeNode<T> parent;

  public TreeNode(T v) {
    value = v;
  }

  public TreeNode<T> getNextSibling() {
    return nextSibling;
  }

  public TreeNode<T> getParent() {
    return parent;
  }

  public TreeNode<T> getFirstChild() {
    return firstChild;
  }

  public T getValue() {
    return value;
  }

  public void addChild(TreeNode<T> child) {
    if (child == null) {
      return;
    }
    child.parent = this;
    if (firstChild == null) {
      firstChild = child;
    } else {
      TreeNode<T> temp = firstChild;
      while (temp.nextSibling != null) {
        temp = temp.getNextSibling();
      }
      temp.nextSibling = child;
    }


  }

}
