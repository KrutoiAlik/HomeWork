package task06;


import task07.AnnotationForAtomicBoat;

@AnnotationForAtomicBoat
public class AtomicBoat {

    EngineAtomicBoat engine;

    class EngineAtomicBoat{

        boolean isOn;

        public void setOn(boolean on) {
            isOn = on;
        }
    }

    void startEngine(){
        engine = new EngineAtomicBoat();
        engine.setOn(true);
        System.out.println("Запуск");
    }
}

class Test {
    public static void main(String[] args) {
        new AtomicBoat().startEngine();
    }
}
