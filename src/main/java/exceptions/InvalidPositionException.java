package exceptions;

public class InvalidPositionException extends Exception{
    String error;
    public InvalidPositionException(String error){
        this.error = error;
    }
    public String toString(){
        return ("Exception raised is:  " + error) ;
    }

}
