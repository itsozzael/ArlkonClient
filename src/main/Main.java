package main;

import implementations.Client;
import interfaces.ClientInterface;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.rmi.Naming;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../views/main.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        connectToServer();
        launch(args);
    }

    public static void connectToServer(){
        try {
            System.out.println("CLIENT SIDE");

            ClientInterface client = new Client(1);
            ClientInterface server = (ClientInterface) Naming.lookup("//192.168.1.110:1099/arlkon");

            System.setProperty("java.security.policy","../security.policy");

            String msg="["+client.getId()+"] got connected";
            server.send(msg);

            System.out.println("[System] Chat Remote Object is ready:");
            server.setClient(client);

            msg = "" + server.getId();
            msg = "[" + client.getId() + "] " + msg;

            server.send(msg);
        } catch (Exception e) {
            System.out.println("[System] Server failed: " + e);
        }
    }
}
