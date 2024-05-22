import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class dHeapTest {

    @Test
    public void SizeTest1() {
        dHeap test = new dHeap();
        test.add(50);
        test.add(21);
        test.add(64);
        test.add(5);

        assertEquals(4, test.size());
    }

    @Test
    public void SizeTest2() {
        dHeap test = new dHeap(2);
        test.add(100);
        test.add(150);
        test.add(3);

        assertEquals(3, test.size());
    }

    @Test
    public void SizeTest3() {
        dHeap test = new dHeap();
        test.add(1);
        test.remove();

        assertEquals(0, test.size());
    }

    @Test
    public void AddTest1() {
        dHeap test = new dHeap();
    }

    @Test
    public void AddTest2() {
        dHeap test = new dHeap();
    }

    @Test
    public void AddTest3() {
        dHeap test = new dHeap();
    }

    @Test
    public void RemoveTest1() {
        dHeap test = new dHeap();
    }

    @Test
    public void RemoveTest2() {
        dHeap test = new dHeap();
    }

    @Test
    public void RemoveTest3() {
        dHeap test = new dHeap();
    }

    @Test
    public void ClearTest1() {
        dHeap test = new dHeap();
    }

    @Test
    public void ClearTest2() {
        dHeap test = new dHeap();
    }

    @Test
    public void ClearTest3() {
        dHeap test = new dHeap();
    }

    @Test
    public void ElementTest1() {
        dHeap test = new dHeap();
    }

    @Test
    public void ElementTest2() {
        dHeap test = new dHeap();
    }

    @Test
    public void ElementTest3() {
        dHeap test = new dHeap();
    }
}