class ThreadProcessor {
    public static void findAndStartThread(Thread... threads) throws InterruptedException {
        Thread worker = java.util.Arrays.stream(threads)
                    .filter(th->th.getState().equals(Thread.State.NEW)).findFirst().get();
        worker.start();
        worker.join();
    }
}