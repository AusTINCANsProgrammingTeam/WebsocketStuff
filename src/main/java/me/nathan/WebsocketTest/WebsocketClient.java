package me.nathan.WebsocketTest;

import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.WebSocket;

/*
//https://mvnrepository.com/artifact/io.vertx/vertx-core
    compile group: 'io.vertx', name: 'vertx-core', version: '3.6.2'

 */
public class WebsocketClient {
    //ip for testing: 192.168.1.5
    //hostname: tegra-ubuntu
    private static WebSocket socket;
    public static void main(String[] args) {
        HttpClient client = Vertx.vertx().createHttpClient();

        client.websocket(2158, "192.168.1.5", "", websocket -> {
            socket = websocket;
            websocket.handler(data -> {
                System.out.println("Received data " + data.toString("ISO-8859-1"));
                client.close();
            });
            websocket.closeHandler(handler ->

            {

            });
            websocket.writeBinaryMessage(Buffer.buffer("Hello world"));
        });

    }


}
