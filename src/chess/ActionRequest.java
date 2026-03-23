package chess;

// messenger
public class ActionRequest {
    public int code;
    public String message; // Invalid move
    public boolean isSuccessful;


    public ActionRequest(){
        this.message = "You forgot to change the message for action request";
    }

    public ActionRequest(String msg, boolean result) {
        message  = msg;
        isSuccessful = result;
    }

}
