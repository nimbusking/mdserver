package cc.nimbusk.mdserver.service.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Dynamic Proxy by jdk dynamic proxy
 *
 * @author nimbusk
 * @version 1.0
 * @date 2022/1/17
 */
@Slf4j
public class DynamicProxy implements InvocationHandler {

    public Object bind(Class<?> cls) {
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // todo create dynamic response by Method
        return null;
    }
}
