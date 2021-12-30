import java.util.*;
import java.net.*;
import java.io.*;

public class TcpServer {
    public static void main(String[]args) throws IOException{
      try {
          
          ServerSocket ss = new ServerSocket(6666);
          Socket s = ss.accept();
          DataOutputStream dos = new DataOutputStream(s.getOutputStream());//and that for sending
          DataInputStream dis = new DataInputStream(s.getInputStream());
          Scanner in=new Scanner(System.in);
          String name="",pass="",message="";
          boolean acc=true;
          while(true){
              dos.writeUTF("Enter Your UserName and must be more than 9 charachter: ");
              name=dis.readUTF().toString();
              dos.writeUTF("Enter Your Password and that must be more than 7 character: ");
              pass=dis.readUTF().toString();
              if(name.length()>9 &&pass.length()>7)
              {
                  dos.writeBoolean(true);
                  dos.writeUTF("username : "+name + "  and  password "+pass+"  are valid");
                  break;
              }
              else
              {
                  dos.writeBoolean(false);
                  dos.writeUTF("invalid username or password please enter them again");

              }



          }
      }
                catch(IOException e){

                    System.out.println("error with the server class");
        }
    }

}
