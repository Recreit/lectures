package ssk.common.util;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import egovframework.rte.fdl.excel.util.AbstractPOIExcelView;

public class SimplePOIExcelView   extends AbstractPOIExcelView {

	private static final Logger LOGGER  = LoggerFactory.getLogger(SimplePOIExcelView.class);
	
	@Override
	protected void buildExcelDocument(Map model, XSSFWorkbook wb, HttpServletRequest req, HttpServletResponse resp) throws Exception {

		
	}

	
}
