package org.example._2023_07_07;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String text = "AAAASSSDDDFFGGHJ";

        Map<Character, Integer> frequencies = countFreq(text);

        List<CodeTreeNode> codeTreeNodes = new ArrayList<>();
        for (Character c : frequencies.keySet()) {
            codeTreeNodes.add(new CodeTreeNode(c, frequencies.get(c)));
        }

        CodeTreeNode tree = huffman(codeTreeNodes);
        Map<Character, String> codes = new TreeMap<>();
        for (Character c : frequencies.keySet()) {
            codes.put(c, tree.getCodeForCharacter(c, ""));
        }

        System.out.println("Codes matrix: " + codes);

        StringBuilder encoded = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            encoded.append(codes.get(text.charAt(i)));
        }

        System.out.println("Original size: [" + text.getBytes().length * 8 + "] bit");
        System.out.println("Compressed size: [" + encoded.length() + "] bit");
        System.out.println("Compressed text bit's: [" + encoded + "]");

        String decoded = huffmanDecode(encoded.toString(), tree);
        System.out.println("Decoded: [" + decoded + "]");
    }

    //1. Сколько раз каждый символ встречается в тексте
    private static TreeMap<Character, Integer> countFreq(String text) {
        TreeMap<Character, Integer> freqMap = new TreeMap<>();
        for (int i = 0; i < text.length(); i++) {
            Character c = text.charAt(i);
            Integer count = freqMap.get(c);
            freqMap.put(c, count != null ? count + 1 : 1);
        }
        return freqMap;
    }

    //2. Класс для кодового дерева
    private static class CodeTreeNode implements Comparable<CodeTreeNode> {
        Character content;
        int weight;
        CodeTreeNode left;
        CodeTreeNode right;

        //нижние узлы
        public CodeTreeNode(Character content, int weight) {
            this.content = content;
            this.weight = weight;
        }

        //верхние узлы
        public CodeTreeNode(Character content, int weight, CodeTreeNode left, CodeTreeNode right) {
            this.content = content;
            this.weight = weight;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(CodeTreeNode o) {
            return o.weight - this.weight;
        }

        public String getCodeForCharacter(Character ch, String parentPath) {
            if (content == ch) {
                return parentPath;
            } else {
                if (left != null) {
                    String path = left.getCodeForCharacter(ch, parentPath + 0);
                    if (path != null) {
                        return path;
                    }
                }
                if (right != null) {
                    return right.getCodeForCharacter(ch, parentPath + 1);
                }
            }
            return null;
        }
    }

    //3. Алгоритм
    private static CodeTreeNode huffman(List<CodeTreeNode> codeTreeNodes) {
        while (codeTreeNodes.size() > 1) {
            Collections.sort(codeTreeNodes);
            CodeTreeNode left = codeTreeNodes.remove(codeTreeNodes.size() - 1);
            CodeTreeNode right = codeTreeNodes.remove(codeTreeNodes.size() - 1);

            CodeTreeNode parent = new CodeTreeNode(null, right.weight + left.weight, left, right);
            codeTreeNodes.add(parent);
        }
        return codeTreeNodes.get(0);
    }

    //4. Декодируем
    private static String huffmanDecode(String encoded, CodeTreeNode tree) {
        StringBuilder decoded = new StringBuilder();
        CodeTreeNode node = tree;
        for (int i = 0; i < encoded.length(); i++) {
            node = encoded.charAt(i) == '0' ? node.left : node.right;
            if (node.content != null) {
                decoded.append(node.content);
                node = tree;
            }
        }
        return decoded.toString();
    }
}