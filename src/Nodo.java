public class Nodo
{

	Object info;
	Nodo sig;
	
	public Nodo(Object i) {
		info = i;
		sig = null;
	}

	public String toString(){
		return info.toString();
	}
}