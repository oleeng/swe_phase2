# Softwareimplementierung für Softwareengineering
Dies ist die Softwareimplementierung der zweiten Phase für den Kurs 'Software Engineering'. Ziel ist es die Gundfunktionen einer Immobilienseite umzusetzen. Dazu gehört unteranderem das einfügen und löschen von Inseraten sowie das Filtern.

## Installation
Das Programm kann ausgeführt werden indem das git-repository gecloned wird und die Java Dateien lokal kompiliert und ausgeführt werden. Es gibt zurzeit keine executable oder sonstige vorkompilierte Dateien.

>**Achtung: Die  korrekte Ausführung wurde nur für Windows getestet. Auf Linux oder MacOS Sytemen kann es Probleme aufgrund anderer Konventionen für Pfadnamen beim Lesen von Dateien wie Bildern geben!**

## Benutzung
Nach dem Ausführen des Programms laufen einige Demo-Befehle ab, die die Grundfunktionen der Software zeigen. Danach hat man als Benutzer die Möglichkeit über die Konsole selbst mit der Software zu interagieren und zum Beispiel Suchanfragen und vieles mehr durchzuführen.

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
|*Eigenschaft(String name, String value)*|Erzeugt eine neue [Eigenschaft](#class-eigenschaft) Instanz mit dem Namen *name* und dem Stringwert *value*|
|*Eigenschaft(String name, Double value)*|Erzeugt eine neue [Eigenschaft](#class-eigenschaft) Instanz mit dem Namen *name* und dem Doublewert *value*|

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
|*Filter(String name, String value)*|Erzeugt eine neue [Filter](#class-filter) Instanz mit dem Namen *name* und dem Stringwert *value*|
|*Filter(String name, Double value, String method)*|Erzeugt eine neue [Filter](#class-filter) Instanz mit dem Namen *name* und dem Doublewert *value*. Beim Typ kann mit *"min"* oder *"max"* angegeben werden ob es sich um eine obere oder untere Grenze handelt.|

#### Methoden
|Modifier and Type|Methode|Beschreibung|
|:---|:---|:---|
|*String*|*getName()*|Gibt den Namen des Filters zurück.|
|*String*|*getValue()*|Gibt den Wert des Filters zurück. Doublewerte werden hier als String zurückgegeben|
|*String*|*getMethod()*|Gibt die Filtermethode des Filters zurück. Bei einem Textfilter wird als Methode ein leerer String zurückgegeben.|
|*String*|*getType()*|Gibt den Typ des Filters zurück, also ob es sich bei dem gespeicherten Wert um eine *"String"* oder *"Double"* handelt|

