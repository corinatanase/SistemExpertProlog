/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exempluinterfataprolog;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Talida
 */
public class ExpeditorMesaje extends Thread{
    Socket s;
    CititorMesaje cm;
    volatile PipedOutputStream pos = null;
    volatile PipedInputStream pis;
    OutputStream ostream;
    volatile boolean gata = false;

    //setteri sincronizati
    public final synchronized void setPipedOutputStream(PipedOutputStream _pos){
        pos = _pos;
        notify();
    }
    
    //getteri sincronizati
    public synchronized PipedOutputStream getPipedOutputStream() throws InterruptedException{
        if(pos == null){
            wait();
        }
        return pos;
    }    
    
    
    public ExpeditorMesaje(CititorMesaje _cm) throws IOException{
        cm = _cm;
        pis = new PipedInputStream(50000);
        setPipedOutputStream(new PipedOutputStream(pis));

    }
    
    public void trimiteMesajSicstus(String mesaj) throws InterruptedException{
        PipedOutputStream pos = getPipedOutputStream();
        PrintStream ps=new PrintStream(pos);
        ps.println(mesaj+".");
        ps.flush();
    }

    public void trimiteSirSicstus(String mesaj) throws InterruptedException{
        PipedOutputStream pos = getPipedOutputStream();
        PrintStream ps=new PrintStream(pos);
        ps.println(mesaj);
        ps.flush();
    }
    
    public void run(){
        try {
            s = cm.getSocket();
            ostream = s.getOutputStream();
            int chr;
            while((chr = pis.read()) != -1){
                ostream.write(chr);
            }
            System.out.println("gata");
            
        
        } catch (IOException ex) {
            Logger.getLogger(ExpeditorMesaje.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ExpeditorMesaje.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
