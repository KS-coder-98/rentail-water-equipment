package pl.sekowski.rent.water.equipment.appuser.file;

public class FileStorageException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private String msg;

    public FileStorageException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

}
