import java.util.concurrent.Semaphore;

public class WarehouseTransfer {

    static int[] goods = {30, 40, 25, 50, 60, 10, 90, 20, 15, 35, 45};

    static int index = 0;                
    static int currentWeight = 0;        

    static final int MAX_WEIGHT = 150;

    static Semaphore mutex = new Semaphore(1);       
    static Semaphore transferBlock = new Semaphore(1); 

    public static void main(String[] args) {

        Thread loader1 = new Thread(new Loader("Грузчик 1"));
        Thread loader2 = new Thread(new Loader("Грузчик 2"));
        Thread loader3 = new Thread(new Loader("Грузчик 3"));

        loader1.start();
        loader2.start();
        loader3.start();
    }

    static class Loader implements Runnable {
        String name;

        public Loader(String name) {
            this.name = name;
        }

        @Override
        public void run() {

            while (true) {
                int itemWeight = 0;

                try {
                    transferBlock.acquire(); 
                    transferBlock.release();

                    mutex.acquire(); 

                    if (index >= goods.length) {
                        transferBlock.acquire();

                        System.out.println(name + " закончил работу");
                        System.out.println("Весь груз перенесен.\n");
                        
                        transferBlock.release();
                        mutex.release();
                        return;
                    }

                    if (currentWeight + goods[index] > MAX_WEIGHT) {
                        System.out.println("\n=== ДОСТИГНУТ ЛИМИТ 150 КГ. НАЧИНАЕМ ПЕРЕНЕСЕНИЕ ===\n");
                  
                        transferBlock.acquire();

                        System.out.println("Текущий вес: " + currentWeight + " кг. Грузчики переносят груз...");
                        Thread.sleep(1500);
                        System.out.println("Груз разгружен.\n");

                        currentWeight = 0;
                        
                        transferBlock.release();

                        mutex.release();
                        continue;
                    }

                    itemWeight = goods[index];
                    currentWeight += itemWeight;

                    System.out.println(name + " взял товар весом " + itemWeight + " кг. Текущий вес: " + currentWeight);

                    index++;

                    mutex.release();

                    Thread.sleep(500);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
