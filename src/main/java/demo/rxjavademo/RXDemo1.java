package demo.rxjavademo;

import rx.Observable;
import rx.Subscriber;

import java.io.IOException;

/**
 * Created by lidong on 2016/7/18.
 */
public class RXDemo1 {
    public static void main(String[] args) throws IOException {
        Observable.just("Hello  world!")
                .subscribe(s -> System.out.println("---next"+s),s-> System.out.println("--error"+s),()-> System.out.println("--onComplete"));
    }
}
