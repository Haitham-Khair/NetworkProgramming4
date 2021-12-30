import java.util.*;
import java.net.*;
import java.io.*;

public class TcpClient {
    public static void main(String[]args) throws IOException {
        try{

            Socket s=new Socket("localhost",6666);
            DataOutputStream dos=new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());
            Scanner in =new Scanner(System.in);
            String name="",pass="",Usermessage="",passmessage="",message;
            boolean accept=true,accepmessage=false;
            while(!accepmessage){
                Usermessage=dis.readUTF().toString();
                System.out.print(Usermessage);
                name=in.nextLine();
                dos.writeUTF(name);
                passmessage=dis.readUTF().toString();
                System.out.print(passmessage);
                pass=in.nextLine();
                dos.writeUTF(pass);;
                accepmessage=dis.readBoolean();
                message=dis.readUTF().toString();
                System.out.println(message);

            }
        }
        catch(IOException e){
            System.out.println("error with  the clinet class");


        }
    }
    }
