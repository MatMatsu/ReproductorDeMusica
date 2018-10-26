package musica;

import java.util.ArrayList;

public class ListaDeReproduccion {

    private ArrayList<Cancion> canciones;
    private int indice;
    private int duracionTotal = 0;
    
    public ListaDeReproduccion() {
        this.canciones = new ArrayList<Cancion>();
    }
    
    public void agregar(Cancion cancion) {
        this.canciones.add(cancion);
    }
    
    public Cancion primeraCancion() {
        if(this.canciones.size() == 0) {
            return null;
        }
        else {
            this.indice = 0;
            return this.canciones.get(0);
        }
    }
    
    public Cancion siguienteCancion() {
        if(this.indice+1 >= this.canciones.size()) {
            return null;
        }
        else {
            this.indice = this.indice + 1;
            return this.canciones.get(this.indice);
        }
    }

    public int revisarTiempoDeCanciones() {
        if (this.canciones.isEmpty()) {
            return 0;
        } else {
            for (int i = 0; i < this.canciones.size(); i++) {
                this.duracionTotal += this.canciones.get(i).getDuracion();
            }
            return this.duracionTotal;
        }
    }

    Cancion cancionAleatoria() {
        int aux;
        
        if(this.canciones.size() == 0) {
            return null;
        } else {
            aux = this.indice;
            while(aux == this.indice){
                this.indice = (int) Math.floor(Math.random()*this.canciones.size());
            }
            return this.canciones.get(this.indice);
        }
    }
}
