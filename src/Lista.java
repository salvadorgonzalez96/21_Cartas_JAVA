import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Lista
{ //Lista Simple o Lista Interlazada

    Nodo p, u;
    Image img;
	ImageIcon icono;
	int alto;
    int ancho;
    int x, y;
    
    ImageIcon iconocarta=new ImageIcon("Imagenes/back.png");
    Image carta=iconocarta.getImage();
    
    public Lista(int x, int y) {
        p=u=null;
        this.x=x;
        this.y=y;
		this.x=x;
        this.y=y;
        //this.ancho=icono.getIconWidth();
        //this.alto=icono.getIconHeight();
    }
    
    void insertarInicio(Nodo n){
        if(estaVacia()){
            p=u=n;
        }
        else{
            n.sig = p;
            p=n;
        }
        this.x=x;
        this.y=y;
		this.x=x;
        this.y=y;
    }

    void insertarFinal(Nodo n){
        if(estaVacia()){
            insertarInicio(n);
        }
        else{
            u.sig = n;
            u=n;
        }
    }
    
    void insertarPosicion(Nodo n, int pos){
        int posicion=0;
        String cadena="";
        Nodo aux = p;
        //Lista temp = new Lista(this.x, this.y);
        
        if(pos >=0 && pos<length()){
            if(pos==0){
                /*n.sig = p;
                p=n;*/
            	insertarInicio(n);
            }
            while(aux != null){
                if(posicion == pos){
                    /*temp.*/insertarFinal(n);
                    cadena+=/*temp.u.*/toString();
                }
                    
                /*temp.*/insertarFinal(aux);
                cadena+=/*temp.*/u.toString();
                posicion++;
                aux = aux.sig;
            }
        }
        if(pos==length()){
            /*u.sig = n;
            u=n;*/
        	insertarFinal(n);
        }
    }
    
    void insertarAscendente(Nodo n){
        int posicion=0;
        String cadena="";
        Nodo temp = p;
        Lista aux = new Lista(this.x, this.y);
        int elenodo=0;
        int ele=Integer.parseInt(n.toString());
        if(ele<elenodo){
            if(posicion==0){
                n.sig = p;
                p=n;
                temp=p;
            }
            else{
                posicion=1;
                while(temp != null){
                    elenodo = Integer.parseInt(temp.info.toString());
                    if(elenodo>ele){
                        aux.insertarInicio(n);
                        cadena+=aux.u.toString();
                    }
                    aux.insertarFinal(temp);
                    cadena+=aux.u.toString();
                    posicion++;
                    temp = temp.sig;
                }
            }
            if(ele>elenodo){
                if(posicion==length()){
                    u.sig = n;
                    u=n;
                }
            }
        }
    }
    
    void insertarDescendente(Nodo n){
        int posicion=0;
        String cadena="";
        Nodo temp = p;
        Lista aux = new Lista(this.x, this.y);
        int elenodo=0;
        int ele=Integer.parseInt(n.toString());
        while(temp != null){
            elenodo = Integer.parseInt(temp.info.toString());
            if(elenodo<ele){
                aux.insertarInicio(n);
                cadena+=aux.u.toString();
            }
            aux.insertarFinal(temp);
            cadena+=aux.u.toString();
            posicion++;
            temp = temp.sig;
        }
    }
    
    void imprimir(){
        String cadena = "Informacion de Lista\n";
        Nodo temp = p;
        if(estaVacia()){
            cadena+="Esta vacio.";
        }
        while(temp != null){
            cadena+=temp.toString()+"\n";
            temp = temp.sig;
        }
        JOptionPane.showMessageDialog(null,cadena);
    }
    
    String invertir(){
        String cadena = "Lista invertida\n";
        Nodo temp ;
        int pos = length()-1;
        
        while(pos>=0){
            temp= retNodo(pos);
            cadena+=temp.toString()+"\n";
            pos--;
        }
        return cadena;
    }
    
    int retPos(Object tmp){
        int cont=0;
        int posicion =0;
        Nodo temp = p;
        
        while(temp != null){
            if(temp.info.equals(tmp)){
                posicion = cont;
            }
            cont++;
            temp = temp.sig;
        }
        return posicion;
    }
    
    Nodo retNodo(int pos){
        int tam_pos=length();
        Nodo temp = p;
        int cont=0;
        while(temp != null){
            if(cont == pos){
                return temp;
            }
            cont++;
            temp = temp.sig;
        }
        return temp;
    }
    
    int length(){
        int cont=0;
        Nodo temp = p;
        while(temp != null){
            cont++;
            temp = temp.sig;
        }
        return cont;
    }
    
    boolean estaVacia(){
        return (u==null && p==null)? true:false;
    }
    
    void eliminarLista(){
        p=u=null;
    }
    
    void eliminarPosicion2(int pos){
        Nodo aux = p;
        Nodo aux2 = p.sig;
        //Lista temp = new Lista();
        String cadena="";
        int posicion=0;
        if(pos >=0 && pos<length()){
            if(pos==0){
                p=p.sig;
            }
            else{
                posicion=0;
                while(aux != null){
                    /*if(posicion == pos){
                        if(pos==length()-1){
                            u = aux;
                            u.sig=null;
                        }
                        aux = aux.sig;
                    }*/
                    
                    /*temp.insertarFinal(aux);
                    cadena+=temp.u.toString();
                    posicion++;*/
                    aux = aux.sig;
                    aux2 = aux2.sig;
                }
                if(aux2!=null){
                    aux.sig=aux2.sig;
                    if(aux2==u){
                        u=aux;
                    }
                }
            }
        }
    }
    
    void eliminarPosicion(int pos){
        int posicion=1;
        String cadena="";
        if(!estaVacia()){
            if(p==u){
                p=u=null;
            }
            else if(pos==0){
                p=p.sig;
            }
            else{
                Nodo anterior,temp;
                anterior=p;
                temp= p.sig;
                while(temp!=null && posicion!=pos){
                    anterior=anterior.sig;
                    temp=temp.sig;
                    posicion++;
                }
                if(temp!=null){
                    anterior.sig=temp.sig;
                    if(temp==u){
                        u=anterior;
                    }
                }
            }
        }
    }
    
    public int contar(Object v){
        int cont=0;
        Nodo temp = p;
        
        while(temp != null){
            if(temp.info.equals(v)){
                cont++;
            }
            temp = temp.sig;
        }
        return cont;
    }
    
    public void dibujar(Graphics g){
    	if(estaVacia()){
    		g.drawImage(this.carta, this.x, this.y,null);
    	}
    }

	void mover() {}
	
	public void setX(int x){this.x=x;}
    public int getX(){return x;}
    public void setY(int y){this.y=y;}
    public int getY(){return y;}
}
