package musica;

import java.util.ArrayList;

public class Musica {

    public static void main(String[] args) {
        ReproductorMusical reproductor = new ReproductorMusical();
        
        Cancion moonchild = new Cancion("Moonchild", 340);
        Cancion theEvilThatMenDo = new Cancion("The Evil That Men Do", 275);
        
        reproductor.agregarCancion(moonchild);
        reproductor.agregarCancion(theEvilThatMenDo);
        
        ArrayList<Cancion> canciones = new ArrayList<>();
        Cancion fearOfTheDark = new Cancion("Fear Of The Dark", 438);
        canciones.add(fearOfTheDark);
        Cancion theTrooper = new Cancion("The Trooper", 264);
        canciones.add(theTrooper);
        Cancion twoMinutesToMidnight = new Cancion("2 Minutes To Midnight", 369);
        canciones.add(twoMinutesToMidnight);
        Cancion acesHigh = new Cancion("Aces High", 300);
        canciones.add(acesHigh);
        Cancion hallowedBeThyName = new Cancion("Hallowed Be Thy Name", 431);
        canciones.add(hallowedBeThyName);
        
        reproductor.agregarCanciones(canciones);
        
        reproductor.duracionTotalDeReproduccion();
                
        reproductor.activarOrdenAleatorio();
        reproductor.activarRepetir();
        
        reproductor.reproducir();
        
    }
    
}

