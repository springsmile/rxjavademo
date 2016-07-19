package demo.rxjavademo;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.internal.operators.OperatorToMap;
import rx.observables.ConnectableObservable;
import rx.observers.TestSubscriber;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by lidong on 2016/7/18.
 */
public class RXDemoDefer {
    public static void main(String[] args) throws IOException {
        final AtomicInteger run = new AtomicInteger();

        ConnectableObservable<Integer> co = Observable.defer(()->Observable.just(run.incrementAndGet())).publish();

        Observable<Integer> source = co.autoConnect();
        //没有Subscriber 打印0
        System.out.println(run.get());

        TestSubscriber<Integer> ts1 = TestSubscriber.create();
        source.subscribe(ts1);

        ts1.assertCompleted();
        ts1.assertNoErrors();
        ts1.assertValue(1);//期望值为1 正常
        System.out.println(run.get());//输出1

        TestSubscriber<Integer> ts2 = TestSubscriber.create();
        source.subscribe(ts2);
        ts2.assertNotCompleted();
        ts2.assertNoErrors();
        ts2.assertNoValues();
        System.out.println(run.get());

    }
}
