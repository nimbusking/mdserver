package cc.nimbusk.mdserver.service.proxy;

import org.springframework.beans.factory.FactoryBean;

/**
 * DynamicProxyFactory
 *
 * @author nimbusk
 * @version 1.0
 * @date 2022/1/17
 */
public class DynamicProxyFactory<T> implements FactoryBean<T> {

    private Class<T> interfaceClass;


    @Override
    public T getObject() throws Exception {
        return (T) new DynamicProxy().bind(interfaceClass);
    }

    @Override
    public Class<?> getObjectType() {
        return interfaceClass;
    }

    @Override
    public boolean isSingleton() {
        // spring singleton
        return true;
    }


    public Class<T> getInterfaceClass() {
        return interfaceClass;
    }

    public void setInterfaceClass(Class<T> interfaceClass) {
        this.interfaceClass = interfaceClass;
    }
}
