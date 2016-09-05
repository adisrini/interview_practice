package ch4.treesandgraphs.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * You are implementing a binary tree class from scratch which, in addition to insert, find, and delete, has a method
 * getRandomNode() which returns a random node from the tree. All nodes should be equally likely to be chosen. Design and
 * implement an algorithm for getRandomNode, and explain how you would implement the rest of the methods.
 * 
 * @author Aditya Srinivasan
 *
 */
public class RandomNode {
    
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;
        int size = 0;
        
        TreeNode(int data) {
            this.data = data;
            size = 1;
        }
        
        TreeNode getRandomNode() {
            int leftSize = (left == null) ? 0 : left.size;
            Random random = new Random();
            int index = random.nextInt(size);
            if(index < leftSize) {
                return left.getRandomNode();
            } else if(index == leftSize) {
                return this;
            } else {
                return right.getRandomNode();
            }
        }
        
        void insert(int data) {
            if(data <= this.data) {
                if(left == null) {
                    left = new TreeNode(data);
                } else {
                    left.insert(data);
                }
            } else {
                if(right == null) {
                    right = new TreeNode(data);
                } else {
                    right.insert(data);
                }
            }
            size++;
        }
        
        TreeNode find(int data) {
            if(this.data == data) return this;
            else if(data <= this.data) {
                return (left != null) ? left.find(data) : null;
            } else {
                return (right != null) ? right.find(data) : null;
            }
        }
        
    }
    
    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(5);
        
        n5.insert(1);
        n5.insert(2);
        n5.insert(3);
        n5.insert(4);
        n5.insert(5);
        n5.insert(6);
        n5.insert(7);
        n5.insert(8);
        
        Map<Integer, Integer> samples = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < 100000; i++) {
            int rnd = n5.getRandomNode().data;
            if(!samples.containsKey(rnd)) {
                samples.put(rnd, 0);
            }
            samples.put(rnd, samples.get(rnd) + 1);
        }
        
        System.out.println(samples);
        
    }

}
