package me.nathan.WebsocketTest;

import java.net.URI;
import java.net.URISyntaxException;

public class WebsocketClientJavax {
    public static void connectToWebsocket(String url, int port, String endpoint){
        try {
        final WebsocketClientEndpoint clientEndPoint = new WebsocketClientEndpoint(new URI("wss://" + url + ":" + port + endpoint));

        // add listener
        clientEndPoint.addMessageHandler(new WebsocketClientEndpoint.MessageHandler() {
            public void handleMessage(String message) {
                System.out.println(message);
            }
        });

        // send message to websocket
        clientEndPoint.sendMessage("Hello!");

        // wait 5 seconds for messages from websocket
        Thread.sleep(5000);

    } catch (InterruptedException ex) {
        System.err.println("InterruptedException exception: " + ex.getMessage());
    } catch (URISyntaxException ex) {
        System.err.println("URISyntaxException exception: " + ex.getMessage());
    }
    }
}
