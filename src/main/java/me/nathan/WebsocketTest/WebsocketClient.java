package me.nathan.WebsocketTest;

import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpClient;

/*
//https://mvnrepository.com/artifact/io.vertx/vertx-core
    compile group: 'io.vertx', name: 'vertx-core', version: '3.6.2'

 */
public class WebsocketClient {
    public static void main(String[] args) {
        HttpClient client = Vertx.vertx().createHttpClient();

        client.websocket(2158, "tegra-ubuntu", "/server", websocket -> {
            websocket.handler(data -> {
                System.out.println("Received data " + data.toString("ISO-8859-1"));
                client.close();
            });
            websocket.writeBinaryMessage(Buffer.buffer("Hello world"));
        });
    }
}
