import java.util.*;

public class Heaps {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            arr.add(data);

            int x = arr.size()-1;
            int par = (x-1)/2;

            while(arr.get(x)<arr.get(par)) {
                //swap
                int temp = arr.get(x);
                arr.set(x,arr.get(par));
                arr.set(par,temp);

                x = par;
                par = (x-1)/2;
            }
        }

        public int peek() {
            return arr.get(0);
        }

        private void heapify(int i) {
            int left = 2*i + 1;
            int right = 2*i + 2;
            int minIdx = i;
            
            if(left<arr.size() && arr.get(left) < arr.get(minIdx)) {
                minIdx = left;
            }

            if(right<arr.size() && arr.get(right) < arr.get(minIdx)) {
                minIdx = right;
            }

            if(minIdx != i) {
                //swap
                int temp = arr.get(i);
                arr.set(i,arr.get(minIdx));
                arr.set(minIdx,temp);
                
                heapify(minIdx);
            }
        }

        public int remove() {
            int data = arr.get(0);

            //step 1 - swap first and last node
            int temp = arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1,temp);

            //step 2 - delete last node
            arr.remove(arr.size()-1);

            //step 3 - heapify fn
            heapify(0);
            return data;
        }

        public boolean isEmpty() {
            return arr.size()==0;
        }
    }

    public static void main(String[] args) {
        Heap hp = new Heap();
        hp.add(2);
        hp.add(3);
        hp.add(4);
        hp.add(5);
        hp.add(10);
        hp.add(1);

        while(!hp.isEmpty()) {
            System.out.println(hp.peek());
            hp.remove();
        }
    }
}
