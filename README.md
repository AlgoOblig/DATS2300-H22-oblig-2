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














Oppgave er oppnå mye bedre i denne økten og mye forstå innholdet i emnet. Jeg har brukt kursmateriellet og det til å forstå og svare på alle deler av oppgaven.

Utfordringen er siden testprogrammet leveres som forhåndskodet, og det fungerer sikkert på en bestemt programmert måte, en liten feil i koden gjør at testen feiler.
så det tar mye tid fra meg å gå gjennom feil og fikse dem.

Jeg har ikke nok tid til å skrive hele oppgavebeskrivelsen og kommentere. Kodene mine er imidlertid så enkle og tydelig innrykket for å bli forstått

