package demo.rxjavademo;

import rx.Observer;
import rx.subjects.BehaviorSubject;

/**
 * Created by lidong on 2016/7/19.
 */
public class RXBehaviorSubject {
    public static void main(String[] args) {
        BehaviorSubject<String> subject = BehaviorSubject.create("zero");
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
        subject.subscribe(ob);//onNextzero onNextone onNexttwo onNextthree

        subject.onNext("one");
        subject.onNext("two");
//        subject.onError(new Throwable());
        subject.onNext("three");
        subject.subscribe(ob);//onNextthree
    }
}
