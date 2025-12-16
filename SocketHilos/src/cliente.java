import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

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
            Scanner sc = new Scanner(System.in);

            String mensaje = "";

            // 🔁 BUCLE DE CONVERSACIÓN
            while (!mensaje.equalsIgnoreCase("FIN")) {

                System.out.print("Escribe mensaje: ");
                mensaje = sc.nextLine();

                out.writeUTF(mensaje);

                if (!mensaje.equalsIgnoreCase("FIN")) {
                    String respuesta = in.readUTF();
                    System.out.println("Servidor dice: " + respuesta);
                }
            }

            //Cerramos el socket
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
