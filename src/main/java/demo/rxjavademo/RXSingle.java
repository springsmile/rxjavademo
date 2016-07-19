package demo.rxjavademo;

import rx.Single;
import rx.singles.BlockingSingle;

/**
 * Created by lidong on 2016/7/19.
 */
public class RXSingle {
    public static void main(String[] args) {
//        Single<String> single = Single.error(new Throwable());
        Single<String> single = Single.just("hello");
        BlockingSingle<String> blockingSingle = BlockingSingle.from(single);
        System.out.println(blockingSingle.value());
    }
}
