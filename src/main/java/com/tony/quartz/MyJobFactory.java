package com.tony.quartz;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.AdaptableJobFactory;

import java.lang.reflect.Field;


public class MyJobFactory extends AdaptableJobFactory implements ApplicationContextAware {

    private AutowireCapableBeanFactory capableBeanFactory;
    private ApplicationContext applicationContext;

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object jobInstance = super.createJobInstance(bundle);
        Class<?> aClass = jobInstance.getClass();
        Field[] fields = aClass.getDeclaredFields();
        if (fields.length>0){
            for (Field field : fields) {
                Class<?> type = field.getType();
                Object bean = applicationContext.getBean(field.getName());

                field.setAccessible(true);
                field.set(jobInstance,bean);

            }
        }
        //capableBeanFactory.autowireBean(jobInstance);
        return jobInstance;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
