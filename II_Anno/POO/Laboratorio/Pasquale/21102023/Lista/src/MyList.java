public class MyList {
    private final int maxSize;
    private int[] array;
    private int lastIndex;

    public MyList(int size) {
        maxSize = size;
        array = new int[maxSize];
        lastIndex = 0;
    }

    private void swap_left(int starting) {
        for (int i = starting; i < lastIndex-1; i++) {
            array[i] = array[i+1];
        }
    }

    public boolean insert(int el) {
        if (lastIndex == maxSize) {
            return false;
        }

        array[lastIndex] = el;
        lastIndex++;
        return true;
    }

    public boolean delete(int index) {
        if (index >= maxSize || index > lastIndex) {
            return false;
        }

        swap_left(index);
        lastIndex--;
        return true;
    }

    public int getElementByIndex(int index) {
        if (index < lastIndex) {
            return array[index];
        }
        return Integer.MIN_VALUE;
    }

    public void printAll() {
        for (int i = 0; i < lastIndex; i++) {
            System.out.println("#" + i+ ":\t" + array[i]);
        }
    }

}
