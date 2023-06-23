// Red Black Tree implementation in JavaScript

// Data structure that represents a node in the tree
class Node {
  constructor(data) {
    this.data = data; // holds the key
    this.parent = null; // pointer to the parent
    this.left = null; // pointer to left child
    this.right = null; // pointer to right child
    this.color = 1; // 1 . Red, 0 . Black
  }
}

// Class RedBlackTree implements the operations in Red Black Tree
class RedBlackTree {
  constructor() {
    this.root = null;
    this.TNULL = new Node(null);
    this.TNULL.color = 0;
    this.TNULL.left = null;
    this.TNULL.right = null;
  }

  // Pre-Order traversal
  // Node.Left Subtree.Right Subtree
  preorder(node = this.root) {
    if (node !== this.TNULL) {
      console.log(node.data);
      this.preorder(node.left);
      this.preorder(node.right);
    }
  }

  // In-Order traversal
  // Left Subtree . Node . Right Subtree
  inorder(node = this.root) {
    if (node !== this.TNULL) {
      this.inorder(node.left);
      console.log(node.data);
      this.inorder(node.right);
    }
  }

  // Post-Order traversal
  // Left Subtree . Right Subtree . Node
  postorder(node = this.root) {
    if (node !== this.TNULL) {
      this.postorder(node.left);
      this.postorder(node.right);
      console.log(node.data);
    }
  }

  searchTree(node, key) {
    if (node === this.TNULL || key === node.data) {
      return node;
    }

    if (key < node.data) {
      return this.searchTree(node.left, key);
    }
    return this.searchTree(node.right, key);
  }

  // Fix the red-black tree
  fixInsert(k) {
    let u;
    while (k.parent.color === 1) {
      if (k.parent === k.parent.parent.right) {
        u = k.parent.parent.left; // uncle
        if (u.color === 1) {
          // case 3.1
          u.color = 0;
          k.parent.color = 0;
          k.parent.parent.color = 1;
          k = k.parent.parent;
        } else {
          if (k === k.parent.left) {
            // case 3.2.2
            k = k.parent;
            this.rightRotate(k);
          }
          // case 3.2.1
          k.parent.color = 0;
          k.parent.parent.color = 1;
          this.leftRotate(k.parent.parent);
        }
      } else {
        u = k.parent.parent.right; // uncle

        if (u.color === 1) {
          // mirror case 3.1
          u.color = 0;
          k.parent.color = 0;
          k.parent.parent.color = 1;
          k = k.parent.parent;
        } else {
          if (k === k.parent.right) {
            // mirror case 3.2.2
            k = k.parent;
            this.leftRotate(k);
          }
          // mirror case 3.2.1
          k.parent.color = 0;
          k.parent.parent.color = 1;
          this.rightRotate(k.parent.parent);
        }
      }
      if (k === this.root) {
        break;
      }
    }
    this.root.color = 0;
  }

  leftRotate(x) {
    let y = x.right;
    x.right = y.left;
    if (y.left !== this.TNULL) {
      y.left.parent = x;
    }
    y.parent = x.parent;
    if (x.parent === null) {
      this.root = y;
    } else if (x === x.parent.left) {
      x.parent.left = y;
    } else {
      x.parent.right = y;
    }
    y.left = x;
    x.parent = y;
  }

  rightRotate(x) {
    let y = x.left;
    x.left = y.right;
    if (y.right !== this.TNULL) {
      y.right.parent = x;
    }
    y.parent = x.parent;
    if (x.parent === null) {
      this.root = y;
    } else if (x === x.parent.right) {
      x.parent.right = y;
    } else {
      x.parent.left = y;
    }
    y.right = x;
    x.parent = y;
  }

  insert(key) {
    const node = new Node(key);
    let y = null;
    let x = this.root;

    while (x !== this.TNULL) {
      y = x;
      if (node.data < x.data) {
        x = x.left;
      } else {
        x = x.right;
      }
    }

    node.parent = y;
    if (y === null) {
      this.root = node;
    } else if (node.data < y.data) {
      y.left = node;
    } else {
      y.right = node;
    }

    if (node.parent === null) {
      node.color = 0;
      return;
    }

    if (node.parent.parent === null) {
      return;
    }

    this.fixInsert(node);
  }

  getRoot() {
    return this.root;
  }
}

const bst = new RedBlackTree();
bst.insert(8);
bst.insert(18);
bst.insert(5);
bst.insert(15);
bst.insert(17);
bst.insert(25);
bst.insert(40);
bst.insert(80);
bst.deleteNode(25);
bst.inorder();