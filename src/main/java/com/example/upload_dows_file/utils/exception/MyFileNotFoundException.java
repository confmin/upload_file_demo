package com.example.upload_dows_file.utils.exception;

public class MyFileNotFoundException extends  RuntimeException{
    public MyFileNotFoundException(String message)
    {
        super(message);
    }
    public  MyFileNotFoundException(String message , Throwable throwable)
    {
        super(message,throwable);
    }
}
