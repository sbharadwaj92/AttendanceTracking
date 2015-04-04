package com.tcs.ilp.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

public class TraineeService
{
	TraineeDAO tDao = new TraineeDAO();
	TempTraineeDAO ttDao = new TempTraineeDAO();
	
	public int retrieveTrainees(Date date) throws ParseException
	{
		SimpleDateFormat sd = new SimpleDateFormat ("dd-MM-yyyy");
		int addTraineeCount = 0;
		try
		{
			String fileName = "E:\\STATUS_"+sd.format(date)+".xls";
		 	FileInputStream file = new FileInputStream(new File(fileName));
			HSSFWorkbook workbook = new HSSFWorkbook(file);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Day d = new Day();
            d.setCurDate(date);
            tDao.insertDay(d);
            int count=0;
            Iterator<Row> rowIterator = sheet.iterator();
            Row row = rowIterator.next();
            while(rowIterator.hasNext())
            {
            	Trainee t = new Trainee();
            	
            	TraineeDay td= new TraineeDay();
            	TraineeDayId tdId = new TraineeDayId();
            	count=-1;
            	row = rowIterator.next();
            	Iterator<Cell> cellIterator = row.cellIterator();
            	while(cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();
                    count++;
                    switch(cell.getCellType())
                    {
                        case Cell.CELL_TYPE_NUMERIC:	
                        	
                        	t.setEmpId(Math.round(cell.getNumericCellValue()));
                        	break;
                        	
                        case Cell.CELL_TYPE_STRING:
                        	
                        	switch(count)
                        	{
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
        		TempTrainee tt = new TempTrainee();
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
            					addTraineeCount++;
            				}
            			}
            		}
            	}
                tdId.setCurDate(d.getCurDate());
                tdId.setEmpId(t.getEmpId());
                td.setId(tdId);
                tDao.insertTraineeDay(td);
            }
            workbook.close();
            file.close();
            FileOutputStream out = new FileOutputStream(new File("E:\\STATUS_"+sd.format(date)+".xls"));
            workbook.write(out);
            out.close();
        }
	 	catch (FileNotFoundException e)
	 	{
            e.printStackTrace();
        }
	 	catch (IOException e)
	 	{
	 		e.printStackTrace();
        }
		return addTraineeCount;
	}
	public List<Trainee> displayDailyAbsenteeTrailgater(String status, Date date)
	{
		return tDao.dailyAbsenteeTailgaters(status, date);
	}
	public Map<List<Long>, List<Trainee>> displayAbsenteesMoreThanTwo()
	{
		return tDao.absenteesMoreThanTwo();
	}
	public List<Day> getOneAbsenteeDetails(Long empId)
	{
		return tDao.getOneAbsenteeDates(empId);
	}
}