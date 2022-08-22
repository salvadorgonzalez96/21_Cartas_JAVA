import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.Image;
import java.util.Random;
import java.awt.Rectangle;

public class Escenario extends JPanel implements ActionListener, KeyListener 
{

	Lista deck;
	Lista l1;
	Lista l2;
	Lista l3;
	Lista l4;
	Lista l5;
	
	Lista l6;
	Lista l7;
	Lista l8;
	Lista l9;
	Lista l10;
	
	Lista back;
	
	ImageIcon icono;
    Image fondo;
    ImageIcon iconowin;
    Image fondowin;
    Timer t;
    
    int posicion=0;
    
    int ne=1;
    int nt=1;
    int nc=1;
    int nd=1;
    
    int puntos=0;
    int puntoso=0;
    
    int gano=0;
    boolean parar = false;
    
    int numcarta[] = {1,2,3,4,5,6,7,8,9,10,11,12,13};
	char tipocarta[] = {'e','t','c','d'};
	
	public Escenario() {
		icono=new ImageIcon("Imagenes/fondo.png");
        fondo=icono.getImage();
        
        iconowin = new ImageIcon("Imagenes/win.jpg");
        fondowin = iconowin.getImage();
        
		deck = new Lista(650,225);
		
		for(int i=0; i<tipocarta.length; i++){
			for(int j=0; j< numcarta.length; j++){
				deck.insertarFinal(new Nodo ( new Carta ( numcarta[j], tipocarta[i], deck.getX(), deck.getY() ) ) );
			}
		}
		
		l6 = new Lista(50,100);
        l7= new Lista(170,100);
        l8= new Lista(290,100);
        l9 = new Lista(410,100);
        l10 = new Lista(530,100);

        l1 = new Lista(50,370);
        l2= new Lista(170,370);
        l3= new Lista(290,370);
        l4 = new Lista(410,370);
        l5 = new Lista(530,370);
        
        back = new Lista(650,225);

        if(ne==14 && nt==14 && nc==14 && nd==14){
        	gano=1;
        }

        setSize(900,700);
        setVisible(true);
        t=new Timer(5,null);
        t.addActionListener(this);
        t.start();
        
        addKeyListener(this);
        setFocusable(true);
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.fondo,0,0,this);
        
        deck.dibujar(g);
        //Usuario
        l1.dibujar(g2d);
        l2.dibujar(g2d);
        l3.dibujar(g2d);
        l4.dibujar(g2d);
        l5.dibujar(g2d);
        
        //Oponente
        l6.dibujar(g2d);
        l7.dibujar(g2d);
        l8.dibujar(g2d);
        l9.dibujar(g2d);
        l10.dibujar(g2d);
        
        dibujarcartadeck(g);
        //Usuario
        dibujarcartal1(g);
        dibujarcartal2(g);
        dibujarcartal3(g);
        dibujarcartal4(g);
        dibujarcartal5(g);
        
        //Oponente
        dibujarcartal6(g);
        dibujarcartal7(g);
        dibujarcartal8(g);
        dibujarcartal9(g);
        dibujarcartal10(g);
        
        back.dibujar(g2d);
        
        if(gano==1){
            //g2d.drawImage(this.fondowin,0,0,this);
        	if(puntos>31 && puntoso>31){
        		g.setColor(Color.WHITE);
    			g.setFont( new Font( "ARIAL", Font.BOLD, 60 ) );
                g.drawString("Fuera de Juego!",100,280);
        	}
        	else if(puntos<puntoso){
        		if(puntoso>31){
        			g.setColor(Color.WHITE);
        			g.setFont( new Font( "ARIAL", Font.BOLD, 60 ) );
                	g.drawString("Ganaste!",250,280);
                }
        		else{
        			g.setColor(Color.WHITE);
        			g.setFont( new Font( "ARIAL", Font.BOLD, 60 ) );
                    g.drawString("Perdiste!",250,280);
        		}
        	}
        	else if(puntos>puntoso){
        		if(puntos>31){
        			g.setColor(Color.WHITE);
        			g.setFont( new Font( "ARIAL", Font.BOLD, 60 ) );
                	g.drawString("Perdiste!",250,280);
                }
        		else{
        			g.setColor(Color.WHITE);
                    g.setFont( new Font( "ARIAL", Font.BOLD, 60 ) );
                    g.drawString("Ganaste!",250,280);
        		}
        	}
        	else if(puntos==puntoso){
        		g.setColor(Color.WHITE);
                g.setFont( new Font( "ARIAL", Font.BOLD, 60 ) );
                g.drawString("Empate!",250,280);
        	}
        }
        
        g.setColor(Color.WHITE);
        g.setFont( new Font( "ARIAL", Font.BOLD, 18 ) );
        //Oponente
        g.drawString("1",80,70);
        g.drawString("2",200,70);
        g.drawString("3",315,70);
        g.drawString("4",440,70);
        g.drawString("5",560,70);
        g.drawString("Puntos (Oponente)",670,130);
        g.drawString(""+puntoso,670,160);
        
        //Usuario
        g.drawString("1",80,340);
        g.drawString("2",200,340);
        g.drawString("3",315,340);
        g.drawString("4",440,340);
        g.drawString("5",560,340);
        g.drawString("Puntos (Usuario)",670,400);
        g.drawString(""+puntos,670,430);
        
        g.drawString("Baraja",730,280);
        g.drawString("Instrucciones",350,535);
        g.drawString("Barra Espaciadora: Pedir",50,570);
        g.drawString("Shift: Paso o terminar la jugada",50,600);
        g.drawString("Esc: Salir (Cerrar Juego)",550,570);
       
		repaint();
	}

	public void dibujarcartadeck(Graphics g){
		if(deck!=null){
			Nodo temp = (Nodo) deck.retNodo(posicion);
			if(temp!=null){
				Carta c = (Carta) temp.info;
				c.dibujar(g);
			}
		}
		else{
			deck.dibujar(g);
		}
	}

	//Usuario
	//---------------------------------------------------------------------------------------------
	public void dibujarcartal1(Graphics g){
		Nodo temp1 = (Nodo) l1.p;
		if(temp1!=null){
			Carta c1 = (Carta) temp1.info;
			c1.dibujar(g);
		}
	}

	public void dibujarcartal2(Graphics g){
		Nodo temp2 = (Nodo) l2.p;
		if(temp2!=null){
			Carta c2 = (Carta) temp2.info;
			c2.dibujar(g);
		}
	}
	
	public void dibujarcartal3(Graphics g){
		Nodo temp3 = (Nodo) l3.p;
		if(temp3!=null){
			Carta c3 = (Carta) temp3.info;
			c3.dibujar(g);
		}
	}
	
	public void dibujarcartal4(Graphics g){
		Nodo temp4 = (Nodo) l4.p;
		if(temp4!=null){
			Carta c4 = (Carta) temp4.info;
			c4.dibujar(g);
		}
	}
	
	public void dibujarcartal5(Graphics g){
		Nodo temp5 = (Nodo) l5.p;
		if(temp5!=null){
			Carta c5 = (Carta) temp5.info;
			c5.dibujar(g);
		}
	}
	//---------------------------------------------------------------------------------------------
	
	//Oponente
	//---------------------------------------------------------------------------------------------
	public void dibujarcartal6(Graphics g){
		Nodo temp6 = (Nodo) l6.p;
		if(temp6!=null){
			Carta c6 = (Carta) temp6.info;
			c6.dibujar(g);
		}
	}
	
	public void dibujarcartal7(Graphics g){
		Nodo temp7 = (Nodo) l7.p;
		if(temp7!=null){
			Carta c7 = (Carta) temp7.info;
			c7.dibujar(g);
		}
	}
	
	public void dibujarcartal8(Graphics g){
		Nodo temp8 = (Nodo) l8.p;
		if(temp8!=null){
			Carta c8 = (Carta) temp8.info;
			c8.dibujar(g);
		}
	}
	
	public void dibujarcartal9(Graphics g){
		Nodo temp9 = (Nodo) l9.p;
		if(temp9!=null){
			Carta c9 = (Carta) temp9.info;
			c9.dibujar(g);
		}
	}
	
	public void dibujarcartal10(Graphics g){
		Nodo temp10 = (Nodo) l10.p;
		if(temp10!=null){
			Carta c10 = (Carta) temp10.info;
			c10.dibujar(g);
		}
	}
	//---------------------------------------------------------------------------------------------
	
	public void keyPressed(KeyEvent ev) {
		int boton = ev.getKeyCode();
		
		if(boton == 16){//Shift
            gano=1;
            parar=true;
        }
		if(!parar){
	        if(boton == 32){//Barra Espaciadora
	        	int posicionalea = aleatorio(-1,deck.length()-1);
	        	Nodo temp = (Nodo) deck.retNodo(posicionalea);
		    	Carta c = (Carta) temp.info;
		    	//Usuario
		    	//-------------------------------------------------------------------------------------------
		    	if(l1.estaVacia()){
		    		l1.insertarInicio(new Nodo( new Carta ( c.numero, c.tipo, l1.getX(), l1.getY() )));
					deck.eliminarPosicion(posicionalea);
					//JOptionPane.showMessageDialog(null, c.numero +""+ c.tipo);
					puntos+=c.numero;
		    	}
		    	else if(l2.estaVacia()){
		    		l2.insertarInicio(new Nodo( new Carta ( c.numero, c.tipo, l2.getX(), l2.getY() )));
					deck.eliminarPosicion(posicionalea);
					//JOptionPane.showMessageDialog(null, c.numero +""+ c.tipo);
					puntos+=c.numero;
		    	}
		    	else if(l3.estaVacia()){
		    		l3.insertarInicio(new Nodo( new Carta ( c.numero, c.tipo, l3.getX(), l3.getY() )));
					deck.eliminarPosicion(posicionalea);
					//JOptionPane.showMessageDialog(null, c.numero +""+ c.tipo);
					puntos+=c.numero;
		    	}
		    	else if(l4.estaVacia()){
		    		l4.insertarInicio(new Nodo( new Carta ( c.numero, c.tipo, l4.getX(), l4.getY() )));
					deck.eliminarPosicion(posicionalea);
					//JOptionPane.showMessageDialog(null, c.numero +""+ c.tipo);
					puntos+=c.numero;
		    	}
		    	else if(l5.estaVacia()){
		    		l5.insertarInicio(new Nodo( new Carta ( c.numero, c.tipo, l5.getX(), l5.getY() )));
					deck.eliminarPosicion(posicionalea);
					//JOptionPane.showMessageDialog(null, c.numero +""+ c.tipo);
					puntos+=c.numero;
		    	}
		    	//-------------------------------------------------------------------------------------------
		    	
		    	int posicionalea2 = aleatorio(-1,deck.length()-1);
	        	Nodo temp2 = (Nodo) deck.retNodo(posicionalea2);
		    	Carta c2 = (Carta) temp2.info;
		    	//Oponente
		    	//-------------------------------------------------------------------------------------------
		    	if(l6.estaVacia()){
		    		l6.insertarInicio(new Nodo( new Carta ( c2.numero, c2.tipo, l6.getX(), l6.getY() )));
					deck.eliminarPosicion(posicionalea2);
					//JOptionPane.showMessageDialog(null, c2.numero +""+ c2.tipo);
					puntoso+=c2.numero;
		    	}
		    	else if(l7.estaVacia()){
		    		l7.insertarInicio(new Nodo( new Carta ( c2.numero, c2.tipo, l7.getX(), l7.getY() )));
					deck.eliminarPosicion(posicionalea2);
					//JOptionPane.showMessageDialog(null, c2.numero +""+ c2.tipo);
					puntoso+=c2.numero;
		    	}
		    	else if(l8.estaVacia()){
		    		l8.insertarInicio(new Nodo( new Carta ( c2.numero, c2.tipo, l8.getX(), l8.getY() )));
					deck.eliminarPosicion(posicionalea2);
					//JOptionPane.showMessageDialog(null, c2.numero +""+ c2.tipo);
					puntoso+=c2.numero;
		    	}
		    	else if(l9.estaVacia()){
		    		l9.insertarInicio(new Nodo( new Carta ( c2.numero, c2.tipo, l9.getX(), l9.getY() )));
					deck.eliminarPosicion(posicionalea2);
					//JOptionPane.showMessageDialog(null, c2.numero +""+ c2.tipo);
					puntoso+=c2.numero;
		    	}
		    	else if(l10.estaVacia()){
		    		l10.insertarInicio(new Nodo( new Carta ( c2.numero, c2.tipo, l10.getX(), l10.getY() )));
					deck.eliminarPosicion(posicionalea2);
					//JOptionPane.showMessageDialog(null, c2.numero +""+ c2.tipo);
					puntoso+=c2.numero;
		    	}
		    	//-------------------------------------------------------------------------------------------
	        }
		}
        
        if(boton == 27){
        	System.exit(0);
        }
	}

	public void keyReleased(KeyEvent ev) {}

	public void keyTyped(KeyEvent ev) {}

	public void actionPerformed(ActionEvent e) {
		if(puntos>31){
			gano=1;
		}
		if(puntoso>31){
			gano=1;
		}
	}

	public int aleatorio(int d, int h){
        return ((int )(Math.random()*(h-d+1)+d));
    }
}
