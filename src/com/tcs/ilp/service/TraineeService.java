package com.tcs.ilp.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.tcs.ilp.bean.Day;
import com.tcs.ilp.bean.TempTrainee;
import com.tcs.ilp.bean.Trainee;
import com.tcs.ilp.bean.TraineeDay;
import com.tcs.ilp.bean.TraineeDayId;
import com.tcs.ilp.dao.TempTraineeDAO;
import com.tcs.ilp.dao.TraineeDAO;
import com.tcs.ilp.report.AbsenteeReport;

public class TraineeService
{
	TraineeDAO tDao = new TraineeDAO();
	TempTraineeDAO ttDao = new TempTraineeDAO();
	
	public int retrieveTrainees(Date date) throws ParseException, IOException
	{
		SimpleDateFormat sd = new SimpleDateFormat ("dd-MM-yyyy");
		int addTraineeCount = 0;
		String fileName = "E:\\STATUS_"+sd.format(date)+".xls"; //appending date to get appropriate excel file
	 	FileInputStream file = new FileInputStream(new File(fileName));
		HSSFWorkbook workbook = new HSSFWorkbook(file);
        HSSFSheet sheet = workbook.getSheetAt(0); //reading sheet 1
        Day d = new Day();
        d.setCurDate(date);
        tDao.insertDay(d);
        int count=0; //Stores the Column value so that variables can be retrieved and set in a proper order
        Iterator<Row> rowIterator = sheet.iterator(); //To iterate the excel sheet row by row
        Row row = rowIterator.next();
        while(rowIterator.hasNext())
        {
        	Trainee t = new Trainee();
        	TraineeDay td= new TraineeDay();
        	TraineeDayId tdId = new TraineeDayId();
        	count=-1;  //Assuming 0 is the fist cell of each row
        	row = rowIterator.next(); //Assuming first row is header row
        	Iterator<Cell> cellIterator = row.cellIterator(); //To iterate the excel sheet cell by cell of a row
        	while(cellIterator.hasNext())
            {
                Cell cell = cellIterator.next();
                count++; //incrementing count every time when we iterate cell by cell
                switch(cell.getCellType())
                {
                    case Cell.CELL_TYPE_NUMERIC:	
                    	
                    	/* Numeric value in excel is always considered as Double in java, 
                    	 * type casting from double to long is not allowed in java and hence achieving
                    	 * it through Math.round function */
                    	
                    	t.setEmpId(Math.round(cell.getNumericCellValue())); 
                    	break;
                    	
                    case Cell.CELL_TYPE_STRING:
                    	
                    	switch(count)
                    	{
                    	
                    	//String all String type values into respective objects based on cell numbers
                    		case 1: t.setEmpName(cell.getStringCellValue());
                    				break;
                    		case 2:	t.setCity(cell.getStringCellValue());
                    				break;
                    		case 3: t.setLocation(cell.getStringCellValue());
                    				break;
                    		case 4: t.setProject(cell.getStringCellValue());
                    				break;
                    		case 5: td.setStatus(cell.getStringCellValue());
                    				break;
                    	}
                    	break;
                }
            }
    		TempTrainee tt = new TempTrainee();  //Trainee object which containes the date of release
    		tt=ttDao.getTraineeBatchLgDorDetails(t.getEmpId());
    		if(tt.getDor()!=null)
			{
    			t.setDor(tt.getDor());
			}
    		t.setLgName(tt.getLgName());
    		t.setBatchName(tt.getBatchName());
        	if(td.getStatus().equalsIgnoreCase("A") || td.getStatus().equalsIgnoreCase("0.00"))
        	{
        		if(t.getDor()!=null)
        		{
        			if(d.getCurDate().compareTo(t.getDor())<0)
        			{
        				if(!tDao.checkIfTraineeExists(t.getEmpId()))
        				{
        					tDao.insertTrainee(t);
        				}
        			}
        		}
                tdId.setCurDate(d.getCurDate());
                tdId.setEmpId(t.getEmpId());
                td.setId(tdId);
                tDao.insertTraineeDay(td);
                addTraineeCount++;
        	}
        }
        workbook.close();
        file.close();
        FileOutputStream out = new FileOutputStream(new File("E:\\STATUS_"+sd.format(date)+".xls"));
        workbook.write(out);
        out.close();
		return addTraineeCount;
	}
	public List<Trainee> displayDailyAbsenteeTrailgater(String status, Date date)
	{
		return tDao.dailyAbsenteeTailgaters(status, date);
	}
	public List<AbsenteeReport> displayAbsenteesMoreThanTwo()
	{
		return tDao.absenteesMoreThanTwo();
	}
	public List<Day> getOneAbsenteeDetails(Long empId)
	{
		return tDao.getOneAbsenteeDates(empId);
	}
}