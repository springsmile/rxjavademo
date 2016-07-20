package demo.rxjavademo.scheduler;

import rx.Observable;
import rx.Scheduler;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * Created by lidong on 2016/7/20.
 */
public class RXIOScheduler {
    public static void main(String[] args) throws Exception {
        Observable<Integer> o1 = Observable.just(1, 2, 3, 4, 5);
        o1.subscribeOn(Schedulers.computation()).toBlocking().forEach((t)-> System.out.println("t"+t));
    }
}
