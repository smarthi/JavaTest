public class BinaryTree {

  private Node root = null;

  public static void main(String[] args) throws Exception {
    BinaryTree binaryTree = new BinaryTree();
    binaryTree.insert(2);
    binaryTree.insert(1);
    binaryTree.insert(0);
    binaryTree.insert(4);
    binaryTree.insert(3);
    binaryTree.insert(5);
    binaryTree.insert(10);
//    binaryTree.printPostOrder();
    System.out.println("\nSize = " + binaryTree.size());
    System.out.println("\nMax Depth = " + binaryTree.maxDepth());
    System.out.println("Min Value = " + binaryTree.minValue());
    System.out.println("Has Path Sum = " + binaryTree.hasPathSum(5));
    binaryTree.printPaths();
    binaryTree.mirror();
    binaryTree.printPaths();
  }

  public boolean lookUp(int data) {
    return lookup(root, data);
  }

  private boolean lookup(Node node, int data) {
    if (node == null) return false;
    if (node.data == data) {
      return true;
    } else if (data < node.data) {
      return lookup(node.left, data);
    } else {
      return lookup(node.right, data);
    }
  }

  public void insert(int data) {
    root = insert(root, data);
  }

  private Node insert(Node node, int data) {
    if (node == null) {
      node = new Node(data);
    } else if (data < node.data) {
      node.left = insert(node.left, data);
    } else {
      node.right = insert(node.right, data);
    }
    return node;
  }

  private void printTree(Node node) {
    if (node == null) return;
    printTree(node.left);
    System.out.print(node.data + " ");
    printTree(node.right);
  }

  public Node getRoot() {
    return root;
  }

  public int size() {
    return size(root);
  }

  private int size(Node node) {
    if (node == null) return 0;
    return (size(node.left) + size(node.right) + 1);
  }

  public int maxDepth() {
    return maxDepth(root);
  }

  private int maxDepth(Node node) {
    if (node == null) {
      return 0;
    } else {
      int leftDepth = maxDepth(node.left);
      int rightDepth = maxDepth(node.right);
      return Math.max(leftDepth, rightDepth) + 1;
    }
  }

  public int minValue() {
    return minValue(root);
  }

  private int minValue(Node node) {
    Node currentNode = node;
    while (currentNode.left != null) {
      currentNode = currentNode.left;
    }
    return currentNode.data;
  }

  public void printPostOrder() {
    printPostOrder(root);
    System.out.println();
  }

  private void printPostOrder(Node node) {
    if (node == null) return;
    printPostOrder(node.left);
    printPostOrder(node.right);
    System.out.println(node.data + " ");
  }

  public boolean hasPathSum(int sum) {
    return hasPathSum(root, sum);
  }

  private boolean hasPathSum(Node node, int sum) {
    if (node == null) {
      return (sum == 0);
    } else {
      int tempSum = sum - node.data;
      return (hasPathSum(node.left, tempSum) || hasPathSum(node.right, tempSum));
    }
  }

  public void printPaths() {
    int[] path = new int[100];
    printPaths(root, path, 0);
  }

  private void printPaths(Node node, int[] path, int pathLen) {
    if (node == null) return;
    path[pathLen] = node.data;
    pathLen++;

    if (node.left == null && node.right == null) {
      printArray(path, pathLen);
    } else {
      printPaths(node.left, path, pathLen);
      printPaths(node.right, path, pathLen);
    }
  }

  private void printArray(int[] path, int pathLen) {
    for (int i = 0; i < pathLen; i++) {
      System.out.print(path[i] + " ");
    }
    System.out.println();
  }

  public void mirror() {
    mirror(root);
  }

  private void mirror(Node node) {
    if (node != null) {
      mirror(node.left);
      mirror(node.right);

      Node temp = node.left;
      node.left = node.right;
      node.right = temp;
    }
  }

  private class Node {
    Node left;
    Node right;
    int data;

    Node(int newData) {
      left = null;
      right = null;
      data = newData;
    }
  }
}
