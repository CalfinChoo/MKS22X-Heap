public class MyHeap {
  // - size  is the number of elements in the data array.
  // - push the element at index i downward into the correct position. This will swap with the larger of the child nodes provided thatchild is larger. This stops when a leaf is reached, or neither child is larger. [ should be O(logn) ]
  // - precondition: index is between 0 and size-1 inclusive
  // - precondition: size is between 0 and data.length-1 inclusive.
  private static void pushDown(int[] data, int size, int index) {
    if (index * 2 + 2 < size) {
      int largerChild = index * 2 + 1;
      if (data[largerChild + 1] > data[largerChild]) largerChild++;
      if (data[index] < data[largerChild]) {
        int temp = data[largerChild];
        data[largerChild] = data[index];
        data[index] = temp;
        pushDown(data, size, largerChild);
      }
    }
    else if (index * 2 + 1 < size && data[index] < data[index * 2 + 1]) {
      int temp = data[index * 2 + 1];
      data[index * 2 + 1] = data[index];
      data[index] = temp;
    }
  }
  // - push the element at index i up into the correct position. This will swap it with the parent node until the parent node is larger or the root is reached. [ should be O(logn) ]
  // - precondition: index is between 0 and data.length-1 inclusive.
  private static void pushUp(int[] data, int index) {
    if ((index - 1) / 2 >= 0) {
      if (data[index] > data[(index - 1) / 2]) {
        int temp = data[(index - 1) / 2];
        data[(index - 1) / 2] = data[index];
        data[index] = temp;
        pushUp(data, (index - 1) / 2);
      }
    }
  }
  // - convert the array into a valid heap. [ should be O(n) ]
  public static void heapify(int[] data) {
    for (int i = data.length - 1; i >= 0; i--) {
      pushDown(data, data.length, i);
    }
  }
  // - sort the array by converting it into a heap then removing the largest value n-1 times. [ should be O(nlogn) ]
  public static void heapsort(int[] data) {}
  public static void main(String[] args) {
    int[] test = {8, 4, 17, 9, 0, 7, 12};
    pushDown(test, test.length, 0);
    for (int i : test) System.out.println(i);
  }
}
