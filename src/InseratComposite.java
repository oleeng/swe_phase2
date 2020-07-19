public interface InseratComposite {
    
	/*
	 * Dieses Interface dient zu der Abstraktion aller Children-Klassen im Composite-Muster. 
	 * Der Einfachheit halber wurden hier nicht alle Methoden der "Blatt-Klasse" -
	 * Inserat und "Composite-Klasse" – InseratContainer deklariert, denn das
	 * erlaubt auf die „leere Implementierung“ von nicht gemeinsamen Funktionen zu
	 * verzichten, wobei aufgrund der Vereinfachung des Composite-Muster gibt es viele
	 * von solchen Funktionen. Aus dem gleichen Grunde werden auch die Objekte im Hauptprogramm
	 * von dem Typ "InseratContainer" und "Inserat" ohne Referenzierung des Interfaces benutzt.
	 */
	
	public void print();
    public void print(Integer level);
    public Double getPreis();
}
