package com.company;

import java.util.*;


public class LinearProbing<K, V> {
    final static int INIT_CAPACITY = 32;
    double loadFactor ;
    int threshold;
    int countOfItems;
    int capacity;
    K[] key;
    V[] value;






    public void resize(int cappacity){
        value = Arrays.copyOf(value, cappacity);
        key = Arrays.copyOf(key, cappacity);

        threshold =(int)(capacity * loadFactor);
    }

    public int size(){
        return countOfItems;
    }

    public int hash(K key){
        return key.hashCode() % capacity;
    }
    public boolean isEmpty() {
        if(size() == 0){
            return true;
        }
        return false;
    }

    public boolean contains(K key_){
        int index = hash(key_);
        while(key[index] != null){
            if(key[index].equals(key_)){
                return true;
            }
        }
        return false;
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
    public V get(K key){
        int index = getBucketIndex(key);
        if(index != -1){
            return value[index];
        }
        return null;

    }
    public void put(K key_, V value_){
        if(threshold == countOfItems){
            resize(capacity + 15);
        }
        int temp = hash(key_);
        int index = temp;

        if(key[index] != null){

            if (key[index].equals(key_)) {
                value[index] = value_;
                return;
            }

            index = (index + 1) % capacity;

            while (temp != index){

                if(key[index] == null) {
                    key[index] = key_;
                    value[index] = value_;
                    countOfItems++;
                    return;
                }

                index = (index + 1) % capacity;
            }

        }
        else {
            key[index] = key_;
            value[index] = value_;
            countOfItems++;
        }
    }

    public void remove(K key_){
        int index = getBucketIndex(key_);
        try {
            key[index] = null;
            value[index] = null;

            index = (index + 1) % capacity;

            while(key[index]!=null){
                countOfItems--;

                V val = value[index];
                K k  = key[index];

                key[index] = null;
                value[index] = null;

                put(k, val);

                index = (index + 1) % capacity;
            }
            countOfItems--;
        }
        catch (Exception e){
            throw new NoSuchElementException(e);
        }

    }

    public Iterable<K> keys(){
        return Arrays.asList(key);
    }




    public double getLoadFactor() {
        return loadFactor;
    }

    public void setLoadFactor(double loadFactor) {
        this.loadFactor = loadFactor;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public int getCountOfItems() {
        return countOfItems;
    }

    public void setCountOfItems(int countOfItems) {
        this.countOfItems = countOfItems;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public K[] getKey() {
        return key;
    }

    public void setKey(K[] key) {
        this.key = key;
    }

    public V[] getValue() {
        return value;
    }

    public void setValue(V[] value) {
        this.value = value;
    }


    public LinearProbing() {
        loadFactor = 0.5;
        threshold = (int)(capacity * loadFactor);
        countOfItems = 0;
        capacity = INIT_CAPACITY;
        key = (K[]) new Object[capacity];
        value = (V[]) new Object[capacity];
    }
    public LinearProbing(int capacity){
        loadFactor = 0.5;
        threshold = (int)(capacity * loadFactor);
        countOfItems = 0;
        this.capacity = capacity;
        key = (K[]) new Object[capacity];
        value = (V[]) new Object[capacity];
    }
    public static void main(String[] args) {
        LinearProbing<Integer, String> linearProbing = new LinearProbing<>(7);

        linearProbing.put(234, "Den");
        linearProbing.put(983, "Oleg");
        linearProbing.put(236, "Mia");
        linearProbing.remove(234);
        System.out.println(linearProbing.keys());


    }

}
