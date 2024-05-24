public class AVLTree {

    public class Node{
        int key;
        int height;

        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }
    }
    Node root;

    Node getRoot(){
        return root;
    }
    void updateHeight(Node n){
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    int height(Node n){
        if(n == null){
            return -1;
        }else{
            return n.height;
        }
    }

    int getBalance(Node n){
        if(n == null){
            return 0;
        }else{
            return height(n.right) - height(n.left);
        }
    }

    Node rotateRight(Node y){
        Node x= y.left;
        Node z= x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    Node rotateLeft(Node y){
        Node x = y.right;
        Node z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    Node rebalance(Node z){
        updateHeight(z);
        int balance = getBalance(z);
        if(balance > 1){
            if(height(z.right.right)>height(z.right.left)){
                z = rotateLeft(z);
            }else{
                z.right = rotateRight(z);
                z = rotateLeft(z);
            }
        } else if (balance < -1) {
            if (height(z.left.left) > height(z.left.right))
                z = rotateRight(z);
            else {
                z.left = rotateLeft(z.left);
                z = rotateRight(z);
            }
        }
        return z;
    }

    Node insert(Node node, int key){
        if(node == null){
            return new Node(key);
        } else if (node.key > key) {
            node.left = insert(node.left, key);
        } else if (node.key < key){
            node.right = insert(node.right, key);
        }else{
            throw new RuntimeException("duplicate key");
        }
        return rebalance(node);
    }

    Node delete(Node node, int key){
        if(node == null){
            return node;
        }else if(node.key > key){
            node.left = delete(node.left, key);
        }else if(node.key < key){
            node.right = delete(node.right, key);
        }else{
            if(node.left == null || node.right == null){
                if(node.left == null){
                    node = node.right;
                }else{
                    node = node.left;
                }
            }else{
                Node mostLeftChild = mostLeftChild(node.right);
                node.key = mostLeftChild.key;
                node.right = delete(node.right, node.key);
            }
        }
        if(node == null){
            node = rebalance(node);
        }
        return node;
    }

    public Node find(int key) {
        Node current = root;
        while (current != null) {
            if (current.key == key) {
                break;
            }
            if(current.key < key){
                current = current.right;
            }else{
                current = current.right;
            }
        }
        return current;
    }

    Node mostLeftChild(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
}