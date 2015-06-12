package fr.utbm.jms;

import fr.utbm.core.entity.Alert;
import fr.utbm.core.entity.Area;
import fr.utbm.core.entity.Sensor;
import fr.utbm.core.entity.Station;
import fr.utbm.core.entity.Temperature;
import fr.utbm.core.entity.Trigger;
import fr.utbm.core.service.AlertService;
import fr.utbm.core.service.AreaService;
import fr.utbm.core.service.SensorService;
import fr.utbm.core.service.StationService;
import fr.utbm.core.service.TemperatureService;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class AlertSender {

    private ConnectionFactory factory = null;
    private Connection connection = null;
    private Session session = null;
    private Destination destination = null;
    private MessageProducer producer = null;

    public AlertSender() {

    }

    public void sendMessage(Trigger t) {
        String text = buildMessage(t);
        
        try {
            factory = new ActiveMQConnectionFactory(
                    ActiveMQConnection.DEFAULT_BROKER_URL);
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("SAMPLEQUEUE");
            producer = session.createProducer(destination);
            
            TextMessage message = session.createTextMessage();
            message.setText(text);
            producer.send(message);
            System.out.println("Sent: \n" + message.getText());
            
            producer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace(System.out);
        }
    }
    
    private String buildMessage(Trigger t) {
        SensorService senService = new SensorService();
        StationService staService = new StationService();
        TemperatureService tempService = new TemperatureService();
        AreaService areaService = new AreaService();
        AlertService alertService = new AlertService();
        
        Sensor sensor = senService.getSensorById(t.getSensor().getId());
        Station station = staService.getStationById(sensor.getStation().getId());
        Area area = areaService.getAreaById(station.getArea().getId());
        
        Alert alert = alertService.getAlert(t.getAlert().getId());
        Temperature temperature = tempService.getLastTemperatureBySensorId(sensor.getId());
        
        String message = "==== " + alert.getLabel() + " ====";
        message += "\n-- Date : " + temperature.getDate().toString();
        message += "\n-- Area : " + area.getLabel();
        message += "\n-- Station : " + station.getLabel();
        message += "\n-- Sensor : " + sensor.getLabel();
        message += "\n-- Temperature : " + temperature.getValue() + "°C";
        message += "\n==== Message ====\n" + alert.getDescription();
        
        return message;
    }
}
