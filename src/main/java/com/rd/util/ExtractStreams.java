package com.rd.util;
 
import com.itextpdf.text.exceptions.UnsupportedPdfException;
import com.itextpdf.text.pdf.PRStream;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
 
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
 
/**
 * @author iText
 */
public class ExtractStreams {
    public static final String SRC = "c:\\pdf\\COBRA_Srikanth Govada.pdf";
    public static final String DEST = "c:\\results\\parse\\stream%s";
 
    public static void main(String[] args) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new ExtractStreams().parse(SRC, DEST);
    }
 
    public void parse(String src, String dest) throws IOException {
        PdfReader reader = new PdfReader(src);
        PdfObject obj;
        for (int i = 1; i <= reader.getXrefSize(); i++) {
            obj = reader.getPdfObject(i);
            System.out.println("obj"+obj.toString());
            if (obj != null && obj.isStream()) {
                PRStream stream = (PRStream)obj;
                byte[] b;
                try {
                    b = PdfReader.getStreamBytes(stream);
                }
                catch(UnsupportedPdfException e) {
                    b = PdfReader.getStreamBytesRaw(stream);
                }
                FileOutputStream fos = new FileOutputStream(String.format(dest, i));
                fos.write(b);
                fos.flush();
                fos.close();
            }
        }
    }
}