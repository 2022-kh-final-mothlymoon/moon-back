package kh.sellermoon.admin.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@RequestMapping("/admin/*")
@SessionAttributes({"admin_id","admin_name","admin_pw"})
public class AdminController {
	Logger logger = LogManager.getLogger(AdminController.class);

}
