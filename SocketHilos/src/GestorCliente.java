import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

public class GestorCliente implements Runnable {

    private Socket socket;

    public GestorCliente(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String mensaje = "";

            while (!mensaje.equalsIgnoreCase("FIN")) {
                mensaje = in.readUTF();
                System.out.println("[" + socket.getInetAddress() + "] dice: " + mensaje);

                if (!mensaje.equalsIgnoreCase("FIN")) {
                    out.writeUTF("Recibido: " + mensaje);
                }
            }

            System.out.println("El cliente " + socket.getInetAddress() + " ha enviado FIN.");
            socket.close();

        } catch (EOFException e) {
            System.out.println("Cliente " + socket.getInetAddress() + " se ha desconectado inesperadamente.");
        } catch (IOException e) {
            System.out.println("Cliente " + socket.getInetAddress() + " se ha desconectado inesperadamente.");
        }
    }
}
