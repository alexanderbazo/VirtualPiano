# Virtual Piano

In dieser Studienleistung werden Sie ein virtuelles Musikinstrument implementieren. Um die Aufgabe zu bearbeiten, müssen
Sie zuerst das
Projekt [VirtualPiano-Starter.zip](https://github.com/alexanderbazo/VirtualPiano/archive/refs/heads/master.zip)
herunterladen, entpacken und in IntelliJ öffnen.

## Zusammenfassung

In dieser Aufgabe sollen Sie ein virtuelles Musikinstrument entwerfen. Schreiben Sie eine Anwendung auf der Basis der
*GraphicsApp*, die eine Klaviertastatur (Klaviatur) abbildet und insgesamt 36 weiße und schwarze Tasten darstellt (drei
Oktaven). Klickt der Nutzer auf eine der Taste, wird der entsprechende Ton abgespielt. Die Reihenfolge und Aufteilung
der Tasten zu den Tönen erfolgt dabei genauso, wie von einem herkömmlichen Klavier bekannt. Ein Video der fertigen
Anwendung mit den minimalen Anforderungen können Sie sich hier anschauen:

[![Video des Virtual-Piano]({https://files.mi.ur.de/seafhttp/files/bd29de9f-7103-4b07-a415-6965292a90f0/virtual-piano-1.png})]({https://files.mi.ur.de/seafhttp/files/152c7cf9-98c0-4765-ad69-fd76cc6fbefa/virtual-piano.mp4} "Video des Virtual-Piano")

## Vorgaben

Sie müssen sich in dieser Aufgabe nur um die graphische Komponente der Anwendung und die Verknüpfung der verschiedenen
Interaktions-Ereignisse (Mausklicks) mit der zugrundeliegenden Schicht zur Tonerzeugung beschäftigen. Diese Komponente,
die die eigentlichen Sounds erzeugt ist bereits implementiert und als zusätzliche Bibliothek in das Starterpaket
eingebunden. Im Wesentlichen handelt es sich um die Klasse `Synthesizer` die es Ihnen erlaubt, verschiedene Töne über
eine einfache öffentliche Schnittstelle abzuspielen. Eine Dokumentation mit Beispiel-Code für diese Klasse finden Sie
hier. Sie müssen diese Klasse (und die ebenfalls enthalten Enums Instrument und Note) für die Tonwiedergabe nutzen. Sie
dürfen den vorgegebenen Code nur dann anpassen, wenn Sie diesen für etwaige eigene Erweiterungen kompatibel machen
wollen.

**Hinweis**: Achten Sie bei der Verwendung der `Synthesizer`-Klasse unbedingt darauf, die korrekte Klasse zu
importieren. Es gibt verschiedene Klassen, die alle den Namen Synthesizer haben. Verwenden Sie diejenige, die über
folgenden Importanweisung in Ihre Anwendung integriert wird: `import de.mi.ur.midi.Synthesizer;`.

Hinweis: Bei der Instanziierung und Nutzung der `Synthesizer`-Klasse wird auf interne Java-Klassen für die Tonwiedergabe
zurückgegriffen. Hierbei kann es zu Fehlern kommen, wenn die Java-Midi-Komponenten auf Ihrem System nicht korrekt
funktionieren. Da dies ein vorhersehbarer Fehler ist (der *Java Runtime* ist bekannt, dass hier etwas schiefgehen kann)
sind Sie gezwungen, den kritischen Code in einem sogenannten `try ... catch`-Block zu implementieren. Damit teilen Sie
der Runtime mit, dass versucht werden soll, den angegebenen Code im try-Teil auszuführen. Sollte es zu dem im catch-Teil
angegebenen Fehler kommen, wird der dort angegebene Code ausgeführt, um explizit auf diesen Fehlerfall zu reagieren. Für
die Instanziierung der `Synthesizer`-Klasse muss Ihr Code daher so ausschauen:

```
try {
  synthesizer = new Synthesizer();
} catch (MidiUnavailableException e) {
  e.printStackTrace();
}
```

## Anforderungen

### User Interface

Implementieren Sie die graphische Benutzerschnittstelle der Anwendung wie auf den Screenshots zu sehen. Bitte achten Sie
darauf, dass Ihre Anwendung am Ende nicht die Dimensionen 1200 Pixel (Breite) und 800 Pixel (Höhe) überschreitet. Bis
auf die Form, Anordnung und Farbe der Tasten (`Colors.WHITE` und `Colors.BLACK`) können Sie das Design der Anwendung
frei gestalten.

Ihre Anwendung muss aus 36 weißen und schwarzen Tasten bestehen, die korrekt angeordnet einer Klaviertastatur mit drei
Oktaven entsprechen. Die Tasten müssen dabei unterscheidbar visualisiert werden. Weiße und schwarze Tasten werden
unterschiedlich groß dargestellt. Achten Sie auf sinnvolle Proportionen und die korrekte Positionierung.

**Mögliche Erweiterung**: Erweitern Sie die graphische Ausgabe Ihrer Anwendung. Sorgen Sie dafür, dass die Taste, deren
Ton aktuell gespielt wird, kurz durch eine farbliche Markierung hervorgehoben wird.

### Interaktion

Der Nutzer soll in der Lage sein, über die Maus mit der Anwendung zu interagieren, um dadurch mit dem virtuellen Piano
zu musizieren. Denken Sie daran, dass Sie nur in der Hauptklasse, die von *GraphicsApp* erbt auf die eigentlichen
Maus-Events- zugreifen können und überlegen Sie sich, wie Sie die Informationen von dort an die Stellen Ihrer Anwendung
weitergeben können, an denen Sie sie verarbeiten müssen.

Ermöglichen Sie die Interaktion über die Maus. Klickt der Benutzer auf eine der Tasten, wird der entsprechende Ton
abgespielt. Achten Sie darauf, dass beim Klick auf eine schwarze Taste nur deren Ton abgespielt wird und nicht auch die
darunter liegende weiße Taste ausgelöst wird.

**Mögliche Erweiterung**: Messen Sie die Zeit, die zwischen dem Drücken der Maustaste und dem Loslassen verstrichen ist,
um einen sinnvollen Wert für die velocity bzw. Anschlagsdynamik zu berechnen. Nutzen Sie diesen Wert beim Abspielen des
Tons. Überlegen Sie sich eine sinnvolle Möglichkeit, die Nutzung der Anwendung über Tastatureingabe zu erlauben.

### Audioausgabe

Sorgen Sie dafür, dass beim Betätigen einer Taste der korrekte Ton einmal abgespielt wird. Nutzen Sie dafür nur die
vorgegebene `Synthesizer`-Klasse.

## Hinweise zur Zeitmessung in Java

Bei vielen Probleme im Bereich der Programmierung müssen Sie Zeitabstände messen. Dies geschieht in der Regel durch das
Speichern zweier unterschiedlicher Zeitpunkte (Start- und Endpunkt des zu messenden Intervalls) und der Berechnung der
Differenz zwischen diesen beiden Werten. Dies wird dadurch erleichtert, dass Sie in Java zu jedem Zeitpunkt die
Möglichkeit haben, die aktuelle Zeit auszulesen: Die Methode `System.currentTimeMillis()` gibt die aktuelle Zeit in
Millisekunden, gemessen ab dem 1. Januar 1970, zurück. Die Methode wird in der offiziellen Dokumentation wie folgt
beschrieben:

```
/**
 * Returns the current time in milliseconds.  Note that
 * while the unit of time of the return value is a millisecond,
 * the granularity of the value depends on the underlying
 * operating system and may be larger.  For example, many
 * operating systems measure time in units of tens of
 * milliseconds.
 *
 * See the description of the class Date for
 * a discussion of slight discrepancies that may arise between
 * "computer time" and coordinated universal time (UTC).
 *
 * @return  the difference, measured in milliseconds, between
 *          the current time and midnight, January 1, 1970 UTC.
 * @see     java.util.Date
 */
```

Wenn Sie die aktuelle Zeit an den Zeitpunkten A und B jeweils über diese Methode bestimmt haben und die entsprechenden
Rückgabewerte in Variablen (`long`) gespeichert haben, können Sie die Zeitspanne zwischen den beiden Punkten durch die
Bildung der Differenz zwischen A und B berechnen. Das Ergebnis bildet die verstrichene Zeit in Millisekunden ab. Wenn
Sie den Umgang mit `System.currentTimeMillis()` üben möchten, geben Sie sich einfach den Rückgabewert dieser Funktion
regelmäßig innerhalb der draw-Methode einer *GraphicsApp* aus und achten Sie auf die Veränderung des Werts zwischen den
Ausgaben.