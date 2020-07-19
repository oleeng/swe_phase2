public interface InseratComposite {
    
	/*
	 * Dieses Interface dient zu der Abstraktion aller Children-Klassen im Composite-Muster.
	 * Der Einfachheit halber wurden hier nicht alle Methoden der "Blatt-Klasse" Inserat
	 * und "Composite-Klasse" InseratContainer deklariert, da man so auf eine Leerimplementierung
	 * innerhalb der jeweiligen Klasse verzichten kann.
	 */
	
	public void print();
    public void print(Integer level);
    public Double getPreis();
}
