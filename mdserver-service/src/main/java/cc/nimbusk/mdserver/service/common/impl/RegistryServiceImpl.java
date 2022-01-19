package cc.nimbusk.mdserver.service.common.impl;

import cc.nimbusk.mdserver.service.common.RegistryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * RegistryServiceImpl
 *
 * @author nimbusk
 * @version 1.0
 * @date 2022/1/19
 */
@Service
@Slf4j
public class RegistryServiceImpl implements RegistryService, ApplicationContextAware, BeanDefinitionRegistryPostProcessor {
    /** component part */
    private BeanDefinitionRegistry beanDefinitionRegistry;
    private ApplicationContext applicationContext;

    @Override
    public void registry(Class<?> cls) {
        // todo do registry
    }

    @Override
    public void init(BeanDefinitionRegistry beanDefinitionRegistry) {
        this.beanDefinitionRegistry = beanDefinitionRegistry;
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        this.beanDefinitionRegistry = beanDefinitionRegistry;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
