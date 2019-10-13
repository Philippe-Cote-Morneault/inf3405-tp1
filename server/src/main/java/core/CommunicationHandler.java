package core;

import communication.Message;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class CommunicationHandler {
    private boolean fAcceptClientCommunication;
    private Socket fSocket;
    public CommunicationHandler(Socket socket)
    {
        fAcceptClientCommunication = false;
        fSocket = socket;
    }

    public Message receiveMessage()
    {
        System.out.println("Waiting for message");
        ObjectInputStream inStream = null;
        try {
            inStream = new ObjectInputStream(fSocket.getInputStream());
            return (Message) inStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erreur lors de la réception d'une réponse du serveur! Erreur complète:");
            System.out.println(e.toString());
            return null;
        } finally {
            //if (inStream != null) inStream.close();
        }
    }

    public void sendMessage(Message message){

    }

    public void sendFile(String filePath)
    {

    }

    public void receiveFile(String fileName)
    {

    }




}