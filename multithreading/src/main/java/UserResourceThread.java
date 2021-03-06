import java.util.Random;

public class UserResourceThread {

    public static void main(String[] args) throws InterruptedException {
        SharedResource resource = new SharedResource();
        IntegerSetterGetter t1 = new IntegerSetterGetter("1", resource);
        IntegerSetterGetter t2 = new IntegerSetterGetter("2", resource);
        IntegerSetterGetter t3 = new IntegerSetterGetter("3", resource);
        IntegerSetterGetter t4 = new IntegerSetterGetter("4", resource);
        IntegerSetterGetter t5 = new IntegerSetterGetter("5", resource);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        Thread.sleep(100);

        t1.stopThread();
        t2.stopThread();
        t3.stopThread();
        t4.stopThread();
        t5.stopThread();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        System.out.println("main");
    }
}

class IntegerSetterGetter extends Thread {

    private SharedResource resource;
    private boolean run;

    private Random rand = new Random();

    public IntegerSetterGetter(String name, SharedResource resource) {
        super(name);
        this.resource = resource;
        run = true;
    }

    public void stopThread() {
        run = false;
    }

    public void run() {
        int action;

        try {
            while (run) {
                action = rand.nextInt(1000);
                if (action % 2 == 0)
                    getIntegersIntoResource();
                else
                    setIntegersFromResource();
            }
            System.out.println("Поток " + getName() + " завершил работу.");
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    private void getIntegersIntoResource() throws InterruptedException {
        Integer number;

        synchronized (resource) {
            System.out.println("Поток " + getName() + " хочет извлечь число.");
            number = resource.getElement();

            while (number == null) {
                resource.clickp();
                if (resource.getClick() < 4) {
                    System.out.println("Поток " + getName() + " ждет пока очередь заполнится.");
                    System.out.println(resource.getClick());
                    resource.wait();
                    resource.clickm();
                    System.out.println("Поток " + getName() + " возобновил работу.");
                }
                number = resource.getElement();
            }
            System.out.println("Поток " + getName() + " извлек число " + number);
        }
    }

    public void setIntegersFromResource() throws InterruptedException {
        Integer number = rand.nextInt(500);

        synchronized (resource) {
            resource.setElement(number);
            System.out.println("Поток " + getName() + " записал число " + number);
            resource.notify();
        }
    }
}
