public class SelezionePerIniziale extends Selezionatore{

    public boolean passa(char iniziale, String str) {
        return str.charAt(0) == iniziale;
    }
}
