package no.oslomet.cs.algdat.Oblig2;


////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;


public class DobbeltLenketListe<T> implements Liste<T> {


    /**
     * dette er den indre klassenoden konstruert fra verdi og to node
     *
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        /**
         *
         * klass konstruktor
         * @param verdi
         * @param  forrige
         * @param neste
         * */

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



    @Override
    public int antall() {
        if(antall==0){
            return 0 ;
        }
        return antall;
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

///////////////////////////////////////oppgave 3 ///////////////////////

    /**
     * oppgave 3 a
     * @param indeks
     * */
    private Node<T> finnNode(int indeks){

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

        /**
        *
        * oppgave 3b
        * @param fra
         * @param til
        * */
    public Liste<T> subliste(int fra, int til) {


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
    ////////////////////////////////////////  ///////////////////////////////////////



    @Override
    public T hent(int indeks) {
        //throw new UnsupportedOperationException();

        indeksKontroll(indeks,false);
        return finnNode(indeks).verdi;
    }

    ////////////////////////////oppgave4/////////////////////////////


    /**
     *
     * @param verdi
     * */
    @Override
    public boolean inneholder(T verdi) {

        return indeksTil(verdi) != -1;
    }


/**
 * oppgave 4 del1
 * @param verdi
 * */
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
/////////////////////////////////////////////////////////////////////////
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
        //throw new UnsupportedOperationException();
       if(verdi == null) {

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
        return false;
    }

    @Override
    public T fjern(int indeks) {
        //throw new UnsupportedOperationException();

        indeksKontroll(indeks, false);
        T tempVerdi;

        if (indeks == 0) {
            tempVerdi = hode.verdi;
            if (antall == 1) {
                hode = null;
                hale = null;
            } else {
                hode = hode.neste;
                hode.forrige = null;
            }

        }

        else if(indeks == antall-1){
            tempVerdi = hale.verdi;
            hale.forrige.neste = null;
            hale = hale.forrige;
            if(antall == 1) hode = null;
        }

        else{
            Node<T> nodePaaPos = finnNode(indeks);
            Node<T> curNode = nodePaaPos.forrige;
            Node<T> r = nodePaaPos.neste;
            tempVerdi= nodePaaPos.verdi;

            nodePaaPos.verdi = null;
            nodePaaPos.forrige = null;
            nodePaaPos.neste = null;

            curNode.neste = r;
            r.forrige = curNode;
        }
        antall--;
        endringer++;
        return tempVerdi;
    }

    @Override
    public void nullstill() {
        Node<T> enuNode = null;
        while (!tom()){
            hode.verdi = null;
            hode.forrige = null;
            enuNode = hode.neste;
            hode.neste = null;
            antall--;
            hode = enuNode;
        }
        endringer++;
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
        return new DobbeltLenketListeIterator();
    }

    public Iterator<T> iterator(int indeks) {
        indeksKontroll(indeks, false);
        return new DobbeltLenketListeIterator(indeks);
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

            denne = finnNode(indeks);
            fjernOK = false;
            iteratorendringer = endringer;
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        @Override
        public T next() {
           // throw new UnsupportedOperationException();

            if(iteratorendringer != endringer) {
                throw new ConcurrentModificationException("vi har endringen i liste");
            }
            if(!hasNext()){
                throw new NoSuchElementException("verdien er ikke mer og de det tom list");
            }

            fjernOK = true;
            T denneVerdi = denne.verdi;
            denne = denne.neste;

            return denneVerdi;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }



} // class DobbeltLenketListe


