package com.example.configserver;

public class volatileTest {
        static class Work {
            boolean isShutDown = false;

            void shutdown() {
                isShutDown = true;
                System.out.println("shutdown!");
            }

            void doWork() {
                while (!isShutDown) {
                    System.out.println("doWork");
                }
            }
        }

        public static void main(String[] args) {
            Work work = new Work();

            new Thread(work::doWork).start();
            new Thread(work::doWork).start();
            new Thread(work::doWork).start();
            new Thread(work::shutdown).start();
            new Thread(work::doWork).start();
            new Thread(work::doWork).start();
            new Thread(work::doWork).start();
        }
    }
