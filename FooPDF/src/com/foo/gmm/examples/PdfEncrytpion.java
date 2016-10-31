package com.foo.gmm.examples;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfEncrytpion {

	private static final String PASSSINGH = "chandansingh";
	private static final String PASSKEY = "chandan";

	public static void main(String[] args) {

		try {

			Document document = new Document();
			String file = "HelloWorld.pdf";
			PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(file));
			pdfWriter.setEncryption(PASSKEY.getBytes(), PASSSINGH.getBytes(), PdfWriter.ALLOW_ASSEMBLY, PdfWriter.ENCRYPTION_AES_256);
			document.open();

			Paragraph paragraph = new Paragraph();
			String message = "Hello World!";
			paragraph.add(message);

			document.add(paragraph);
			document.close();

		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}

	}

}
