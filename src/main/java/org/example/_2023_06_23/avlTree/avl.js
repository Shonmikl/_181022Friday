height(node) {
    if (node == null)
        return 0;
    return node.height;
}

insert(node, value) {
    if (node == null) {
        return new Node(value);
    }

    if (value < node.value)
        node.left = this.insert(node.left, value);
    else
        node.right = this.insert(node.right, value);

    node.height = Math.max(this.height(node.left), this.height(node.right)) + 1;

    const balance = this.getBalance(node);

    if (balance > 1 && value < node.left.value)
        return this.rightRotate(node);

    if (balance < -1 && value > node.right.value)
        return this.leftRotate(node);

    if (balance > 1 && value > node.left.value) {
        node.left = this.leftRotate(node.left);
        return this.rightRotate(node);
    }

    if (balance < -1 && value < node.right.value) {
        node.right = this.rightRotate(node.right);
        return this.leftRotate(node);
    }

    return node;
}

rightRotate(y) {
    const x = y.left;
    const T2 = x.right;

    x.right = y;
    y.left = T2;

    y.height = Math.max(this.height(y.left), this.height(y.right)) + 1;
    x.height = Math.max(this.height(x.left), this.height(x.right)) + 1;

    return x;
}

leftRotate(x) {
    const y = x.right;
    const T2 = y.left;

    y.left = x;
    x.right = T2;

    x.height = Math.max(this.height(x.left), this.height(x.right)) + 1;
    y.height = Math.max(this.height(y.left), this.height(y.right)) + 1;

    return y;
}

getBalance(N) {
    if (N == null)
        return 0;
    return this.height(N.left) - this.height(N.right);
}

print(root) {
    if (root == null) {
        console.log("(XXXXXX)");
        return;
    }
    const height = root.height;
    const width = Math.pow(2, height - 1);

    const current = [root];
    const next = [];
    const maxHalfLength = 4;
    let elements = 1;

    let sb = " ".repeat(maxHalfLength * width);
    let textBuffer;

    for (let i = 0; i < height; i++) {
        sb = sb.slice(0, maxHalfLength * (Math.pow(2, height - 1 - i) - 1));

        for (const n of current) {
            process.stdout.write(sb);
            if (n == null) {
                process.stdout.write("        ");
                next.push(null);
                next.push(null);

            } else {
                process.stdout.write(`(%6d)`, n.value);
                next.push(n.left);
                next.push(n.right);

            }
            process.stdout.write(sb);
        }

        console.log();
        if (i < height - 1) {
            for (const n of current) {
                process.stdout.write(sb);
                if (n == null)
                    process.stdout.write("        ");
                else
                    process.stdout.write(`${n.left == null ? " " : "/"}      ${n.right == null ? " " : "\\"}`);
                process.stdout.write(sb);
            }
            console.log();
        }

        elements *= 2;
        current = next;
        next.length = elements;

    }
}

main() {
    const t = new AVLTree();
    let root = null;
    const readline = require('readline');

    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

    const prompt = () => {
        rl.question("(1) Insert\n(2) Delete\n", (choice) => {
            if (parseInt(choice) === 1) {
                rl.question("Value to be inserted: ", (value) => {
                    root = t.insert(root, parseInt(value));
                    t.print(root);
                    prompt();
                });
            } else if (parseInt(choice) === 2) {
                rl.question("Value to be deleted: ", (value) => {
                    root = t.deleteNode(root, parseInt(value));
                    t.print(root);
                    prompt();
                });
            } else {
                console.log("Invalid choice, try again!");
                prompt();
            }
        });
    };

    prompt();
}
}
const avlTree = new AVLTree();
avlTree.main();