package com.company;

import java.util.Arrays;

public class OrderedArray {
    private int [] array;
    private int elements_count;

    /**
     *
     * @param length: the length of created array. cannot be changed.
     */
    OrderedArray(int length) {
        this.array = new int[length];
        this.elements_count = 0;
    }

    /**
     * using linear search find a place, where to add an element to ordered array
     * @param element: new element to insert in the array
     */
    public void insert(int element) {
        int i;
        for(i = 0; i < this.elements_count; i++) {
            if(this.array[i] > element) {
                break;
            }
        }
        for(int j = this.elements_count; j > i; j--) {
            array[j] = array[j - 1];
        }
        this.array[i] = element;
        this.elements_count++;
    }

    /**
     * using binary search delete element from array
     * @param element: element to delete from array
     */
    public boolean delete(int element) {
        int index = this.find(element);
        if(index == this.elements_count)
            return false;
         for(int i = index; i < this.elements_count; i++) {
             this.array[i] = this.array[i + 1];
         }
         this.elements_count--;
         return true;
    }

    /**
     * binary search
     * @param element: finding element in the created array
     * @return: index of found element. If not found returns length of array(out of bounds)
     */
    public int find(int element) {
        int lower_bound = 0;
        int upper_bound = this.elements_count - 1;
        while(true) {
            // this is done because can be a situation, when lower_bond + upper_bound will be out of type range
            int current_index = lower_bound + (upper_bound - lower_bound) / 2;
            if(this.array[current_index] == element)
                return current_index;
            if(lower_bound > upper_bound)
                return this.elements_count;
            if(this.array[current_index] > element)
                upper_bound = current_index - 1;
            else
                lower_bound = current_index + 1;
        }
    }

    public void display() {
        for(int i = 0; i < this.elements_count; i++)
            System.out.print(this.array[i] + " ");
    }
}
