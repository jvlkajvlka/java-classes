import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class InternalPanelAgent extends Thread {
    static class InternalCall{
        private final int toFloor;
        InternalCall(int toFloor){
            this.toFloor = toFloor;
        }
    }

    InternalPanelAgent(ElevatorCar elevatorCar){
        this.elevatorCar = elevatorCar;
    }

    BlockingQueue<InternalCall> input = new ArrayBlockingQueue<>(100);
    ElevatorCar elevatorCar;

    public void run(){
        for(;;){
            // odczytaj wezwanie z kolejki
            // w zależności od aktualnego piętra, na którym jest winda,
            // umieść przystanek w odpowiedniej tablicy ''EleveatorStops''
            for (; ; ) {
                InternalCall ic = null;
                try {
                    ic = input.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (ic == null) return;
                if (ic.toFloor == elevatorCar.getFloor()) continue;
                //w zależności od aktualnego piętra, na którym jest winda,
                //umieszczamy przystanek w odpowiedniej tablicy 'ElevatorStops'
                if (ic.toFloor > elevatorCar.getFloor()) {
                    ElevatorStops.get().setLiftStopUp(ic.toFloor);
                } else {
                    ElevatorStops.get().setLiftStopDown(ic.toFloor);
                }
            }
        }
    }

}