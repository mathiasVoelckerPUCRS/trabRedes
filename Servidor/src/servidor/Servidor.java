/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author 13104334
 */
public class Servidor {

    public static void main(String args[])  throws Exception
      {
         // cria socket do servidor com a porta 9876
         DatagramSocket serverSocket = new DatagramSocket(9876);

            byte[] receiveData = new byte[1024];
            while(true)
               {
                  // declara o pacote a ser recebido
                  DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                  // recebe o pacote do cliente
                  serverSocket.receive(receivePacket);

                  // pega os dados, o endere�o IP e a porta do cliente
                  // para poder mandar a msg de volta
                  String sentence = new String(receivePacket.getData());
                  InetAddress IPAddress = receivePacket.getAddress();
                  int port = receivePacket.getPort();

                  System.out.println("Mensagem recebida: " + sentence);
               }
      }
    
}
