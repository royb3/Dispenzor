package gelddispenser;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.logging.Level;
import java.util.logging.Logger;
import lejos.hardware.BrickFinder;
import lejos.hardware.Keys;
import lejos.hardware.ev3.EV3;
import lejos.hardware.lcd.TextLCD;
import lejos.hardware.motor.Motor;

public class Lejos {

    public static void main(String[] args) throws InterruptedException, IOException {
        EV3 ev3 = (EV3) BrickFinder.getLocal();
        TextLCD lcd = ev3.getTextLCD();
        Keys keys = ev3.getKeys();
       
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/A", new HttpHandler() {

            @Override
            public void handle(HttpExchange he) throws IOException {
                String response = "ok";
                he.sendResponseHeaders(200, response.length());
                OutputStream os = he.getResponseBody();
                os.write(response.getBytes());
                os.close();
                Motor.A.setSpeed(360);
                Motor.A.backward();
                try {
                    Thread.sleep(350);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Lejos.class.getName()).log(Level.SEVERE, null, ex);
                }
                Motor.A.forward();
                try {
                    Thread.sleep(350);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Lejos.class.getName()).log(Level.SEVERE, null, ex);
                }
                Motor.A.stop();
            }
        });
        server.createContext("/B", new HttpHandler() {

            @Override
            public void handle(HttpExchange he) throws IOException {
                String response = "ok";
                he.sendResponseHeaders(200, response.length());
                OutputStream os = he.getResponseBody();
                os.write(response.getBytes());
                os.close();
                Motor.B.setSpeed(360);
                Motor.B.backward();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Lejos.class.getName()).log(Level.SEVERE, null, ex);
                }
                Motor.B.forward();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Lejos.class.getName()).log(Level.SEVERE, null, ex);
                }
                Motor.B.stop();
            }
        });
        server.createContext("/C", new HttpHandler() {

            @Override
            public void handle(HttpExchange he) throws IOException {
                String response = "ok";
                he.sendResponseHeaders(200, response.length());
                OutputStream os = he.getResponseBody();
                os.write(response.getBytes());
                os.close();
                Motor.C.setSpeed(360);
                Motor.C.backward();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Lejos.class.getName()).log(Level.SEVERE, null, ex);
                }
                Motor.C.forward();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Lejos.class.getName()).log(Level.SEVERE, null, ex);
                }
                Motor.C.stop();
            }
        });
        server.createContext("/D", new HttpHandler() {

            @Override
            public void handle(HttpExchange he) throws IOException {
                String response = "ok";
                he.sendResponseHeaders(200, response.length());
                OutputStream os = he.getResponseBody();
                os.write(response.getBytes());
                os.close();
                Motor.D.setSpeed(360);
                Motor.D.backward();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Lejos.class.getName()).log(Level.SEVERE, null, ex);
                }
                Motor.D.forward();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Lejos.class.getName()).log(Level.SEVERE, null, ex);
                }
                Motor.D.stop();
            }
        });
        server.setExecutor(null);
        server.start();
        
        keys.waitForAnyPress();
        server.stop(0);
    }

}
