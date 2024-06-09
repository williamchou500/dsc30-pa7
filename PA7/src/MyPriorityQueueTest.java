import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyPriorityQueueTest {
    @Test
    public void Test() {
        MyPriorityQueue test = new MyPriorityQueue(99);
        for (int i = 0; i < 1000; i++) {
            test.offer(i);
            test.poll();
        }

        for (int i = 0; i < 1000; i++) {
            test.offer(i);
        }

        for (int i = 0; i < 1000; i++) {
            test.poll();
        }
    }
}