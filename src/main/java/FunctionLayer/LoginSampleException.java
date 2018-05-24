package FunctionLayer;

/**
 * The purpose of LoginSampleException is to make sure the user exists in the database and typed the right password
 * @author kasper
 */
public class LoginSampleException extends Exception {

    public LoginSampleException(String msg) {
        super(msg);
    }
    

}
