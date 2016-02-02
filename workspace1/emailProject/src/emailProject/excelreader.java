package emailProject;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchProviderException;

import javax.swing.JOptionPane;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author edilson.junior
 */
public class excelreader {

     
        void enviar() throws BiffException, IOException, NoSuchProviderException{
		Workbook workbook = Workbook.getWorkbook(new File("Itapuranga.xls"));
		Sheet sheet = workbook.getSheet(0);
		int linhas = sheet.getRows();
		System.out.println("Iniciando a leitura da planilha XLS:");
		for (int i = 1; i < linhas; i++) {
			Cell a1 = sheet.getCell(0, i);
			Cell a2 = sheet.getCell(1, i);
			Cell a3 = sheet.getCell(2, i);
			Cell a4 = sheet.getCell(3, i);
			Cell a5 = sheet.getCell(4, i);
			Cell a6 = sheet.getCell(5, i);
			
			String as1 = a1.getContents();
			String as2 = a2.getContents();
			String as3 = a3.getContents();
			String as4 = a4.getContents();
			String as5 = a5.getContents();
			String as6 = a6.getContents();
			if (as4.contains("2")) {
				Email email = new Email();
				try {
					email.enviarEmail("teste", " A atividade " + as1 + " com previs�o de t�rmino em " + as3
							+ " est� atrasada. Favor acompanhar e tomar as medidas necess�rias.", as5);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} else
				                        System.out.println("sem atrasoS \n" + as4);

			
		}workbook.close();
	}
}
