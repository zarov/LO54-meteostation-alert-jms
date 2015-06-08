package fr.utbm.jms;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Adrien
 */
public class LaunchQuartz {
    
    public String foo;
    
    public void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("fr/utbm/core/jms-trigger-quartz.xml");
        System.out.println("yo");
    }
}
