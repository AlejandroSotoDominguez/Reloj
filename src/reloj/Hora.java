
package reloj;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

public class Hora {
    private int horas;
    private int minutos;
    private int segundos;

    public Hora() {
    }

    public Hora(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public void cambiarHora(){
        int cambiarHora = Integer.parseInt(JOptionPane.showInputDialog("cambiar hora"));
        int cambiarMinutos = Integer.parseInt(JOptionPane.showInputDialog("cambiar minutos"));
        int cambiarSegundos = Integer.parseInt(JOptionPane.showInputDialog("cambiar segundos"));

        horas = cambiarHora;
        minutos = cambiarMinutos;
        segundos = cambiarSegundos;
    }
    
    public void cambiarAlarma(){
        int horas = Integer.parseInt(JOptionPane.showInputDialog("cambiar hora"));
        int minutos = Integer.parseInt(JOptionPane.showInputDialog("cambiar minutos"));
        int segundos = Integer.parseInt(JOptionPane.showInputDialog("cambiar segundos"));
    }
    
}
