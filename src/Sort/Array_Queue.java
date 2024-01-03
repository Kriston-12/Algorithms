//package Data_structure_algorithms;
//
//import java.util.Scanner;
//
//public class Array_Queue {
//
//    public static void main(String[] args) {
//        ArrayQueue arrayQueue = new Array_Queue(3);
//        char key = ' ';
//        Scanner scanner = new Scanner(System.in);
//        boolean loop = true;
//
//        while(loop){
//            System.out.println("s(show): 显示队列");
//            System.out.println("e(exit): 退出程序");
//            System.out.println("a(add): 添加数据到队列");
//            System.out.println("g(get): 从队列中取出数据");
//            System.out.println("h(head): 查看队列头的数据");
//            key = scanner.next().charAt(0); // 接收一个字符
//            switch (key){
//                case 's':
//                    queue.showQueue();
//                    break;
//            }
//        }
//    }
//    // Instantiate the array
//    class ArrayQueue {
//        private int maxSize;
//        private int front;
//        private int rear;
//        private int[] arr;
//
//        // create an array
//        public ArrayQueue(int arrMaxSize) {
//            maxSize = arrMaxSize;
//            arr = new int[maxSize];
//            front = -1;   // point at the position before the head of the array
//            rear = -1;    // point at the end of the array
//
//        }
//
//        // identify if the array is full
//        public boolean isFull() {
//            return rear == maxSize - 1;
//
//        }
//        public boolean isEmpty() {
//            return rear == front;
//        }
//        // Add data to the array
//        public void addQueue(int n) {
//            if(isFull()){
//                System.out.println("The array is full, cannot add data to it");
//                return;
//            }
//            rear++;
//            arr[rear] = n;
//        }
//        // Get the data in the array
//        public int GetQueue() {
//            if(isEmpty()){
//                throw new RuntimeException("the array is empty, no data available");
//            }
//            front++;
//            return arr[front];
//        }
//        public void showQueue() {
//            if (isEmpty()){
//                System.out.println("Empty array, no data available");
//                return;
//            }
//            for (int i = 0; i < arr.length; i++){
//                System.out.println("arr[%d]=%d\n", i, arr[i]);
//            }
//        }
//        // 显示队列头的数据
//        public int headQueue(){
//            if(isEmpty()) {
//                System.out.println("Empty array, no data available");
//                throw new RuntimeException("Empty array, no data available");
//            }
//            return arr[front+1];
//        }
//
//    }
//}
