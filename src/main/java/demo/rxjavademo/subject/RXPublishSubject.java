package demo.rxjavademo.subject;

import rx.Observer;
import rx.subjects.PublishSubject;

/**
 * Created by lidong on 2016/7/20.
 */
public class RXPublishSubject {

    public static void main(String[] args) {
        PublishSubject<String> subject = PublishSubject.create();

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
        subject.subscribe(ob);//onNextthree onCompleted
        subject.onNext("three");
//        subject.onError(new Throwable());
        subject.onCompleted();

    }
}
