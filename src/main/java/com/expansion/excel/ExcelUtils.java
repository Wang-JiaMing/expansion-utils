package com.expansion.excel;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName:expansion-utils
 * @packageName:com.expansion.excel
 * @authorName:wangjiaming
 * @createDate:2020-02-03
 * @editor:IntelliJ IDEA
 * @other:
 **/
public class ExcelUtils {

    /**
     * @param file excel文件
     * @return 第一个list 是sheet位置
     * 第二个list 是该sheet的行位置
     * 第三个list 是该sheet的该行的该单元格位置
     */
    public static List excelChangeMap(MultipartFile file) {
        List excelMap = new ArrayList();
        try {
            if (!file.isEmpty()) {
                HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(file.getInputStream()));
                for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                    HSSFSheet sheet = workbook.getSheetAt(i);
                    List rowsList = new ArrayList();
                    for (int j = 0; j < sheet.getPhysicalNumberOfRows(); j++) {
                        List cellsList = new ArrayList();
                        for (int k = 0; k < sheet.getRow(j).getPhysicalNumberOfCells(); k++) {
                            cellsList.add(sheet.getRow(j).getCell(k).toString());
                        }
                        rowsList.add(cellsList);
                    }
                    excelMap.add(rowsList);
                }
                return excelMap;
            } else {
                return excelMap;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return excelMap;
        }


    }
}
