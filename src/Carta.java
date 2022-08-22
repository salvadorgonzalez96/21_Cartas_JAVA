import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Carta{

	Image img;
	ImageIcon icono;
	int alto;
    int ancho;
    int x, y;
    
	char tipo;
	int numero;
	
	public Carta() {
		//super(0,0,"");
		this.tipo=' ';
		this.numero=0;
	}

	public Carta(int n, char t, int x, int y) {
		//super(x,y,n+t+"");
		this.tipo=t;
		this.numero=n;
		this.x=x;
        this.y=y;
        this.icono=new ImageIcon("Imagenes/"+n+t+".png");
        this.img=icono.getImage();
        this.ancho=icono.getIconWidth();
        this.alto=icono.getIconHeight();
	}
	
	char getTipo(){
		return this.tipo;
	}
	
	int getNumero(){
		return this.numero;
	}
	
	public String toString(){
		return (numero+""+tipo);
	}
	
	void dibujar(Graphics g){
		Graphics2D g2d=(Graphics2D) g;
        g2d.drawImage(this.img, this.x, this.y,null);
	}

	void mover(){}
	
	 	public void setX(int x){this.x=x;}
	    public int getX(){return x;}
	    public void setY(int y){this.y=y;}
	    public int getY(){return y;}
	    public void setAlto(int alto){this.alto=alto;}
	    public int getAlto(){return alto;}
	    public void setAncho(int ancho){this.ancho=ancho;}
	    public int getAncho(){return ancho;}
	    public Image getImage(){return img;}
	    public void setImage(Image img){this.img=img;}
	    public ImageIcon getIcono(){return icono;}
	    public void setIcono(ImageIcon icono){this.icono=icono;}
}
