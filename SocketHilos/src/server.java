import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) {
        //Declaracion de serversocket y socket
        ServerSocket server = null;
        Socket socket = null;

        //Declaracion de flujos de datos
        DataOutputStream out = null;
        DataInputStream in = null;

        //Declaracion de puerto
        final int PUERTO = 5225;

        try {
            //Inicializacion del serversocket
            server = new ServerSocket(PUERTO);

            System.out.println("Servidor a la espera...");

            //bucle para mantener el servidor siempre a la escucha
            while (true) {

                //Espera a que un cliente realice una peticion
                socket = server.accept(); //<-- Se bloquea esperando hasta que un cliente se conecte

                System.out.println("Cliente conectado");

                Thread.sleep(15000);
                System.out.println("Simulación de bloqueo terminada");

                //Obtiene la peticion del cliente
                in = new DataInputStream(socket.getInputStream());
                //Envia la respuesta al cliente
                out = new DataOutputStream(socket.getOutputStream());

                //lee el mensaje del cliente
                String mensaje = in.readUTF();
                System.out.println("Mensaje recibido: " + mensaje);

                //Envia la respuesta al cliente
                out.writeUTF("Hola cliente, te saludo desde el servidor");

                //Cierra los flujos de datos
                out.close();
                in.close();

                //Cierra el socket
                socket.close();
                System.out.println("Cliente desconectado");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
