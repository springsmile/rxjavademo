package demo.rxjavademo.scheduler;

import rx.Scheduler;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * Created by lidong on 2016/7/20.
 */
public class RXScheduler {
    public static void main(String[] args) throws Exception {
        Scheduler.Worker worker = Schedulers.newThread().createWorker();
        //worker.schedule(()-> System.out.println("111"));// 立刻直接执行打印111
        worker.schedule(()-> System.out.println("222"), 10, TimeUnit.SECONDS);//10秒后执行
        System.out.println("33");
//        worker.unsubscribe();//取消订阅 定时任务不打印 222
        Thread.sleep(TimeUnit.SECONDS.toMillis(15));//主线程等待15秒
    }
}
