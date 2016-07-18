package demo.rxjavademo;

import rx.Observable;
import rx.Subscriber;
import rx.plugins.RxJavaHooks;

import java.io.IOException;

/**
 * Created by lidong on 2016/7/18.
 */
public class RXDemo {
    public static void main(String[] args) throws IOException {
        //创建Observable
        Observable<String> myObservable = Observable.create(
                new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> sub) {
                        sub.onNext("Hello  world!");
                    }
                }
        );

        //创建Subscriber
        Subscriber<String> mySubscriber = new Subscriber<String>() {
            @Override
            public void onNext(String s) { System.out.println("--"+s); }

            @Override
            public void onCompleted() {  System.out.println("--"); }

            @Override
            public void onError(Throwable e) { }
        };

        //组合
        myObservable.subscribe(mySubscriber);
    }
}
