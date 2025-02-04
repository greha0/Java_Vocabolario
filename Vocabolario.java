import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * La classe vocabolario memorizza in un array tutte le parole di un file di testo
 *
 * @author Greta Brugnatti
 */

public class Vocabolario {
    private String[] array;
    private int cont;

    /**
     * Crea un vocabolario di 10000 caselle
     */
    public Vocabolario() {
        array = new String[10000];
        cont = 0;
        System.out.println("E' stato creato un vocabolario vuoto");
    }

    /**
     * Crea un vocabolario di caselle date
     *
     * @param dim Numero di caselle (numero parole)
     */
    public Vocabolario(int dim) {
        array = new String[dim];
        cont = 0;
    }

    /**
     * Controlla se la parola è già presente nel vocabolario
     *
     * @param parola
     * @return
     */
    public boolean isPresente(String parola) {
        if (cont == 0) {
            return false;
        }

        for (int i = 0; i < cont; i++) {
            if (array[i].equals(parola)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Aggiunge una parola
     *
     * @param word Parola
     */
    public void addWord(String word) {
        if (cont < array.length) {
            if (!isPresente(word)) {
                array[cont] = word;
                cont++;
            }
        } else {
            String[] temp = new String[cont + 10000];
            System.arraycopy(array, 0, temp, 0, cont);
            array = temp;
            addWord(word);
        }
    }

    /**
     * Aggiunge parole da file
     *
     * @param percorsoFile
     * @throws Exception
     */

    public void addFile(String percorsoFile) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(percorsoFile));
        String st;

        while ((st = br.readLine()) != null) {
            String[] sts = st.split("\\P{Alpha}+");

            for (int i = 0; i < sts.length; i++) {
                addWord(sts[i]);
            }
        }
    }

    /**
     * Crea una stringa di tutte le parole del vocabolario
     *
     * @return Stringa
     */
    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < cont; i++) {
            st.append(array[i]).append("\n");
        }
        return st.toString();
    }

    /**
     * Butta via le parole che non rispettano il filtro selezionato
     */
    public void filter(Selezionatore s) {
        for(int i=0; i< cont; i++){
            if (!s.passa(array[i])){
                for(int k = i; k<cont-1; k++){
                    array[k] = array[k+1];
                }
                cont--;
                i--;
            }
        }
    }


    static public void main(String[] args) throws Exception {
        Vocabolario voc = new Vocabolario();
        SelezionePerIniziale spi = new SelezionePerIniziale('a');
        SelezionePerLunghezza spl = new SelezionePerLunghezza(2);

        voc.addFile("i_promessi_sposi.txt");
        voc.filter(spi);
        System.out.println(voc);
    }
}
