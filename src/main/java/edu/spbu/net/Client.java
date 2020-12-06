package edu.spbu.net;

import java.io.*;
import java.net.Socket;

public class Client {
  private int port;
  private String host;

  public Client(int port, String host){
    this.port = port;
    this.host = host;
  }

  void start(){
    try (Socket socket = new Socket(this.host, this.port);
         BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
         BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    )
    {
      System.out.println("Connected to server!");
      String request = "localhost:8080/index.html";
      writer.write(request);
      writer.newLine();
      writer.flush();
      String response = reader.readLine();
      System.out.println("Response: " + response);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    new Client(8080, "127.0.0.1").start();
  }
}
