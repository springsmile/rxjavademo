package demo.rxjavademo.subject;

import rx.Observer;
import rx.subjects.ReplaySubject;

/**
 * Created by lidong on 2016/7/20.
 */
public class RXReplaySubject {
    public static void main(String[] args) {
        ReplaySubject<String> subject = ReplaySubject.create();
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
        Observer<String> o1 = ob;
        subject.subscribe(o1);//onNextone   onNexttwo  onNextthree  Throwable

        subject.onNext("one");
        subject.onNext("two");
        subject.onNext("three");
        subject.onError(new Throwable());
        subject.onNext("four");
        subject.onCompleted();


        Observer<String> o2 = ob;
        subject.subscribe(o2);//onNextone   onNexttwo  onNextthree  Throwable
    }
}
