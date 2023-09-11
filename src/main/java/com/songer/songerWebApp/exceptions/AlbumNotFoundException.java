package com.songer.songerWebApp.exceptions;

public class AlbumNotFoundException extends RuntimeException{

    public AlbumNotFoundException(String message){
        super(message);
    }

    public AlbumNotFoundException(Throwable cause){
        super(cause);
    }
}
