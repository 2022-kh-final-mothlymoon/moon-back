package kh.sellermoon.admin.controller;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import kh.sellermoon.admin.logic.PointLogic;

@RestController
@RequestMapping("/point/*")
public class RestPointController {
	Logger logger = LogManager.getLogger(RestPointController.class);
	
	@Autowired
	private PointLogic pointLogic = null;
	
	@GetMapping("pointlist")
	public String PointList(Model model, @RequestParam Map<String, Object> pMap) {
      logger.info("PointList 호출 성공");
      
      List<Map<String, Object>> pointList = null;
      pointList = pointLogic.pointList(pMap);
      logger.info(pointList);
      String temp = null;
      Gson g = new Gson();
      temp = g.toJson(pointList);
      return temp;
   }
	
	
	
}