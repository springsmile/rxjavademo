package demo.rxjavademo;

import rx.Observable;
import rx.Observer;
import rx.observers.EmptyObserver;
import rx.observers.TestSubscriber;
import rx.subjects.AsyncSubject;
/**
 * Created by lidong on 2016/7/19.
 */
public class RXAsyncSubject {
    public static void main(String[] args) {
        AsyncSubject<String> subject = AsyncSubject.create();

        Observer ob=new Observer(){
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("Throwable");
            }

            @Override
            public void onNext(Object o) {
                System.out.println("onNext"+o);
            }
        };

        subject.onNext("one");
        subject.onNext("two");
//        subject.onError(new Throwable());
        subject.onNext("three");
        subject.onCompleted();//注释掉 就不会回调相关函数 没有任何打印
        subject.subscribe(ob);
    }
}
