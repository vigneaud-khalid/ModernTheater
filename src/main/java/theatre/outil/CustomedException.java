package theatre.outil;

/**
 * author : kh
 * date : 04/04/2021
 */

import java.util.HashMap;

public class CustomedException extends Exception{
    
    private HashMap<String, String> erreurs;

    public CustomedException() {
        erreurs = new HashMap();
    }

    public CustomedException(HashMap<String, String> erreurs) {
        this.erreurs = erreurs;
    }

    public CustomedException(HashMap<String, String> erreurs, String message) {
        super(message);
        this.erreurs = erreurs;
    }

    public HashMap<String, String> getErreurs() {
        return erreurs;
    }

    public void setErreurs(HashMap<String, String> erreurs) {
        this.erreurs = erreurs;
    }
}