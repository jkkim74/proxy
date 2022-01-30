package hello.proxy.jdkdynamic;

import hello.proxy.jdkdynamic.code.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class JdkDynamicProxyTest {

    @Test
    void dynamicA(){
        // 타겟을 정의한다.
        AInterface target = new AImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target);
        AInterface proxy = (AInterface)Proxy.newProxyInstance (AInterface.class.getClassLoader(), new Class[]{AInterface.class}, handler);

        proxy.a();

        log.info("targetClass={}",target.getClass());
        log.info("proxyClass={}",proxy.getClass());
    }

    @Test
    void dynamicB(){
        // 타겟을 정의한다.
        BInterface target = new BImpl ();
        TimeInvocationHandler handler = new TimeInvocationHandler(target);
        BInterface proxy = (BInterface)Proxy.newProxyInstance (BInterface.class.getClassLoader(), new Class[]{BInterface.class}, handler);

        proxy.b();

        log.info("targetClass={}",target.getClass());
        log.info("proxyClass={}",proxy.getClass());
    }

    @Test
    void flatMap(){
        String[][] test = {{"1","2","3"},{"4","5","6"}};
        List<String> resultList = Arrays.stream (test).flatMap (x -> Arrays.stream (x).sorted ()).collect (Collectors.toList());
        System.out.println(resultList);
    }
}

