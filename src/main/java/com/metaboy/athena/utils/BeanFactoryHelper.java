package com.metaboy.athena.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * Created by metaboy on 16/5/19.
 */
public class BeanFactoryHelper implements BeanFactoryAware {

    private static BeanFactory beanFactory; //BEAN工厂

    public BeanFactoryHelper() {
    }

    public static Object getBean(String beanName) {
        return beanFactory.getBean(beanName);
    }

    public static <T> T getBean(Class<T> requiredType) {
        return beanFactory.getBean(requiredType);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        BeanFactoryHelper.beanFactory = beanFactory;
    }
}
