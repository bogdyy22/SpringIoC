package com.hcl;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {
    public static void main(String[] args) {
/*    ---------Main1
         Normal Java Object Construction
        IOTDevice myConstructedObject = new IOTDevice();

        System.out.println("IOTDevice intialized with a construcor: " + myConstructedObject);

         IoC container --> BeanFactory

        Resource resource = new ClassPathResource("applicationContext.xml");

        BeanFactory beanFactory = new XmlBeanFactory(resource);

        IOTDevice myDeviceBean = (IOTDevice) beanFactory.getBean("myIOTDeviceBean");

        System.out.println("XmlBeanFactory(Deprecated) bean -- " + myDeviceBean);
*/
/*    ---------Main2

        Resource resource = new ClassPathResource("applicationContext.xml");

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanReader = new XmlBeanDefinitionReader(beanFactory);
        beanReader.loadBeanDefinitions(resource);

        IOTDevice myDeviceBean = (IOTDevice) (beanFactory).getBean("myIOTDeviceBean");

        System.out.println("Bean from BeanDefinitionRegistry -- " + myDeviceBean);

 */
 /*    ----------Main3
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        IOTDevice myDeviceBean = (IOTDevice) applicationContext.getBean("myIOTDeviceBean");

        System.out.println("Bean from ApplicationContext:\n" + myDeviceBean);
*/
        /* -------------Main4
        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        IOTDevice myFirstDeviceBean = (IOTDevice) appContext.getBean("myIOTDeviceBeanOne");
        IOTDevice mySecondDeviceBean = appContext.getBean("myIOTDeviceBeanTwo", IOTDevice.class);

        myFirstDeviceBean.setDevice("Fridge");
        myFirstDeviceBean.setDescription("Temperature gauge for the freezer");

        mySecondDeviceBean.setDevice("Ligth");
        mySecondDeviceBean.setDescription("Ia foc in 3 trepte");

        System.out.println("First Bean: " + myFirstDeviceBean);
        System.out.println("Second BEan: " + mySecondDeviceBean);
       */

        /* --------Main5
        Resource resource = new ClassPathResource("applicationContext.xml");

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanReader = new XmlBeanDefinitionReader(beanFactory);
        beanReader.loadBeanDefinitions(resource);

        IOTDevice myFirstDeviceBean = (IOTDevice) beanFactory.getBean("myIOTDeviceBeanOne");
        IOTDevice mySecondDeviceBean = beanFactory.getBean("myIOTDeviceBeanTwo", IOTDevice.class);
*/
/*  --------Main6
        ApplicationContext appContext = new AnnotationConfigApplicationContext(IOTDeviceBeanConfig.class);

        IOTDevice myFirstDeviceBean = (IOTDevice) appContext.getBean("IOTDeviceBean");

        myFirstDeviceBean.setDevice("Fridge");
        myFirstDeviceBean.setDescription("Temperature rece");

        System.out.println("Primul Bean: " + myFirstDeviceBean);


 */

        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("\nAbout to retrive the instantiated beans...\n");

        IOTDevice myFirstDeviceBean = (IOTDevice) appContext.getBean("myIOTDeviceBeanOne");
        IOTDevice mySecondDeviceBean = (IOTDevice) appContext.getBean("myIOTDeviceBeanTwo");

        myFirstDeviceBean.setDevice("Aspirator");
        myFirstDeviceBean.setDescription("Aspirare apa/praf");

        mySecondDeviceBean.setDevice("Televizor");
        mySecondDeviceBean.setDescription("Smart TV 1.2");

        System.out.println("First Bean: " + myFirstDeviceBean);
        System.out.println("Second Bean: " + mySecondDeviceBean);

        appContext.close();

    }
}
