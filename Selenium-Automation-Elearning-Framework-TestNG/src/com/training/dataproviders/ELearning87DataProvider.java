package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.bean.TC89Bean;
import com.training.dao.ELearningDAO;
import com.training.dao.ELearning_TC89;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class ELearning87DataProvider {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<TC89Bean> list = new ELearning_TC89().getLogins(); 

		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(TC89Bean temp : list){
			Object[]  obj = new Object[8]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			obj[2] = temp.getname(); 
			obj[3] = temp.getlastname(); 
			obj[4] = temp.getemail(); 
			obj[5] = temp.getphone(); 
			obj[6] = temp.getuid(); 
			obj[7] = temp.getpwd(); 

			result[count ++] = obj; 
		}


		return result;
	}

	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\MayuriSarmah\\Desktop\\Pr3_87.xlsx"; 
		String TC_87= "Sheet1";
		String TC_88= "Sheet2";		
		return new ApachePOIExcelRead().getExcelContent(fileName, TC_87); 
	}

	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
}
