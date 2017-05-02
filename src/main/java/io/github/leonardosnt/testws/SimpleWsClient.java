package io.github.leonardosnt.testws;

import org.eclipse.jetty.websocket.WebSocket.OnTextMessage;

public class SimpleWsClient implements OnTextMessage {

  public void onOpen(Connection conn) {
    System.out.println("connected");
  }

  public void onClose(int code, String message) {
    System.out.println("closed");
  }

  public void onMessage(String msg) {
    System.out.println("msg -> " + msg);
  }

}
