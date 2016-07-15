package pe.edu.ulima.myapplication.FirebaseHelper;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;

import pe.edu.ulima.myapplication.beans.Comentario;

/**
 * Created by CarlosGabriel on 15/07/2016.
 */
public class FirebaseHelper {

    DatabaseReference db;
    Boolean saved=null;

    public FirebaseHelper(DatabaseReference db) {
        this.db = db;
    }

    public Boolean save(Comentario comentario){
        if(comentario==null){
            saved=false;
        }else{
            try {
                db.child("Comentarios").push().setValue(comentario);
                saved=true;
            }catch (DatabaseException e){
                e.printStackTrace();
                saved=false;

            }

        }
        return saved;
    }
}
