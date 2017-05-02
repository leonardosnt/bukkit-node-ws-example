package io.github.leonardosnt.testws;

import java.net.URI;

import org.bukkit.plugin.java.JavaPlugin;
import org.eclipse.jetty.websocket.WebSocketClient;
import org.eclipse.jetty.websocket.WebSocketClientFactory;

public class TestPlugin extends JavaPlugin {

  private static final String WEBSOCKET_SERVER_URL = "ws://mfb-0.glitch.me/";
  
  @Override
  public void onEnable() {
    // Como nunca usei essa lib (jetty ws) antes, não sei se isso é bloqueante,
    // se for, basta fazer a conexão em uma Thread separada
    WebSocketClientFactory factory = new WebSocketClientFactory();
    WebSocketClient client = new WebSocketClient(factory);

    try {
      factory.start();
      client.open(URI.create(WEBSOCKET_SERVER_URL), new SimpleWsClient());
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
