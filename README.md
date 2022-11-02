# Obligatorisk oppgave 2 i Algoritmer og Datastrukturer

2022 HØST DATS2300-1 22H Algoritmer og datastrukturer: 
Oblig2 repo for Algoritme og datastruktur ved OsloMet universitet i Oslo
Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert individuelt:
* Navn : Mohammed A Mohammed, S375047, s375047@oslomet.no
* ...

# Arbeidsfordeling

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer.
Oppgaven er levert individuelt

# Oppgavebeskrivelse
#oppgave 1 
oppgave 1 - antall(): - uten argument metodene sjekker listen og returnerer antall noder i listen. Jeg starter 
med å kondisjonere og hvis antallet er null, returnerer programmet null ellers returnerer antall noder i listen

oppgave 1  - tom() : - denne metoden Tom() uten argument vil sjekke om antall = 0 og er sanne. i programmet bruker klassekonstruktøren en for-løkke og tilbakestiller alle variablene ved å sjekke
hvis matrisetabellen er tom og finn all verdi ved indeksposisjonen som ikke er null og lagt til listen som ny node

################################################
#oppgave 2

oppgave 2 - a) toString() : -  jeg start å implementere toString() metode  som oppgavetekst nevnt, implementerte 
jeg denne metoden ved å sløyfe teknikker som går  fra hode til hale mens jeg brukte den innebygde 
Stringbuilder-klassen for å legge til og sette hver node i listen til streng.  sløyfetilstanden starter
med å sjekke om tabellen ikke er tom og utfør det jeg nevnte ovenfor, ellers vil det returnere en enkel streng 
konkatinering av åpnings- og lukketegnet som firkantede parenteser som tomt sett

omvendtString(): - er også den samme og implementer alle trinn og teknikker som toString jeg nevnte, bortsett fra
at det er omvendt. jeg mener begynn å implementere metoder fra slutten av halen til begynnende nodehode

oppgave 2- b) leggInn(T verdi) : - Jeg begynte å implementere disse metodene ved først å se etter nullverdien ved hjelp av klasseobjekt requireNonNull-metode . Jeg brukte if-else-betingelsen for å sjekke om listen er tom
når betingelsen er sann meningslisten er tom har vi ingenting slik at hodenoden og talnoden blir den samme og konstruerte ny nodeobjekt hode fra inngangsverdien og
null null noder som argument.
hvis betingelsen ikke er sann, vil noden bli flyttet tilbake til ordet og halen vil bli pekt til den nye noden. det er endring av verdi tilgjengelig, noe som betyr at metoden endelig returnerer sann


#############################
#Oppgave 3:

Oppgave 3 a) finnNode(int indeks):- Jeg begynte å implementere denne metoden ved å bruke if-else-betingelsen som finner og returnerer verdi i listen ved indeksposisjon for gitt argument.
Jeg. e. det først sjekke inn hvis blokk av tilstanden vær indeksposisjonsverdien er mindre enn halvparten av antall for å sjekke og bytte til start finne retningen
hvis mindre enn halvparten betyr start looping fra hodet ellers vil den begynne å loope fra hodet og finne i motsatt retning. så vil den fortsette å sette node p til neste nodeverdi
enten klokt i motsetning til at node p vil bli satt til sin privious verdi og til slutt returnert verdien på den spesifiserte posisjonen som argument til metode

Oppgave 3 b) subliste(int fra, int til):- så jeg begynte å implementere denne delen ved å sjekke gyldigheten av intervallgrensen fra til til siden denne metoden vil returnere forekomsten av doubllinklisten som kun er gyldig i det gitte intervallet beng kontrollert som fra til til.
etter det gikk jeg gjennom dette intervallet og plukket verdi ved posisjon
indeks 'i' som skal tilordnes tabellverdi og økningsposisjon,
til slutt returnerte jeg denne listetabellen
###################################### Oppgave 4

#Oppgave4
Oppgave4 - indeksTil(T verdi) : -
Jeg begynner å implementere denne metoden for verdien som er null. først lager jeg verdien
null slik at metodene vil returnere -1 som første betingelse. så hvis det er en annen verdi 
enn null, så begynner jeg å sløyfe noden så lenge verdien vi ser på er forskjellig fra verdien 
på indeksen vi ser etter. hvis noden nåværende verdi er lik verdien av noden ved indeks, returneres sløyfebruddet og indeksverdien

########################### Oppgave 5
#oppgave 5
Opgave 5 - leggInn(int indeks, T verdi).   :
Jeg begynte å implementere ved å sjekke inn ugyldige og ikke tillatte verdier
ved hjelp av objektklassen Objects.requireNonNull, og jeg har også sjekket for det tillatte indeksintervallet ved å bruke indekscontroller-metoden

så sjekket jeg været at listen er tom i begynnelsen og for å oppdatere verdien av hode og hale hvis vi fikk noe i utgangspunktet
etter at jeg sjekker riktig posisjon hvor kunne noden lagt til først mellom eller sist, avhengig av denne nye plasseringen, oppdaterer jeg pekeren enten til hodet eller halen

i tilfelle posisjonen er mellom denne noden på en eller annen indeks
nå vil vi bruke hent(indeks)-metoden for å finne noden og ordne pekeren


########################### Oppgave 6
#oppgave 6
fjern(int indeks)denne metoden implementeres ved å starte fra å sjekke om indeksen er gyldig ved første trinn.
Jeg brukte kontrollmetoder jeg nevnte tidligere. så ved hjelp av å lage en midlertidig variabel sjekket
jeg posisjonen til indeksene for å oppdatere pekeren, oppdaterte jeg verdien av hode- eller halenodene
og pekerne. dermed hvis indeksen er i første posisjon oppdatert hodet og og dens peker til privious og
tabellen vil være tom som halen satt til null og det samme for hvis indeksen er på slutten vil halen bli
oppdatert og slik at pekeren hale. forrige.neste
hvis posisjonen er i midten brukte jeg en hjelpenode som vil peke på den private noden som vil bli slettet.
fjern(verdi) sjekk først om verdien ikke er tom og den fungerer på samme måte som jeg nevnte for indekspoisteringen.
den oppdaterte også antall og endringer


########################### Oppgave 8


#oppgave 8

oppgave 8 a) .:-T next()-metoden starter med å sammenligne iteratorendringer med endringer, og hvis ikke det er likt,
gir det unntak. det sjekker også om det er noen andre neste med verdi, og hvis det ikke finner noen neste,
vil det gi unntak. den setter til slutt fjernOK = true og lag den nye noden for å tilordne verdien til
den nåværende noden og returnere den nodeverdien

oppgave 8 b) :- Iterator<T> iterator(). dette er metoden for å returnere bare instanseobjektverdien til DobbeltLenketListeIterator()

oppgave 8 c) DobbeltLenketListeIterator(int indeks). dette implementeres ved å finne verdien til noden ved posisjonsindeksen og settes til denne noden.
og tilordne den boolske fjernOk til false og også tilordne verdien av endringer til iteratorendringer


oppgave 8 d)  Iterator<T> iterator(int indeks).  denne metoden sjekk først om indeksen har gyldig posisjon ved å bruke indekskontrollmetoden, så vil den returnere forekomsten av DobbeltLenketListeIterator
på den gitte posisjonen som skal være gyldig posisjon


