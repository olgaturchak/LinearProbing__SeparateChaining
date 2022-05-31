package com.company;

import java.util.ArrayList;
import java.util.List;



public class SeparateChaining<K, V> {
    List<HashNode<K,V>> buckets;
    int capacity;
    int countOfItems;


    public SeparateChaining() {
        buckets = new ArrayList<>();
        capacity = 15;    //size
        countOfItems = 0;
        for(int i=0; i<capacity; i++){
            buckets.add(null);
        }

    }

    public  int size(){ return countOfItems; }

    public boolean isEmpty() { return size() == 0; }

    public int hash(K key){
        return key.hashCode() % capacity;
    }

    private int getBucketIndex(K key)
    {
        int hashCode = hash(key);
        int index = hashCode % capacity;
        if(index < 0){
            return -1;
        }
        return index;
    }

    public boolean contains(K key_){
        int index = hash(key_);
        int hashCode = hash(key_);
        HashNode<K, V> head = buckets.get(index);

        while (head != null) {
            if (head.key.equals(key_)){
                return true;
            }
        }
        return false;
    }

    public void put(K key, V value) {
        int index = hash(key);
        int hashCode = hash(key);
        HashNode<K, V> head = buckets.get(index);

        while (head != null) {
            if (head.key.equals(key) && head.hashCode == hashCode) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // Insert key in chain
        countOfItems++;
        head = buckets.get(index);
        HashNode<K, V> newNode = new HashNode<K, V>(key, value, hashCode);
        newNode.next = head;
        buckets.set(index, newNode);

        // If load factor goes beyond threshold, then
        // double hash table size
        if ((1.0 * countOfItems) / capacity >= 0.7) {
            ArrayList<HashNode<K, V>> temp = (ArrayList<HashNode<K, V>>) buckets;
            buckets = new ArrayList<>();
            capacity = 2 * capacity;
            countOfItems = 0;
            for (int i = 0; i < capacity; i++)
                buckets.add(null);

            for (HashNode<K, V> headNode : temp) {
                while (headNode != null) {
                    put(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }




    public V get(K key)
    {
        // Find head of chain for given key
        int bucketIndex = getBucketIndex(key);
        int hashCode = hash(key);

        HashNode<K, V> head = buckets.get(bucketIndex);

        // Search key in chain
        while (head != null) {
            if (head.key.equals(key) && head.hashCode == hashCode)
                return head.value;
            head = head.next;
        }
        // If key not found
        return null;
    }



    public V delete(K key)
    {
        // Apply hash function to find index for given key
        int bucketIndex = getBucketIndex(key);
        int hashCode = hash(key);
        // Get head of chain
        HashNode<K, V> head = buckets.get(bucketIndex);

        // Search for key in its chain
        HashNode<K, V> prev = null;
        while (head != null) {
            // If Key found
            if (head.key.equals(key) && hashCode == head.hashCode)
                break;

            // Else keep moving in chain
            prev = head;
            head = head.next;
        }

        // If key was not there
        if (head == null)
            return null;

        // Reduce size
        capacity--;

        // Remove key
        if (prev != null)
            prev.next = head.next;
        else
            buckets.set(bucketIndex, head.next);

        return head.value;
    }


    public static void main(String[] args) {
        LinearProbing<Integer, String> separateChaining = new LinearProbing<>(7);

        separateChaining.put(234, "Den");
        separateChaining.put(983, "Oleg");
        separateChaining.put(236, "Mia");
        System.out.println(separateChaining.keys());

        separateChaining.remove(234);
        System.out.println(separateChaining.keys());


    }
}
