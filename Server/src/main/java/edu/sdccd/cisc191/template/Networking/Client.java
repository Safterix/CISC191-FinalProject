package edu.sdccd.cisc191.template.Networking;

import edu.sdccd.cisc191.template.GameAssets.ViewGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private Socket clientSock;
    private PrintWriter out;
    private  BufferedReader in;
    public void startConnection(String ip, int port) throws IOException{
        clientSock = new Socket(ip,port);
        out = new PrintWriter(clientSock.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSock.getInputStream()));
    }

    public  ScoreResponse sendRequest(String name, int score) throws Exception{
        out.println(ScoreRequest.toJSON(new ScoreRequest(name,score)));
        return ScoreResponse.fromJSON(in.readLine());
    }
    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSock.close();
    } public static void main(String[] args) {
        Client client = new Client();
        try {

            client.startConnection("127.0.0.1", 6000 );
            System.out.println(client.sendRequest("Lala",100).toString());
            client.stopConnection();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
