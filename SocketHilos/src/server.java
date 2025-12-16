import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

    public static void main(String[] args) {
        final int PUERTO = 5225;

        try {
            ServerSocket servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado...");

            while (true) {
                Socket socket = servidor.accept();
                System.out.println("Cliente conectado desde: " + socket.getInetAddress());

                // Lanza un hilo por cliente
                GestorCliente gestor = new GestorCliente(socket);
                new Thread(gestor).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}