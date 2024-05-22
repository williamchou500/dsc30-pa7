import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

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
        test.add(50);

        assertEquals(50, test.element());
        assertEquals(1, test.size());
    }

    @Test
    public void AddTest2() {
        dHeap test = new dHeap(3, 1, false);
        test.add(1);
        test.add(2);
        test.add(-1);
        test.add(12);

        assertEquals(-1, test.element());
        assertEquals(4, test.size());
    }

    @Test
    public void AddTest3() {
        dHeap test = new dHeap(2, 10, true);
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(1);

        assertEquals(3, test.element());
        assertEquals(4, test.size());
    }

    @Test
    public void AddTestException() {
        dHeap test = new dHeap();

        assertThrows(NullPointerException.class, () -> {test.add(null);});
    }

    @Test
    public void RemoveTest1() {
        dHeap test = new dHeap();
        test.add(99);
        test.add(17);
        test.add(111);

        assertEquals(111, test.remove());
        assertEquals(2, test.size());
    }

    @Test
    public void RemoveTest2() {
        dHeap test = new dHeap();
        test.add(5);
        test.add(111);
        test.add(5);
        test.add(111);

        assertEquals(111, test.remove());
        assertEquals(111, test.remove());
        assertEquals(5, test.remove());
        assertEquals(5, test.remove());
    }

    @Test
    public void RemoveTest3() {
        dHeap test = new dHeap(2, 1, true);

        for (int i = 0; i < 1000; i++) {
            test.add(i);
        }

        for (int i = 999; i >= 0; i--) {
            assertEquals(i, test.remove());
        }
    }

    @Test
    public void RemoveTestException() {
        dHeap test = new dHeap();

        assertThrows(NoSuchElementException.class, () -> {test.remove();});
    }

    @Test
    public void ClearTest1() {
        dHeap test = new dHeap();
        test.add(6);
        test.clear();

        assertEquals(0, test.size());
        assertThrows(NoSuchElementException.class, () -> {test.remove();});
    }

    @Test
    public void ClearTest2() {
        dHeap test = new dHeap();
        test.add(6);
        test.add(5);
        test.clear();
        test.clear();

        assertEquals(0, test.size());
        assertThrows(NoSuchElementException.class, () -> {test.element();});
    }

    @Test
    public void ClearTest3() {
        dHeap test = new dHeap();

        for (int i = 0; i < 1000; i++) {
            test.add(i);
        }

        for (int i = 0; i < 100; i++) {
            test.remove();
        }

        test.clear();

        assertEquals(0, test.size());
        assertThrows(NoSuchElementException.class, () -> {test.element();});
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