import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import java.io.FileOutputStream;


public class ExcelWriter {
  public static void main(Double[][] args) throws Exception {
    // Create a new workbook
    WritableWorkbook workbook = Workbook.createWorkbook(new FileOutputStream("output.xls"));

    // Create a new sheet
    WritableSheet sheet = workbook.createSheet("Sheet1", 0);

    // Create a cell and put a value in it
    Label cell = new Label(0, 0, "n");
    sheet.addCell(cell);
    cell = new Label(1, 0, "a");
    sheet.addCell(cell);
    cell = new Label(2, 0, "Total avg Algo1");
    sheet.addCell(cell);
    cell = new Label(3, 0, "Total avg Algo2");
    sheet.addCell(cell);
    cell = new Label(4, 0, "Total avg Algo1/Total avg Algo2");
    sheet.addCell(cell);
    cell = new Label(5, 0, "Best case Algo1");
    sheet.addCell(cell);
    cell = new Label(6, 0, "Best case Algo2");
    sheet.addCell(cell);
    cell = new Label(7, 0, "Best case Algo1/Best case Algo2");
    sheet.addCell(cell);
    cell = new Label(8, 0, "Worst case Algo1");
    sheet.addCell(cell);
    cell = new Label(9, 0, "Worst case Algo2");
    sheet.addCell(cell);
    cell = new Label(10, 0, "Worst case Algo1/Worst case Algo2");
    sheet.addCell(cell);
    

for (int c=0;c<args.length;c++){
    for (int r=0;r<args[c].length;r++){
        
        Number ncell = new Number(c, r+1, args[c][r]);
        sheet.addCell(ncell);
    }
    }

    // Write the workbook to a file
    workbook.write();
    workbook.close();
  }
}
