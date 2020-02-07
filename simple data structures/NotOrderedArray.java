package com.company;

public class NotOrderedArray {

    private int[] array;
    private int elements_count;

    /**
     *
     * @param length: the length of created array. cannot be changed.
     */
    NotOrderedArray(int length) {
        this.array = new int[length];
        this.elements_count = 0;
    }

    /**
     * linear search
     * @param element: finding element in the created array
     * @return: true of false
     */
    public boolean find(int element) {
        for(int i = 0; i< this.elements_count; i++) {
            if(this.array[i] == element)
                return true;
        }
        return false;
    }

    /**
     * just insert an element to array on elements_count index and then increment count of elements
     * @param element: new element to insert in the array
     */
    public void insert(int element) {
        this.array[this.elements_count] = element;
        this.elements_count++;
    }

    /**
     * using linear search delete from array
     * @param element: element to delete from array
     */
    public void delete(int element) {
        for(int i = 0; i < this.elements_count; i++) {
            if(this.array[i] == element) {
                // this loop can be replaced with comment bellow
                // System.arraycopy(this.array, i + 1, this.array, i, this.elements_count - i);
                for(int j = i; j < this.elements_count; j++) {
                    this.array[j] = this.array[j + 1];
                }
            }
        }
    }

    public void display() {
        for(int i = 0; i < this.elements_count; i++)
            System.out.print(this.array[i] + " ");
    }
}
