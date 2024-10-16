package cn.afuo.example.lambda;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
           for (int i=0;i<10;i++) {
               log.info("新建线程-> {}", i);
           }
        });
        thread.start();
    }

}
