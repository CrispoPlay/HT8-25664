import static org.junit.Assert.*;
import org.junit.Test;

public class VectorHeapTest {

    @Test
    public void shouldAddElementsCorrectly() {

        VectorHeap<Paciente> heap = new VectorHeap<>();

        heap.add(new Paciente("Juan", "fractura", 'C'));
        heap.add(new Paciente("Maria", "apendicitis", 'A'));

        Paciente primero = heap.remove();

        assertEquals('A', primero.getPrioridad());
    }

    @Test
    public void shouldRemoveElementsInPriorityOrder() {

        VectorHeap<Paciente> heap = new VectorHeap<>();

        heap.add(new Paciente("Juan", "fractura", 'C'));
        heap.add(new Paciente("Maria", "apendicitis", 'A'));
        heap.add(new Paciente("Pedro", "dolor", 'B'));

        assertEquals('A', heap.remove().getPrioridad());
        assertEquals('B', heap.remove().getPrioridad());
        assertEquals('C', heap.remove().getPrioridad());
    }

    @Test
    public void shouldReturnNullWhenHeapIsEmpty() {

        VectorHeap<Paciente> heap = new VectorHeap<>();

        assertNull(heap.remove());
    }

    @Test
    public void shouldIdentifyEmptyHeapCorrectly() {

        VectorHeap<Paciente> heap = new VectorHeap<>();

        assertTrue(heap.isEmpty());

        heap.add(new Paciente("Maria", "apendicitis", 'A'));

        assertFalse(heap.isEmpty());
    }
}