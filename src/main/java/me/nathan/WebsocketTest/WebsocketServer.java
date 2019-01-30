package me.nathan.WebsocketTest;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.ServerWebSocket;
import io.vertx.core.http.WebSocketFrame;
/*
// https://mvnrepository.com/artifact/io.vertx/vertx-core
    compile group: 'io.vertx', name: 'vertx-core', version: '3.6.2'

 */
public class WebsocketServer {
    private static ServerWebSocket webSocket;
    private static String path = "/server";
    public static void main(String[] args){
        Vertx vertx = Vertx.vertx();
        HttpServer server = vertx.createHttpServer();
        server.websocketHandler(WebsocketServer::handleWebsocket);
        server.listen(2158);
        System.out.println("Listening for websocket connections on: " + path);
    }

    private static void handleWebsocket(ServerWebSocket sock){
        if(sock.path().equals(path)){
            sock.writeTextMessage("hello");
            webSocket = sock;
            webSocket.frameHandler(WebsocketServer::handleFrame);
        }
    }

    private static void sendString(String s){
        webSocket.writeTextMessage(s);
    }

    private static void handleFrame(WebSocketFrame frame){
        System.out.println(frame.textData());
    }
    private static void killWS(){
        webSocket.close();
    }
}
