package edu.uh.tech.cis3368.manufacture.logging;

import java.io.PrintWriter;
import java.io.Writer;

public class ExceptionWriter extends PrintWriter {
    public ExceptionWriter(Writer writer){super(writer);}

    private String wrapAroundWithNewlines(String stringWithoutNewLines){
        return ("\n" + stringWithoutNewLines + "\n");
    }

    public  String getExceptionAsString(Throwable throwable){
        throwable.printStackTrace(this);
        String exception = super.out.toString();
        return (wrapAroundWithNewlines(exception));
    }

}
