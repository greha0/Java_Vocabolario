/**
 * Estende Selezionatore
 * Controlla che la stringa inizi per una specifica lettera
 */
public class SelezionePerIniziale extends Selezionatore{
    private char c;

    public SelezionePerIniziale (char c)    {
        super();
        this.c = c;
    }

    public SelezionePerIniziale  ()    {
        this('a');
    }

    public boolean passa(String parola){
        return !parola.isEmpty() && parola.charAt(0) == c;
    }
}
