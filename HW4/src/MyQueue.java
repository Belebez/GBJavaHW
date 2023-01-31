import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/*
enqueue() - помещает элемент в конец очереди,
dequeue() - возвращает первый элемент из очереди и удаляет его,
first() - возвращает первый элемент из очереди, не удаляя.
*/
public class MyQueue {
    private Queue<Integer> queue;

    Random random = new Random();
    MyQueue(int capacity) {
        queue = new LinkedList<>();
        for (int i = 0; i < capacity; i++) {
            queue.add(random.nextInt(100));
        }
    }

    int size(){
        return queue.size();
    }

    void enqueue(int element){
        queue.offer(element);
    }

    int dequeue() {
        return queue.poll();

    }

    int first() {
        return queue.peek();
    }

    public String toString() {
        return queue.toString();
    }
}
