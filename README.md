# Softwareimplementierung für Softwareengineering
Dies ist die Softwareimplementierung der zweiten Phase für den Kurs 'Software Engineering'. Ziel ist es die Gundfunktionen einer Immobilienseite umzusetzen. Dazu gehört unteranderem das einfügen und löschen von Inseraten sowie das Filtern.

## Installation
Das Programm kann ausgeführt werden indem das git-repository gecloned wird und die Java Dateien lokal kompiliert und ausgeführt werden. Es gibt zurzeit keine executable oder sonstige vorkompilierte Dateien.

>**Achtung: Die  korrekte Ausführung wurde nur für Windows getestet. Auf Linux oder MacOS Sytemen kann es Probleme aufgrund anderer Konventionen für Pfadnamen beim Lesen von Dateien wie Bildern geben!**

## Benutzung
Nach dem Ausführen des Programms laufen einige Demo-Befehle ab, die die Grundfunktionen der Software zeigen. Danach hat man als Benutzer die Möglichkeit über die Konsole selbst mit der Software zu interagieren und zum Beispiel Suchanfragen und vieles mehr durchzuführen.

## Beispielausgaben
Hier werden Schreenshots von Beispielkonsolenausgaben eingefügt.

## Dokumentation

### class Helper
*public class Helper*

Diese Klasse stellt einige Hilfsfunktionen für andere Klassen bereit.

#### Variablen
|Modifier and Type|Name|
|:---|:---|

#### Konstuktoren
|Konstruktor|Beschreibung|
|:---|:---|

#### Methoden
|Modifier and Type|Methode|Beschreibung|
|:---|:---|:---|
|*static String*|*genId()*|Diese Funktion erzeugt einen 64-Zeichen langen pseudozufälligen String (nicht kryptographisch sicher), der von anderen Klassen für die Erzeugung einer eindeutigen ID genutzt wird, und gibt diesen zurück.|
|*static String*|*padding(String string, Integer count)*|Wiederholt den String *string* *count*-mal und gibt ihn zurück. Diese Funktion wird von anderen Funktionen zur Erzeugung von padding genutzt.|
|*static void*|*printFile(String path)*|Gibt den Inhalt der in *path* übergebenen Datei in der Konsole aus. Wenn die Datei nicht existiert, wird eine entsprechende Nachricht auf der Konsole ausgegeben ohne eine Exception zu werfen oder das Programm zu beenden.|
|*static void*|*printImage(String path)*|Konvertiert die in *path* angegebene Bilddatei in ASCII-Art und gibt sie anschließend auf der Konsole aus. Wenn die Datei nicht geöffnet werden kann wird eine entsprechende Nachricht in der Konsole ausgegeben ohne eine Exception zu werfen oder das Programm zu beenden.<br>**Achtung: Die Konsole muss dafür unicode bzw. UTF-8 unterstützen**|

### class Bild
*public class Bild*

Diese Klasse nutzt Funktionen der Klasse [*Helper*](#class-helper)

#### Variablen
|Modifier and Type|Name|
|:---|:---|

#### Konstuktoren
|Konstruktor|Beschreibung|
|:---|:---|
|*Bild(String beschreibung, String path)*|Erzeugt eine neue [*Bild*](#class-bild) Instanz mit der in *pfad* angegebenen Datei und der Beschreibung aus *beschreibung*. Falls die Datei nicht existiert oder nicht vom Typ *.png* oder *.jpg* ist, wird eine *FileNotFoundException* ausgeworfen.|

#### Methoden
|Modifier and Type|Methode|Beschreibung|
|:---|:---|:---|
|*String*|*getId()*|Gibt die 64-Zeichen lange ID des Bildes zurück|
|*String*|*getBeschreibung()*|Gibt die Beschreibung des Bildes zurück|
|*String*|*getDateiformat()*|Gibt da Dateiformat des Bildes zurück|
|*String*|*getPath()*|Gibt den absoluten Pfad des Bildes zurück|
|*Integer*|*getDateigroesse()*|Gibt die 64-Zeichen lange ID des Bildes zurück|
|*void*|*print()*|gibt alle wichtigen Informationen zu dem Bild in der Konsole aus|
|*void*|*anzeigen()*|Konvertiert das Bild in ASCII-Art und gibt es auf der Konsole aus. Diese Funktion nutzt die Funktion *printImage(String path) der Klasse [*Helper*](#class-helper)<br>**Achtung: Die Konsole muss dafür unicode bzw. UTF-8 unterstützen**|

### class Eigenschaft
*public class Eigenschaft*

#### Variablen
|Modifier and Type|Name|
|:---|:---|

#### Konstuktoren
|Konstruktor|Beschreibung|
|:---|:---|
|*Eigenschaft(String name, String value)*|Erzeugt eine neue [*Eigenschaft*](#class-eigenschaft) Instanz mit dem Namen *name* und dem Stringwert *value*|
|*Eigenschaft(String name, Double value)*|Erzeugt eine neue [*Eigenschaft*](#class-eigenschaft) Instanz mit dem Namen *name* und dem Doublewert *value*|

#### Methoden
|Modifier and Type|Methode|Beschreibung|
|:---|:---|:---|
|*String*|*getName()*|Gibt den Namen der Eigenschaft zurück.|
|*String*|*getValue()*|Gibt den Wert der Eigenschaft zurück. Doublewerte werden hier als String zurückgegeben|
|*String*|*getType()*|Gibt den Typ der Eigenschaft zurück, also ob es sich bei dem gespeicherten Wert um eine *"String"* oder *"Double"* handelt|

### class Filter
*public class Filter*

#### Variablen
|Modifier and Type|Name|
|:---|:---|

#### Konstuktoren
|Konstruktor|Beschreibung|
|:---|:---|
|*Filter(String name, String value)*|Erzeugt eine neue [*Filter*](#class-filter) Instanz mit dem Namen *name* und dem Stringwert *value*|
|*Filter(String name, Double value, String method)*|Erzeugt eine neue [*Filter*](#class-filter) Instanz mit dem Namen *name* und dem Doublewert *value*. Beim Typ kann mit *"min"* oder *"max"* angegeben werden ob es sich um eine obere oder untere Grenze handelt.|

#### Methoden
|Modifier and Type|Methode|Beschreibung|
|:---|:---|:---|
|*String*|*getName()*|Gibt den Namen des Filters zurück.|
|*String*|*getValue()*|Gibt den Wert des Filters zurück. Doublewerte werden hier als String zurückgegeben|
|*String*|*getMethod()*|Gibt die Filtermethode des Filters zurück. Bei einem Textfilter wird als Methode ein leerer String zurückgegeben.|
|*String*|*getType()*|Gibt den Typ des Filters zurück, also ob es sich bei dem gespeicherten Wert um eine *"String"* oder *"Double"* handelt|

### interface InseratComposite
*public interface InseratComposite*

#### Methoden
|Modifier and Type|Methode|
|:---|:---|
|*void*|*print()*|
|*void*|*print(Integer level)*|
|*Double*|*getPreis()*|

### class Inserat
*public class Inserat implements InseratComposite*

#### Variablen
|Modifier and Type|Name|
|:---|:---|

#### Konstuktoren
|Konstruktor|Beschreibung|
|:---|:---|
|*Inserat(String beschreibung, Standort standort, Double preis, String immobielenart, String wohnart)*|Erzeugt eine neue [*Inserat*](#class-inserat) Instanz mit der Beschreibung *beschreibung*, dem in *standort* übergebenen [*Standort*](#class-standort), dem Preis *preis*, der Immobilienart *immobilienart*, welche angibt, ob es sich um ein "Haus", "Wohnung" oder "Bungalow" hadelt, und der Wohnart *wohnart*, welche angibt, ob es sich um ein "wohnen" oder "kaufen" Objekt handelt.

#### Methoden
|Modifier and Type|Methode|Beschreibung|
|:---|:---|:---|
|*static HashMap<String,String>*|*getErlaubteEigenschaften()*|Diese Funktion gibt eine Hashmap aller erlaubten Eigenschaften/Filter zurück. Dabei ist der Key der Name der Eigenschaft und der Wert der Typ der jeweiligen Eigenschaft, also "String" oder "Double".|
|*void*|*add([*Rundgang*](#class-rundgang) rundgang)*|Fügt dem [*Inserat*](#class-inserat) den in *rundgang* übergebenen [*Rundgang*](#class-rundgang) hinzu.|
|*void*|*removeRundgang()*|Entfernt den [*Rundgang*](#class-rundgang) des [*Inserat*](#class-inserat).|
|*void*|*add([*Bild*](#class-bild) ... bilder)*|Fügt dem [*Inserat*](#class-inserat) alle in *bilder* übergebenen [*Bilder*](#class-bild) hinzu.|
|*void*|*remove([*Bild*](#class-bild)... bilder)*|Entfernt alle in *bilder* übergebenen [*Bilder*](#class-bild) dem [*Inserat*](#class-inserat).|
|*void*|*add([*Eigenschaft*](#class-eigenschaft)... eigenschaften)*|Fügt dem [*Inserat*](#class-inserat) alle in *eigenschaften* übergebenen [*Eigenschaften*](#class-eigenschaft) hinzu.|
|*void*|*remove(String... names)*|Entfernt alle in [*Eigenschaften*](#class-eigenschaft) mit mit den Namen *names* dem [*Inserat*](#class-inserat).|
|*String*|*getId()*|Gibt die 64-Zeichen lange ID des [*Inserats*](#class-inserat) zurück|
|*String*|*getBeschreibung()*|Gibt die Beschreibung des [*Inserats*](#class-inserat) zurück|
|*[*Standort*](#class-standort)*|*getStandort()*|Gibt den [*Standort*](#class-standort) des [*Inserats*](#class-inserat) zurück|
|*void*|*starteRundgang()*|Startet den [*Rundgang*](#class-Rundgang) des [*Inserats*](#class-inserat).|
|*void*|*printBilder()*|Ruft für jedes [*Bild*](#class-bild) des [*Inserats*](#class-inserat) die *print()* Funktion auf.|
|*void*|*zeigeBilder()*|Ruft für jedes [*Bild*](#class-bild) des [*Inserats*](#class-inserat) die *anzeigen()* Funktion auf.|
|*String*|*getEigenschaft(String name)*|Gibt den Wert der [*Eigenschaft*](#class-eigenschaft) mit dem Namen *name* des [*Inserats*](#class-inserat) zurück. Falls das [*Inserat*](#class-inserat) diese [*Eigenschaft*](#class-eigenschaft) nicht besitzt wird *null* zurückgegeben.|
|*void*|*printEigenschaften()*|Gibt alle [*Eigenschaften*](#class-eigenschaft) des [*Inserats*](#class-inserat) in der Konsole aus.|
|*void*|*print()*|Dies ist eine Funktion des implementierten Interfaces [*InseratComposite*](#interface-inseratcomposite). Sie gibt für das [*Inserat*](#class-inserat) die ID und die Beschreibung in der Konsole aus.|
|*void*|*print(Integer level)*|Dies ist eine Funktion des implementierten Interfaces [*InseratComposite*](#interface-inseratcomposite). Sie gibt für das [*Inserat*](#class-inserat) die ID und die Beschreibung in der Konsole aus, jedoch mit einem padding entsprechned dem in *level* übergebenen Wert.|
|*Double*|*getPreis()*|Dies ist eine Funktion des implementierten Interfaces [*InseratComposite*](#interface-inseratcomposite). Sie gibt den Preis des [*Inserats*](#class-inserat) zurück.
