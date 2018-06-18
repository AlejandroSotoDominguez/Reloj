package reloj;

import java.util.Calendar;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

public class Despertador {

    Timer timer;
    static int horas, minutos, segundos, incHoras, incMinutos, modHoras, modMinutos;
    static boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        new Despertador();
        
        Hora h = new Hora();
        Display d = new Display();
        int opcion = 0;
        Calendar calendario = Calendar.getInstance();  

        
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(""
                    + "1. Incrementar hora \n"
                    + "2. Incrementar minutos \n"
                    + "3. Cambiar alarma \n"
                    + "4. Parar alarma \n"
                    + "5. Cambiar hora \n"
            ));

            switch (opcion) {
                case 1:
                    modHoras=1;
                    break;
                case 2:
                    modMinutos=1;
                    break;
                case 3:
                    int horasAlarma = Integer.parseInt(JOptionPane.showInputDialog("Hora alarma"));
                    int minutosAlarma = Integer.parseInt(JOptionPane.showInputDialog("Minutos alarma"));
                    Alarma a = new Alarma();
                    a.setHoras(horasAlarma);
                    a.setMinutos(minutosAlarma);

                    break;
                    
                case 5:
                    int cambiarHora,cambiarMinutos;
                    
                    cambiarHora = Integer.parseInt(JOptionPane.showInputDialog(null, "cambiar hora"));
                    cambiarMinutos = Integer.parseInt(JOptionPane.showInputDialog(null, "cambiar minutos"));
                    
                    if(cambiarHora<=23 && cambiarHora>=1){
                        Hora ho = new Hora();
                        ho.setHoras(cambiarHora);
                    }if(cambiarMinutos<=59 && cambiarHora>=1){
                        modMinutos=cambiarMinutos;
                        minutos=modMinutos;
                    }
  
                default:
                    stop=true;
                    break;
            }

        } while (opcion != 0);
        
    }


/**
 * Constructor de la clase principal
 */
public Despertador() {
        
        //creamos un Timer
        timer = new Timer();
        //con el Timer ejecutamos la tarea TicTac, con un retardo de 0sg y repetimos cada 1sg
        timer.schedule(new TicTac(), 0, 1000);
        Alarma a = new Alarma();
    if(Calendar.HOUR_OF_DAY==a.getHoras()){
            System.out.println("BEEP!!");
            
        }    
        
}

    /**
     * Inner class para la tarea en segundo plano (hilo)
     * Extiende de TimerTask para poder ejecutarlo desde el Timer
     */
    public class TicTac extends TimerTask {

    @Override
    public void run() {
        Calendar calendario = Calendar.getInstance();

        Hora h = new Hora();
        h.setHoras(calendario.get(Calendar.HOUR_OF_DAY));
        
        horas=h.getHoras()+modHoras;
        minutos = calendario.get(Calendar.MINUTE)+modMinutos;
        segundos = calendario.get(Calendar.SECOND);
        
        if(stop == true){
            timer.cancel();
            timer.purge();
        }
        
        System.out.println(horas + ":" + minutos + ":" + segundos);
        
        Display d = new Display();
        
        Alarma a = new Alarma();
        
        if(horas==a.getHoras() && minutos==a.getMinutos()){
            Display.alarma(horas, minutos);
        }
    }
}
}
