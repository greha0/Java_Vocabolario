public class SelezionePerLunghezza extends Selezionatore{
    private int lunghezza;

    public SelezionePerLunghezza(int lunghezza)    {
        super();
        this.lunghezza = lunghezza;
    }

    public SelezionePerLunghezza()    {
        this(5);
    }

    public boolean passa(String str){
        return str.length() == lunghezza;
    }
}
