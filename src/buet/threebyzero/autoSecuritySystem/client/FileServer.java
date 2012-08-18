package buet.threebyzero.autoSecuritySystem.client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import android.os.Environment;
import android.util.Log;



public class FileServer {	
	
	public int port = 5554;
	public Socket client;
	public FileInputStream inputSt;	
	private String fileName;
	private ServerSocket sv;
	private Socket connection;
	private File fileToSend;
	private BufferedInputStream bufferedInput;
	private InputStream fileInputSt;
	byte[] mybytearray;
	private File fileSend;
	public FileServer()  {	
		
		 {
			 File sdFileName=Environment.getExternalStorageDirectory();
			BufferedOutputStream bufferedOutput = null;
			try {
				 sv=new ServerSocket(port);
				 fileName="photo1.JPG";
				 connection =sv.accept();
				bufferedOutput = new BufferedOutputStream(
						connection.getOutputStream());
				 fileToSend = new File(this.fileName);
				 mybytearray = new byte[(int) fileToSend.length()];
				 fileInputSt = null;
				try {				
					fileSend=new File(this.fileName); 
					fileInputSt=new FileInputStream(fileSend);
				
				} catch (FileNotFoundException ex) {
					Log.d("problem:","much");
				}
			} catch (IOException ex) {	
			
			if (fileInputSt != null) {
				
				 bufferedInput = new BufferedInputStream(fileInputSt);
				try {
					Log.d("name:","hello");
					bufferedInput.read(mybytearray, 0, mybytearray.length);
					bufferedOutput.write(mybytearray, 0, mybytearray.length);
					bufferedOutput.flush();
					bufferedOutput.close();
					return;
				} catch(Exception e1)
				{
					
				}
				finally{
					try {
						connection.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						sv.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			else
			{
				Log.d("pro  sdsd  blem:","much");
			}
			
		}
	}
	}
}
