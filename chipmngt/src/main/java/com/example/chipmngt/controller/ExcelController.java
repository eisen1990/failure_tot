package com.example.chipmngt.controller;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/excel")
public class ExcelController {
	
	private final int COLUMN_DATE = 1;
	private final int COLUMN_CUSTOMER = 2;
	private final int COLUMN_DEVICE = 4;
	private final int COLUMN_QUANTITY = 9;
	
	@RequestMapping
	public ModelAndView viewDevice() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("excel/view");
		return mav;
	}
	
	@PostMapping(value = "/upload")
	@ResponseBody
	public JSONObject uploadExcel(MultipartHttpServletRequest req, Model model) {
		MultipartFile file = null;
		JSONObject result = new JSONObject();
		JSONArray jArray = null;
		
		Iterator<String> itr = req.getFileNames();
		if (itr.hasNext()) {
			file = req.getFile(itr.next());

			if (file != null) {
				System.out.println("file name : " + file.getName());
				jArray = uploadExcel(file);
				result.put("result", "pass");
				result.put("list", jArray);
			} else {
				result.put("result", "File Error");
				result.put("msg", "Fail to File transfer");
			}
			
		} else {
			// upload된 file이 없을 경우
			result.put("result", "File Error");
		}
		
		return result;
	}
	
	/*
	 * Excel upload routine
	 */
	public JSONArray uploadExcel(MultipartFile file) {
		JSONArray jArray = new JSONArray();
		try {
			OPCPackage opcPackage = OPCPackage.open(file.getInputStream());
			XSSFWorkbook workbook = new XSSFWorkbook(opcPackage);

			XSSFSheet sheet = workbook.getSheetAt(2);
			HashMap<String, Integer> hm = new HashMap<>();
			for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
				XSSFRow row = sheet.getRow(i);
				// 행이 존재하기 않으면 패스
				if (null == row) {
					continue;
				} else {
					XSSFCell cell = null;

					// 1. 출고 일자 -> 출고 주차
					cell = row.getCell(COLUMN_DATE);
					SimpleDateFormat format = new SimpleDateFormat("yyMM");
					
					/*
					 * 하기 getDateCellValue는 cellType 에러가 발생할 수 있으므로,
					 * TODO:추후 각 타입에 대한 검사 이후 리턴하는 루틴 만들 것,
					 */
					Date date = cell.getDateCellValue();
					
					// 2. 고객
					cell = row.getCell(COLUMN_CUSTOMER);
					String company = cell.getStringCellValue();

					// 3. 디바이스
					cell = row.getCell(COLUMN_DEVICE);
					String device = cell.getStringCellValue();
					
					// 4. 수량
					cell = row.getCell(COLUMN_QUANTITY);

					Integer cnt = 0;
					if (cell.getCellType() == CellType.STRING) {
						cnt = Integer.valueOf(cell.getStringCellValue());
					}
					else if (cell.getCellType() == CellType.NUMERIC) {
						cnt = (int) cell.getNumericCellValue();
					}
					else {
						; // 다른 case의 타입인 경우 처리
					}
					Integer tmp = new Integer(0);
					tmp = hm.get(company);
					if (tmp == null) {
						tmp = 0;
					} else {
						; // do not anythings.
					}
					tmp += cnt;
					hm.put(company, tmp);
					
					
					// 5. 
				}

			}
			
			for (String key : hm.keySet()) {
				Integer val = hm.get(key);
				JSONObject jElement = new JSONObject();
				jElement.put("company", key);
				jElement.put("count", val);
				jArray.add(jElement);
			}
			System.out.println(jArray.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return jArray;
	}
	
}
