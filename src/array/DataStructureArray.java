package array;

import java.util.Optional;

/**
 * @Author: LiJun-YNU
 * @createTime: 2024年01月09日 21:55:17
 * @version: 1.0
 * @Description: 自定义的数组
 */
public class DataStructureArray<E> {
    private E[] array;
    private int size;

    DataStructureArray() {
        this(10);
    }

    @SuppressWarnings("unchecked")
    DataStructureArray(int capacity) {
        array = (E[]) new Object[capacity];
        size = 0;
    }

    public int getCapacity() {
        return Optional.of(array.length).get();
    }

    public int getSize() {
        return Optional.of(size).get();
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(e)) return true;
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(e)) return i;
        }
        return -1;
    }

    //根据index删除一个元素
    public E removeOfIndex(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove fail.Index is illegal.");
        for (int i = index + 1; i < size; i++) {
            array[i - 1] = array[i];
        }
        size--;
        array[index] = null;
        if (size == array.length / 4 && array.length / 2 != 0)
            resize(array.length / 2);
        return array[index];
    }

    public void add(int index, E e) {
        if (index < 0 || index >= array.length)
            throw new IllegalArgumentException("Add fail.Index is illegal.");
        if (size == array.length)
            resize(2 * array.length);
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = e;
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        E[] newArray = (E[]) new Object[newCapacity];
        if (size >= 0) System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    public E removeElement(E e) {
        int index = find(e);
        return removeOfIndex(index);
    }


    public static void main(String[] args) {
        DataStructureArray<Integer> dataStructureArray = new DataStructureArray<>(10);
        dataStructureArray.addFirst(1);
        System.out.println(dataStructureArray.getCapacity());
        dataStructureArray.addLast(1);
        System.out.println(dataStructureArray.getSize());
        Integer second = dataStructureArray.removeElement(1);
        System.out.println(dataStructureArray.getSize());
    }
}

