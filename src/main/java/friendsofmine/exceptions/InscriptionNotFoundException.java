package friendsofmine.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by SoF on 02/04/2017.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class InscriptionNotFoundException extends RuntimeException {

    public InscriptionNotFoundException(Long inscriptionId){
        super("L'inscription "+inscriptionId+" est introuvable");
    }
}
