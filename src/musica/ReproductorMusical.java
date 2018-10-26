package musica;

import java.util.ArrayList;

public class ReproductorMusical {

    private ListaDeReproduccion lista;
    private boolean ordenAleatorio = false;
    private boolean repeticion = false;
    
    public ReproductorMusical() {
        this.lista = new ListaDeReproduccion();
    }
    
    public void agregarCancion(Cancion cancion) {
        this.lista.agregar(cancion);
    }
    
    public void agregarCanciones(ArrayList<Cancion> canciones) {
        canciones.forEach((cancion) -> {
            this.lista.agregar(cancion);
        });
    }
    
    public void duracionTotalDeReproduccion(){
        int duracion = this.lista.revisarTiempoDeCanciones();
        if (duracion == 0) {
            System.out.println("No hay canciones en la lista");
        } else {
            int minutos = (int) Math.floor(duracion/60);
            int segundos = duracion - (minutos*60);
            System.out.println("Duracion Total de Lista de Reproduccion: " + minutos + "\'" + segundos + "\"\n");
        }
    }
    
    public void activarOrdenAleatorio() {
        this.ordenAleatorio = !this.ordenAleatorio;
    }
    
    public void activarRepetir () {
        this.repeticion = !this.repeticion;
    }
    
    public void reproducir() {
        int i;
        
        if (this.ordenAleatorio) {
            System.out.println("Orden Aleatorio: ACTIVADO\n");
        } else {
            System.out.println("Orden Aleatorio: DESACTIVADO\n");
        }
        
        if (this.repeticion) {
            System.out.println("Repetición: ACTIVADA\n");
        } else {
            System.out.println("Repetición: DESACTIVADA\n");
        }
        
        if(this.repeticion && this.ordenAleatorio) {
            for (i = 0; i < 5; i++) {
                reproducirAleatorio();
            }
        } else if(this.repeticion) {
            for (i = 0; i < 5; i++) {
                Cancion cancion = this.lista.primeraCancion();
                while(cancion != null) {
                    reproducir(cancion);
                    cancion = this.lista.siguienteCancion();
                }
            }
        } else if(this.ordenAleatorio) {
            reproducirAleatorio();
        } else {
            Cancion cancion = this.lista.primeraCancion();
            while(cancion != null) {
                reproducir(cancion);
                cancion = this.lista.siguienteCancion();
            }
        }
    }
            
    private void reproducir(Cancion cancion) {
        int duracion = cancion.getDuracion();
        int minutos = (int) Math.floor(duracion/60);
        int segundos = duracion - (minutos*60);
        System.out.println(cancion.getNombre() + " - " + minutos + "\'" + segundos + "\"");
    }
    
    public void reproducirAleatorio() {
        int j = 0;
        Cancion cancion = this.lista.cancionAleatoria();
        while (j < 5 && cancion != null) {
            reproducir(cancion);
            cancion = this.lista.cancionAleatoria();
            j++;
        }
    }
}
