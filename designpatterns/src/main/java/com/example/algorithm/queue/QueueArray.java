package com.example.algorithm.queue;

/**
 * Created by yeyao on 2018/4/26 下午2:35
 */
public class QueueArray<T> implements QueueInter<T> {
    Object[] mArray;
    int first = -1;
    int last = -1;
    int step = 4;

    public QueueArray() {
        mArray = new Object[4];

    }

    @Override
    public boolean isEmpty() {
        return first == -1;
    }

    @Override
    public boolean isFull() {
        return (first == 0 && last == mArray.length - 1 || last + 1 == first);
    }

    @Override
    public void insertObject(T t) {
        if (isFull()) {
            addLarge();
        }
        if (mArray.length - 1 == last || first == -1) {
            mArray[0] = t;
            last = 0;
            if (first == -1) {
                first = 0;
            }
        } else {
            mArray[++last] = t;
        }
    }

    @Override
    public Object remove() {
        Object o = mArray[first];
        if (first == last) {
            first = last = -1;
        } else if (first == mArray.length - 1) {
            first = 0;
        } else {
            first++;
        }
        return o;
    }

    public void printAll() {
        for (Object i : mArray)
            System.out.print(i + "  ");
        System.out.println();
    }

    @Override
    public void addLarge() {
        Object[] mNewArray = new Object[mArray.length + step];
        if (first == 0 && last == mArray.length - 1) {
            System.arraycopy(mArray, 0, mNewArray, 0, mArray.length);
        } else {
            System.arraycopy(mArray, 0, mNewArray, 0, last + 1);
            System.arraycopy(mArray, first, mNewArray, step + first, mArray.length - first);

            first = first + 4;
        }
        mArray = mNewArray;
    }


}
