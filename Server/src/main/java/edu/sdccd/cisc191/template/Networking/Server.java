package edu.sdccd.cisc191.template.Networking;

import edu.sdccd.cisc191.template.GameAssets.ViewGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSock;
    private Socket clientSock;
    private PrintWriter out;
    private BufferedReader in;
    public void start(int port) throws Exception {
        serverSock = new ServerSocket(port);
        clientSock = serverSock.accept();

        out = new PrintWriter(clientSock.getOutputStream(), true); //send to client both strings
        in = new BufferedReader(new InputStreamReader(clientSock.getInputStream())); //read what client sends

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            ScoreRequest request = ScoreRequest.fromJSON(inputLine);
            ScoreResponse response = new ScoreResponse(request.getScore(),request.getName());
            out.println(ScoreResponse.toJSON(response));
        }

        } //makes server socket that accepts client

        public void stop() throws IOException{
        in.close();
         clientSock.close();
         serverSock.close();
    }
    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.start(5000);
            server.stop();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    }


