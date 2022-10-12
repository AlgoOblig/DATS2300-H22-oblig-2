package no.oslomet.cs.algdat.Oblig2;


////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;


public class DobbeltLenketListe<T> implements Liste<T> {


    /**
     * Node class
     *
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }



    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    //Node<T> p ;
    private int antall;            // antall noder i listen
    private int endringer;            // antall endringer i listen
    Node<T> curNode;
    int i = 0;
    StringBuilder str = new StringBuilder();





    public DobbeltLenketListe() {
       // throw new UnsupportedOperationException();

        hode = curNode = hale = null;
        antall = 0;
        endringer = 0;
    }

    public DobbeltLenketListe(T[] a) {

        if(a.length != 0) {

            for (; i < a.length && a[i] == null; ++i);
            if(i == a.length) return;

             hode = new Node<>(a[i], null, null);
            curNode = hode;
            antall = 1;

            for (i++; i < a.length; i++) {
                if (a[i] != null) {
                    curNode = curNode.neste = new Node<>(a[i], curNode, null);
                    antall++;
                }
            }
            hale = curNode;
        }

    }

    public Liste<T> subliste(int fra, int til) {
       // throw new UnsupportedOperationException();

        fratilKontroll(antall, fra, til);

        T[] arr = (T[]) new  Object[til-fra];
        int elementPos = 0;
        for(int i = fra; i < til; i++){
            arr[elementPos] = hent(i);
            elementPos++;
        }

        DobbeltLenketListe<T> elmentListe = new DobbeltLenketListe<>(arr);
        return elmentListe;


    }

    @Override
    public int antall() {
        if(antall==0){
            return 0 ;
        }
        return antall;// throw new UnsupportedOperationException();
    }

    @Override
    public boolean tom() {
        return antall ==0;// throw new UnsupportedOperationException();
    }

    @Override
    public boolean leggInn(T verdi) {
        //throw new UnsupportedOperationException();



        Objects.requireNonNull(verdi,"Ikke tillatt med nullverdier!");

        if(tom()) {
            hode =  new Node<>(verdi,null,null);
            hale = hode;
        }
        else {
            hale.neste = new Node<>(verdi,hale,null);
             hale = hale.neste ;
            /**hale  = new Node<>(verdi,hale,null);
            hale.neste = hale;*/



        }

        antall++;
        endringer++;
        return true;


    }

    @Override
    public void leggInn(int indeks, T verdi) {

        //throw new UnsupportedOperationException();

        Objects.requireNonNull(verdi, "Ikke tillatt med null-verdier!");
        indeksKontroll(indeks, true);


        if(antall == 0){

            hode =  new Node<>(verdi,null,null);
            hale = hode ;

        }

        else if(indeks == 0){


            hode.forrige = new Node<>(verdi,null,hode);
            hode = hode.forrige ;
        }
        else if(indeks == antall){

            hale.neste =  new Node<>(verdi,hale,null);
            hale = hale.neste ;
        }
        else{


            Node<T> curNode = finnNode(indeks);
            curNode.forrige.neste = new Node<>(verdi,curNode.forrige,curNode);
            curNode.forrige = curNode.forrige.neste ;

        }
        endringer++;
        antall++;
    }


    private Node<T> finnNode(int indeks){
        //throw new UnsupportedOperationException();
        Node<T> curNode = hode;
        if(indeks < antall/2){
            for(int i = 0; i < indeks; i++){
                curNode =curNode.neste;
            }
        }
        else{
            curNode = hale;
            for(int i = antall-1; i > indeks; i--){
                curNode = curNode.forrige;
            }
        }
        return curNode;
        //return  null;
    }

    @Override
    public boolean inneholder(T verdi) {
       //throw new UnsupportedOperationException();

        return indeksTil(verdi) != -1;
    }

    @Override
    public T hent(int indeks) {
        //throw new UnsupportedOperationException();

        indeksKontroll(indeks,false);
        return finnNode(indeks).verdi;
    }

    @Override
    public int indeksTil(T verdi) {
       // throw new UnsupportedOperationException();

        for (int i = 0; i < antall; i++){
            T verdiPaaPos = hent(i);
            if (verdiPaaPos.equals(verdi)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
       // throw new UnsupportedOperationException();

        Objects.requireNonNull(nyverdi,"tomtTable er uakseptabelt");
        indeksKontroll(indeks,false);

        Node<T> nodePaaInd = finnNode(indeks);
        T tidligereVerdi = nodePaaInd.verdi;
        nodePaaInd.verdi = nyverdi;
        endringer++;
        return tidligereVerdi;
    }


    private static void fratilKontroll(int antall, int fra, int til)
    {
        if (fra > til) {
            throw new IllegalArgumentException("den er " + fra + " til -->" + til + "er ulovlig domain");
        }
        if (fra < 0) {
            throw new IndexOutOfBoundsException("fra den" + fra + ") er negativ pos!");
        }
        if (til > antall)    {
            throw new IndexOutOfBoundsException("til -->" + til + ") >>>> antall(" + antall + ")");
        }

    }




    @Override
    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException();
      /**  if(verdi == null) {

            return false;
        }

        Node<T> curNode = hode;
        Node<T>   refNode = null;
        while(curNode != null){
            if(verdi.equals(curNode.verdi)) {
                if(curNode == hode){
                    hode = hode.neste;
                }
                else{
                    refNode.neste = curNode.neste;
                    if(curNode != hale) curNode.neste.forrige = refNode;
                }
                if(curNode == hale) {
                    hale = refNode;
                }

                antall--;
                endringer++;
                return true;
            }
            refNode = curNode; curNode = curNode.neste;
        }
        return false;*/
    }

    @Override
    public T fjern(int indeks) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void nullstill() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {



        StringBuilder str = new StringBuilder();
        str.append("[");

        if(!tom()) {
            curNode = hode;
            str.append(curNode.verdi);
            curNode = curNode.neste;

            for (int i = 1; i < antall; i++) {
                str.append(",").append(" ").append(curNode.verdi);
                curNode = curNode.neste;
            }
        }

        str.append("]");
        return str.toString();





    }

    public String omvendtString() {
        //throw new UnsupportedOperationException();



        StringBuilder str = new StringBuilder();
        str.append("[");

        if(!tom()) {      //Hvis listen ikke er tom
             curNode = hale;
            str.append(curNode.verdi);
            curNode = curNode.forrige;

            for (int i = antall-1; i > 0; i--) {
                str.append(",").append(" ").append(curNode.verdi);
                curNode = curNode.forrige;
            }
        }
        str.append("]");
        return str.toString();




    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public Iterator<T> iterator(int indeks) {
        throw new UnsupportedOperationException();
    }

    private class DobbeltLenketListeIterator implements Iterator<T> {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator() {
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        @Override
        public T next() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }


    public static void main(String[] args) {


        Character[] c = {'A','B','C','D','E','F','G','H','I','J',};
        DobbeltLenketListe<Character> liste = new DobbeltLenketListe<>(c);
        System.out.println(liste.subliste(3,8)); // [D, E, F, G, H]
        System.out.println(liste.subliste(5,5)); // []
        System.out.println(liste.subliste(8,liste.antall())); // [I, J]
// System.out.println(liste.subliste(0,11)); // skal kaste unntak


      /*  String[] s1 = {}, s2 = {"A"}, s3 = {null,"A",null,"B",null};
        DobbeltLenketListe<String> l1 = new DobbeltLenketListe<>(s1);
        DobbeltLenketListe<String> l2 = new DobbeltLenketListe<>(s2);
        DobbeltLenketListe<String> l3 = new DobbeltLenketListe<>(s3);
        System.out.println(l1.toString() + " " + l2.toString()
                + " " + l3.toString() );*/



       /** String[] s1 = {}, s2 = {"A"}, s3 = {null,"A",null,"B",null};
        DobbeltLenketListe<String> l1 = new DobbeltLenketListe<>(s1);
        DobbeltLenketListe<String> l2 = new DobbeltLenketListe<>(s2);
        DobbeltLenketListe<String> l3 = new DobbeltLenketListe<>(s3);
        System.out.println(l1.toString() + " " + l2.toString()
                + " " + l3.toString() + " " + l1.omvendtString() + " "
                + l2.omvendtString() + " " + l3.omvendtString());


        DobbeltLenketListe<Integer> liste = new DobbeltLenketListe<>();
        System.out.println(liste.toString() + " " + liste.omvendtString());
        for (int i = 1; i <= 3; i++) {
            liste.leggInn(i);
            System.out.println(liste.toString() + " " + liste.omvendtString());
        }
// Utskrift:
// [] []
// [1] [1]
// [1, 2] [2, 1]
// [1, 2, 3] [3, 2, 1]

*/
    }

} // class DobbeltLenketListe


