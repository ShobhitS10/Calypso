package pdf;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.multipdf.PDFMergerUtility;

public class PDFMerger {
	
	public static void main(String[] args) throws IOException {
		PDFMergerUtility PDFmerger = new PDFMergerUtility();
		PDFmerger.setDestinationFileName("C:\\Test\\DocumentAB.pdf");
		File file1 = new File("C:\\Test\\DocumentA.pdf");
		File file2 = new File("C:\\Test\\DocumentB.pdf");
		PDFmerger.addSource(file1);
		PDFmerger.addSource(file2);
		PDFmerger.mergeDocuments();
	}
}