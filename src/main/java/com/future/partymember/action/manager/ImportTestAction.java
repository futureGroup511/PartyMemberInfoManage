package com.future.partymember.action.manager;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;
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
import com.future.partymember.entity.TestPaper;
import com.future.partymember.util.SwitchTime;

/**
 * 导入一套excel类型的试卷
 * 
 * @author 丁赵雷 焦祥宇完善
 *
 */

@Controller(value = "importTestAction")
@Scope("prototype")
public class ImportTestAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File testPaper;
	private String testPaperFileName;
	private String testPaperContentType;

	private Question question;
	
	private TestPaper testPap;
	
	// 链接到上传试卷页面
	public String linking() throws Exception {

		return "linking";
	}

	// 将excel表导入数据库
	public String importTest() throws Exception {

		String type = testPaperFileName.substring(testPaperFileName.lastIndexOf("."));

		if (type.equals(".xlsx")) {
			util2010();// 2010excel
		}

		if (type.equals(".xls")) {
			util2003();// 2003 -2007 excel
		}

		this.getRequest().setAttribute("reminder", "导入成功");

		return "importTest";
	}

	//上传试题
	public String question() throws Exception{
		//根据试卷名称获得试卷id
		String paperName=this.getRequest().getParameter("paperName");
		
		TestPaper testPaper=testPaperService.getTestPaperByName(paperName);
		if(testPaper==null){//判断该试卷是否存在
			testPaper=new TestPaper();
			testPaper.setPaperName(paperName);
			testPaper.setCreateDate(SwitchTime.dateToStr(new Date()));
			testPaperService.addTestPaper(testPaper);
			testPaper=testPaperService.getTestPaperByName(paperName);
		}		
		int tp_Id=testPaper.getTp_Id();
		
		//上传试题
		question.setPaperId(tp_Id);
		String bool=questionService.addQuestion(question);
		if(bool.equals("su"))			
			this.getRequest().setAttribute("questionMag", "上传成功");
		else
			this.getRequest().setAttribute("questionMag", "上传失败");
		return "question";
	}
	
	public String toAddTestPaper() throws Exception{
		return "toAddTestPaper";
	}
	
	public String addTestPaper() throws Exception{
		testPap.setCreateDate(SwitchTime.dateToStr(new Date()));
		Boolean bool=testPaperService.addTestPaper(testPap);
		if (bool==true) {
			this.getRequest().setAttribute("testPapMeg", "添加成功");
		}
		else{
			this.getRequest().setAttribute("testPapMeg", "添加失败");
		}
		return "addTestPaper";
	}
	
	public void util2003() throws IOException {
		// 需要解析的Excel文件
		File is = new File(testPaper.getPath());
		// 创建Excel，读取文件内容
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(FileUtils.openInputStream(is));
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
					q = new Question();
					HSSFCell paperName = hssfRow.getCell(0);
					HSSFCell questions_stems = hssfRow.getCell(1);
					HSSFCell A = hssfRow.getCell(2);
					HSSFCell B = hssfRow.getCell(3);
					HSSFCell C = hssfRow.getCell(4);
					HSSFCell D = hssfRow.getCell(5);
					HSSFCell question_socre = hssfRow.getCell(6);
					HSSFCell answer = hssfRow.getCell(7);
					HSSFCell analysis = hssfRow.getCell(8);

					/**
					 * 根据试卷名判断没有这套试卷 没有的话不进行导入试卷
					 */
					q.setPaperId(1);// 这个地方应该动态的去判断导入试卷的id

					q.setQuestions_stems(String.valueOf(questions_stems));
					q.setA(String.valueOf(A));
					q.setB(String.valueOf(B));
					q.setC(String.valueOf(C));
					q.setD(String.valueOf(D));
					int index = String.valueOf(question_socre).trim().indexOf('.');
					String question_socre1 = String.valueOf(question_socre).trim().substring(0, index);
					q.setQuestion_socre(Integer.parseInt(question_socre1));
					q.setAnswer(String.valueOf(answer));
					q.setAnalysis(String.valueOf(analysis));

					list.add(q);
				}
			}
		}
		for (int i = 0; i < list.size(); i++) {
			questionService.addQuestion(list.get(i));
		}
	}

	public void util2010() throws IOException {
		// 需要解析的Excel文件
		File is = new File(testPaper.getPath());
		// 创建Excel，读取文件内容
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(FileUtils.openInputStream(is));
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
				XSSFRow xssfRow = xssfSheet.getRow(rowNum);
				if (xssfRow != null) {
					q = new Question();
					XSSFCell paperName = xssfRow.getCell(0);
					XSSFCell questions_stems = xssfRow.getCell(1);
					XSSFCell A = xssfRow.getCell(2);
					XSSFCell B = xssfRow.getCell(3);
					XSSFCell C = xssfRow.getCell(4);
					XSSFCell D = xssfRow.getCell(5);
					XSSFCell question_socre = xssfRow.getCell(6);
					XSSFCell answer = xssfRow.getCell(7);
					XSSFCell analysis = xssfRow.getCell(8);

					/**
					 * 根据试卷名判断没有这套试卷 没有的话不进行导入试卷
					 */
					q.setPaperId(1);// 这个地方应该动态的去判断导入试卷的id

					q.setQuestions_stems(String.valueOf(questions_stems));
					q.setA(String.valueOf(A));
					q.setB(String.valueOf(B));
					q.setC(String.valueOf(C));
					q.setD(String.valueOf(D));
					int index = String.valueOf(question_socre).trim().indexOf('.');
					String question_socre1 = String.valueOf(question_socre).trim().substring(0, index);
					q.setQuestion_socre(Integer.parseInt(question_socre1));
					q.setAnswer(String.valueOf(answer));
					q.setAnalysis(String.valueOf(analysis));

					list.add(q);
				}
			}
		}
		for (int i = 0; i < list.size(); i++) {
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

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public TestPaper getTestPap() {
		return testPap;
	}

	public void setTestPap(TestPaper testPap) {
		this.testPap = testPap;
	}

}
