public class Qthree {

         int size,front,rear;
         int[] que;
        public Qthree(int size){
            this.size=size;
            this.rear=-1;
            this.front=-1;
            this.que=new int[size];
        }
        public  boolean isFull(){
            if ((rear+1)%size == front){
                return true;
            }
            return false;
        }
        public  boolean isEmpty(){
            if (front == -1 && rear ==-1){
                return true;
            }
            return false;
        }
        public  void placeOrder(int order){
            if (isFull()){
                System.out.println("wait for some time order queue is full");
                return;
            }
            if (isEmpty()){
                front++;
                rear++;
                que[rear]=order;
                System.out.println("order"+order+"placed succesfully");
                return;
            }
            rear = (rear+1)%size;
            que[rear] = order;
            System.out.println("order"+order+"placed succesfully");
        }
        public  void serveOrder(){
            if (isEmpty()){
                System.out.println("there is no order placed");
                return;
            }
            int order = que[front];
            System.out.println("order"+order+"is served");
            front = (front+1)%size;
        }
       public void displayOrders(){
            int curr = front;
            while (true){

                System.out.print(que[curr]+"-->");

                if (curr == rear){
                    break;
                }
                curr = (curr+1)%size;
            }
       }

        public static void main(String[] args) {
            Qthree quee = new Qthree(5);
//            System.out.println("hello");
            quee.placeOrder(9);
            quee.placeOrder(2);
            quee.placeOrder(3);
            quee.placeOrder(3);
            quee.placeOrder(3);
            quee.placeOrder(3);
            quee.displayOrders();

        }
    }



