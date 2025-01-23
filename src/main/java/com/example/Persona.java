package com.example;

/**
 * La classe persona aiuta lo sviluppatore a gestire dati di tipo Persona
 */

public class Persona extends Object{
    private String nome;
    private String cognome;
    private String codice;

    /**
     * public Persona(String nome,
        String cognome,
        String codice)
        Costruisce un oggetto dato il nome, il cognome e il codice fiscale (trasformato in automatico in maiuscolo). Se CF non e' valido, viene lanciata un'eccezione.
        <h1>CONTROLLO sul CODICE FISCALE:</h2>
        <ul>
             <li>Il codice deve contenere 16 caratteri alfanumerici </li>
             <li>Il codice non deve contenere spazi </li>
             <li>I primi 6 caratteri devono essere delle consonanti  </li>
             <li>Settimo e ottavo carattere devono essere numeri  </li>
        </ul>
        Consulta la Documentazione ufficiale String
     * @param nome - stringa qualsiasi da assegnare come nome di un nuovo oggetto Persona
     * @param cognome - stringa qualsiasi da assegnare come cognome di un nuovo oggetto Persona
     * @param codice - stringa che rappresenta il nuovo codice fiscale dell'oggetto Persona
     * @throws IllegalArgumentException - Se il codice fiscale fornito non e' valido
     */
    public Persona(String nome, String cognome, String codice) { 
        
        if (codice == null) {
            throw new IllegalArgumentException("n, cognome e codiceFiscale fiscale non possono essere null.");
        }

        codice = codice.toUpperCase(); //mette tutti i caratteri in maiuscolo

        if (codice.length() != 16) {  //scarta i codici con lunghezza non valida
            throw new IllegalArgumentException("Il codiceFiscale deve contenere esattamente 16 caratteri.");
        }

        if (codice.contains(" ")) { //scarta i codici contenenti spazi 
            throw new IllegalArgumentException("Il codiceFiscale fiscale non deve contenere spazi.");
        }

        // Controlla che i primi 6 caratteri siano consonanti
        String primeSei = codice.substring(0, 6);
        if (!primeSei.matches("^[^AEIOU0-9]{6}$")) {
            throw new IllegalArgumentException("I primi 6 caratteri del codiceFiscale fiscale devono essere consonanti.");
        }

        // Controlla che il settimo e ottavo carattere siano numeri
        String settimoOttavo = codice.substring(6, 8);
        if (!settimoOttavo.matches("^[0-9]{2}$")) {
            throw new IllegalArgumentException("Il settimo e l'ottavo carattere del codiceFiscale fiscale devono essere numeri.");
        }
        this.nome = nome;
        this.cognome = cognome;
        this.codice = codice;
    }

    /**
     * assegna una Stringa come nome di una persona
     * @param nome - Stringa da assegnare come nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * - assegna una Stringa come cognome di una persona
     * @param cognome - nuova stringa da assegnare come cognome a un oggetto Persona giÃ  esistent
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    
    /**
     * restituisce una Stringa contenente il nome di una  persona
     * @return il nome di un oggetto Persona
     */
    public String getNome() {
        return nome;
    }


    /**
     * restituisce una Stringa contenente il cognome di una persona
     * @return il cognome di un oggetto Persona
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Il metodo stabilisce se due persone sono omonime; Restituisce un booleano: 
     * VERO se le due persone hanno lo stesso nome (senza distinzione di maiuscole e minuscole) 
     * altrimenti FALSO
     * @param p
     * @return Vero se le due persone confrontate hanno lo stesso nome, altrimenti falso
     */
    public boolean isOmonimo(Persona p){

        if(p.nome.equalsIgnoreCase(this.nome) && p.cognome.equalsIgnoreCase(this.cognome))
            return true;
              
        return false;
    }

  /**
   * Restituisce una rappresentazione testuale di un oggetto Persona, 
   * nel seguente formato "NOME:xx COGNOME:xx CF:xx"
   * @return  La rappresentazione testuale di un oggetto Persona
   */
  @Override
    public String toString(){
        String tmp = ":xx";
        return this.nome + tmp + " " + this.cognome + tmp + " " + this.codice + tmp;
    }
}
