/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 *
 * @author 13104334
 */
public class Cliente {

    public static void main(String args[]) throws Exception
   {
       System.out.println("Digite o caminho do arquivo");
       String sentence = "";
      // cria o stream do teclado
      Scanner scanner = new Scanner(System.in);
      String nomeArquivo = scanner.nextLine();

      try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(nomeArquivo);
            
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while((line = bufferedReader.readLine()) != null) {
                sentence = sentence + "\n" + line;
            }   

            // Always close files.
            bufferedReader.close();  
            
      } catch (FileNotFoundException e) {
          System.out.println("Arquivo não encontrado");
      }
      // declara socket cliente
      DatagramSocket clientSocket = new DatagramSocket();

      // obtem endere�o IP do servidor com o DNS
      InetAddress IPAddress = InetAddress.getByName("192.168.56.1");

      byte[] sendData = new byte[1024];
      byte[] receiveData = new byte[1024];

      // l� uma linha do teclado
      sendData = sentence.getBytes();

      // cria pacote com o dado, o endere�o do server e porta do servidor
      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);

      //envia o pacote
      clientSocket.send(sendPacket);

      // fecha o cliente
      clientSocket.close();
   }
    
}
