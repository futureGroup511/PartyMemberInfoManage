package com.future.partymember.action.manager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.Question;
/**
 * 导入一套excel类型的试卷
 * @author 丁赵雷
 *
 */

@Controller(value="importTestAction")
@Scope("prototype")
public class ImportTestAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File testPaper;
	private String testPaperFileName;
	private String testPaperContentType;
	
	
	
	// 将excel表导入数据库
	public String importTest() throws Exception{

		String type=testPaperFileName.substring(testPaperFileName.lastIndexOf("."));
		
		if(type.equals(".xlsx")){
			util2010();//2010excel
		}
		
		if(type.equals(".xls")){
			util2003();//2003 -2007 excel
		}
		
		this.getRequest().setAttribute("reminder","导入成功");

	return "importTest";
}
	
	
	
public void util2003() throws IOException{
	//需要解析的Excel文件
	File is = new File(testPaper.getPath());
	//创建Excel，读取文件内容
	HSSFWorkbook hssfWorkbook = 
		new HSSFWorkbook(FileUtils.openInputStream(is));
        Question q = null;
        List<Question> list = new ArrayList<Question>();
        // 循环工作表Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // 循环行Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                    q= new  Question ();
                    HSSFCell paperName = hssfRow.getCell(0);
                    HSSFCell questions_stems = hssfRow.getCell(1);
                    HSSFCell answer = hssfRow.getCell(2);
                    HSSFCell analysis = hssfRow.getCell(3);
                    HSSFCell A = hssfRow.getCell(4);
                    HSSFCell B = hssfRow.getCell(5);
                    HSSFCell C = hssfRow.getCell(6);
                    HSSFCell D = hssfRow.getCell(7);
                    
                    q.setPaperId(1);//这个地方应该动态的去判断导入试卷的id
                    
                    q.setQuestions_stems(String.valueOf(questions_stems));
                    q.setAnswer(String.valueOf(answer));
                    q.setAnalysis(String.valueOf(analysis));
                    q.setA(String.valueOf(A));
                    q.setB(String.valueOf(B));
                    q.setC(String.valueOf(C));
                    q.setD(String.valueOf(D));
                    list.add(q);
                }
            }
        }
        for(int i=0; i<list.size();i++){
        	questionService.addQuestion(list.get(i));
        }
}


public void util2010() throws IOException{
	//需要解析的Excel文件
	File is = new File(testPaper.getPath());
	//创建Excel，读取文件内容
	XSSFWorkbook xssfWorkbook = 
		new XSSFWorkbook(FileUtils.openInputStream(is));
        Question q = null;
        List<Question> list = new ArrayList<Question>();
        // 循环工作表Sheet
        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
        	XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }
            // 循环行Row
            for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow hssfRow = xssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                    q= new  Question ();
                    XSSFCell paperName = hssfRow.getCell(0);
                    XSSFCell questions_stems = hssfRow.getCell(1);
                    XSSFCell answer = hssfRow.getCell(2);
                    XSSFCell analysis = hssfRow.getCell(3);
                    XSSFCell A = hssfRow.getCell(4);
                    XSSFCell B = hssfRow.getCell(5);
                    XSSFCell C = hssfRow.getCell(6);
                    XSSFCell D = hssfRow.getCell(7);
                    q.setPaperId(1);
                    q.setQuestions_stems(String.valueOf(questions_stems));
                    q.setAnswer(String.valueOf(answer));
                    q.setAnalysis(String.valueOf(analysis));
                    q.setA(String.valueOf(A));
                    q.setB(String.valueOf(B));
                    q.setC(String.valueOf(C));
                    q.setD(String.valueOf(D));
                    list.add(q);
                }
            }
        }
        for(int i=0; i<list.size();i++){
        	questionService.addQuestion(list.get(i));
        }
}
	
	
	
	
	
	
	
	
	public File getTestPaper() {
		return testPaper;
	}
	public void setTestPaper(File testPaper) {
		this.testPaper = testPaper;
	}
	public String getTestPaperFileName() {
		return testPaperFileName;
	}
	public void setTestPaperFileName(String testPaperFileName) {
		this.testPaperFileName = testPaperFileName;
	}
	public String getTestPaperContentType() {
		return testPaperContentType;
	}
	public void setTestPaperContentType(String testPaperContentType) {
		this.testPaperContentType = testPaperContentType;
	}

}
