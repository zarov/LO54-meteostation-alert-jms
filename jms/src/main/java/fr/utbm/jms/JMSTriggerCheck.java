package fr.utbm.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;	
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author Adrien
 */
@Component("jmsTriggerCheck")
public class JMSTriggerCheck {
    public JMSTriggerCheck () {}
    
    public void checkTrigger() {
        // connection service sensor
        // pour chaque station, comparer trigger et température
        // si pas bon, sendAlert
        // sinon suivant
        System.out.println("yes quartz fonctionne coucou");
    }
    
    public void sendAlert() {}
}
