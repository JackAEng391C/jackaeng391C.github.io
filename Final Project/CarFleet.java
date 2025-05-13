import java.util.ArrayList;

public class CarFleet {
    private Queue<Car> gasQueue;
    private Queue<Car> hybridQueue;
    private Queue<Car> electricQueue;

    public CarFleet() {
        gasQueue = new Queue<>();
        hybridQueue = new Queue<>();
        electricQueue = new Queue<>();
    }

    public boolean addCar(Car car) {
        int type = car.getPowerSource();
        switch (type) {
            case 1:
                gasQueue.enqueue(car);
                return true;
            case 2:
                hybridQueue.enqueue(car);
                return true;
            case 3:
                electricQueue.enqueue(car);
                return true;
            default:
                return false;
        }
    }

    public ArrayList<Car> processRequests(Queue<Integer> requests) {
        ArrayList<Car> result = new ArrayList<>();
        while (!requests.isEmpty()) {
            int request = requests.dequeue();
            switch (request) {
                case 1:
                    result.add(gasQueue.isEmpty() ? new Car(0, 1, 0.0f) : gasQueue.dequeue());
                    break;
                case 2:
                    result.add(hybridQueue.isEmpty() ? new Car(0, 2, 0.0f) : hybridQueue.dequeue());
                    break;
                case 3:
                    result.add(electricQueue.isEmpty() ? new Car(0, 3, 0.0f) : electricQueue.dequeue());
                    break;
                default:
                    result.add(new Car(0, 0, 0.0f));
            }
        }
        return result;
    }
}