import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class CarFleetTests {

    @Test
    public void testAddCar() {
        CarFleet fleet = new CarFleet();
        Car car1 = new Car(1, 1, 10.5f);
        Car car2 = new Car(2, 2, 12.0f);
        Car car3 = new Car(3, 3, 9.75f);
        Car carInvalid = new Car(4, 4, 11.0f);

        assertTrue(fleet.addCar(car1));
        assertTrue(fleet.addCar(car2));
        assertTrue(fleet.addCar(car3));
        assertFalse(fleet.addCar(carInvalid));
    }

    @Test
    public void testProcessRequests() {
        CarFleet fleet = new CarFleet();
        Car car1 = new Car(101, 1, 10f);
        Car car2 = new Car(202, 2, 12f);
        Car car3 = new Car(303, 3, 15f);
        fleet.addCar(car1);
        fleet.addCar(car2);
        fleet.addCar(car3);

        Queue<Integer> requests = new Queue<>();
        requests.enqueue(1);
        requests.enqueue(2);
        requests.enqueue(3);
        requests.enqueue(2);

        ArrayList<Car> result = fleet.processRequests(requests);
        assertEquals(4, result.size());
        assertEquals(101, result.get(0).getId());
        assertEquals(202, result.get(1).getId());
        assertEquals(303, result.get(2).getId());
        assertEquals(0, result.get(3).getId());
    }

    @Test
    public void testQueueOperations() {
        Queue<String> queue = new Queue<>();
        assertTrue(queue.isEmpty());

        queue.enqueue("A");
        queue.enqueue("B");
        assertEquals("A", queue.peek());
        assertEquals("A", queue.dequeue());
        assertEquals("B", queue.peek());
        assertFalse(queue.isEmpty());
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }
}
