
package reloj;

public class Alarma {
    private boolean selector;
    private int horas;
    private int minutos;
    private int segundos;
    
    public void alarma(){    
    }

    public int getHoras() {
        return horas;
    }
    
    public void encendido(boolean on) {
        this.selector = on;
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
    
    
    
    
    
}
