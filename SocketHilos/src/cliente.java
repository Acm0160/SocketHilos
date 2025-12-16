import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class cliente {
    public static void main(String[] args) {

        //Host del servidor
        final String HOST = "localhost";  // tambien puedes usar "127.0.0.1"

        //puerto del servidor
        final int PUERTO = 5225;

        DataInputStream in = null;
        DataOutputStream out = null;

        try {
            Socket socket = new Socket(HOST, PUERTO);

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            //Envia el mensaje al servidor
            out.writeUTF("Hola servidor, te saludo desde el cliente");

            //Recibimos la respuesta del servidor
            String mensaje = in.readUTF();
            System.out.println("Mensaje recibido: " + mensaje);

            //Cerramos el socket
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
