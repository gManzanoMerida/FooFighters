package com.foo.gmm.examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfFileSpecification;
import com.itextpdf.text.pdf.PdfWriter;

public class AddAttachment {

	public static void main(String[] args) throws FileNotFoundException, DocumentException 	{

		Document document = new Document();
		PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));
		document.open();

		File file = new File("HelloWorld1.pdf");
		if (file.exists())
			try	{
				PdfFileSpecification fileSpecification = PdfFileSpecification.fileEmbedded(pdfWriter, file.getAbsolutePath(), file.getName(), null);
				pdfWriter.addFileAttachment("Sample Attachment", fileSpecification);
			}catch (IOException e)	{
				e.printStackTrace();
			}

		Paragraph paragraph = new Paragraph();
		paragraph.add("Hello World!");
		paragraph.add("Welcome to JCG!");
		paragraph.setAlignment(Element.ALIGN_CENTER);

		document.add(paragraph);
		document.close();
	}

}
