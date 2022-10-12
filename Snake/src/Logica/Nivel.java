package Logica;
//Dani
public class Nivel {
	
    Entidad[][] nivel;
    LevelReader reader = new LevelReader();

    public Nivel(){
        nivel  = new Entidad[20][20];
        for(int x = 0; x < nivel.length; x++){
            for(int y = 0; y < nivel[0].length; y++){
                nivel[x][y]=new Celda(x,y);
            }
        }
    }

    public void modificar(int x, int y, Entidad ent){
        nivel[x][y]= ent;
    }

    public void buildNivel(){
        nivel = reader.buildNivel(this);
    }

    public Posicion generatePosicionValida(){//<-dentro de esto una entidad

        //crea una posicion random para la comida
        int posX = (int) ((Math.random() * (19 - 1)) + 1);
        int posY = (int) ((Math.random() * (19 - 1)) + 1);
        //dentro del while reemplazar por un visitor
        while(nivel[posX][posY].url.equals(App.class.getResource("wallcell.png").getPath())){//si es una pared
            //haces reroll
            posX = (int) ((Math.random() * (19 - 1)) + 1);
            posY = (int) ((Math.random() * (19 - 1)) + 1);  
        }

        return new Posicion(posX, posY);
    }

    public void agregarComida(){
        Posicion posicion = generatePosicionValida();
        nivel[posicion.getX()][posicion.getY()] = new Alimento(posicion.getX(), posicion.getY());
    }

    public Entidad[][] getNivel(){return nivel;}
    public int getAncho(){return nivel.length;}
    public int getAlto(){return nivel[0].length;}
    public Entidad getEntidad(int x, int y){return nivel[x][y];}

    public void display() {

        System.out.println("Iniciando Display=====================");
        String urlAlimento = App.class.getResource("foodcell.png").getPath();
        String urlPared = App.class.getResource("wallcell.png").getPath();
        String urlcell = App.class.getResource("bgcell.png").getPath();


        /*
         * System.out.println("URL base:     +");
        System.out.println(urlAlimento);
        System.out.println(urlPared);
        System.out.println(urlcell);
        System.out.println("+++++++++++++++++++++++++++++++++");
        */
        for (int i = 0; i < nivel.length; i++) {
          // Loop through all elements of current row
          for (int j = nivel[i].length - 1; j >= 0; j--) {
            //System.out.println("Posicion: ("+i +","+j);
            if(nivel[i][j].getURL().equals(urlAlimento)){
                System.out.print('o');
                //System.out.println(" = "+ nivel[i][j].getUrl());
            }else
            if(nivel[i][j].getURL().equals(urlPared)){
                System.out.print('x');
               // System.out.println(" = "+ nivel[i][j].getUrl());
            }else
            if(nivel[i][j].getURL().equals(urlcell)){
                System.out.print('#');
                //System.out.println(" = "+ nivel[i][j].getUrl());
            }else{
                System.out.print("S");
                //System.out.println(" = "+ nivel[i][j].getUrl());
            }

          }
    
          System.out.println();
        }
        System.out.println("nivela de: " + nivel.length + "x" + nivel[0].length);
        //System.out.println("Cant de comida: " + comida.size());
        //System.out.println("Cant de muros: " + muro.size());
        System.out.println("comida (1,18): " + nivel[1][18].getURL()); //deberia ser '@'
        System.out.println("(0,19): " + nivel[0][19].getURL()); //deberia ser 'a'
        System.out.println("(19,19): " + nivel[19][19].getURL()); //deberia ser 'b'
        System.out.println("(0,0): " + nivel[0][0].getURL()); //deberia ser 'c'
        System.out.println("(19,0): " + nivel[19][0].getURL()); //deberia ser 'd'
        
      }

      public static void main(String[] args) {
        Nivel nivel = new Nivel();
        nivel.buildNivel();
        nivel.display();

        System.out.println("Fin de la ejecución |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
      }
}
