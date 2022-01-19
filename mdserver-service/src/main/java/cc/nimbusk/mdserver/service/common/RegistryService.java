package cc.nimbusk.mdserver.service.common;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;

/**
 * Dynamic registry service
 *
 * @author nimbusk
 * @version 1.0
 * @date 2022/1/19
 */
public interface RegistryService {

    /**
     * registry target cls into spring framework
     * @param cls
     */
    void registry(Class<?> cls);

    /**
     * init beanDefinitionRegistry
     * @param beanDefinitionRegistry spring bean definition registry
     */
    void init(BeanDefinitionRegistry beanDefinitionRegistry);

}
