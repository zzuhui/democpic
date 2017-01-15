package com.weikehui.democpic.fc.ctrl;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.weikehui.democpic.fc.entity.PlanDetail;
import com.weikehui.democpic.fc.service.FamilyCardService;

@Controller
@RequestMapping("/fc")
public class FamilyCardCtrl {
	
	@Autowired
	private FamilyCardService familyCardService;
	
	@RequestMapping("/mp/index")
	public String fcindex(Model model){
		model.addAttribute("title", "家庭卡信息维护");
		return "fc/mp/fcindex";
	}
	
	@RequestMapping("/mp/index2")
	public String fcindex2(Model model){
		model.addAttribute("title", "家庭卡信息维护");
		return "fc/mp/fcindex2";
	}
	
	@RequestMapping("/mp/dailyplan")
	public String dailyplan(Model model){
		Date plandate = new Date();
		
		// 获取计划列表
		Sort sort = new Sort(Direction.ASC, "planDate");
		List<PlanDetail> plandetails = familyCardService.getPlansByMonth(plandate, sort);
		model.addAttribute("plandetails", plandetails);
		
		model.addAttribute("title", "每日计划(月)");
		model.addAttribute("dailydate", DateFormatUtils.format(plandate, "yyyy-MM"));
		
		return "fc/mp/dailyplan";
	}
	
	@RequestMapping("/mp/dailyplanadd")
	public String dailyplanadd(@RequestParam(name="plandetailid",required=false)String plandetailid, Model model){
		model.addAttribute("title", "添加计划");		
		System.out.println(plandetailid);
		model.addAttribute("planDetail", new PlanDetail());
		return "fc/mp/dailyplanadd";
	}
	
	@RequestMapping("/mp/dailyplanevent")
	@ResponseBody
	public Map<String, Object> dailyplanevent(@RequestBody String param){
		JsonParser parser = new JsonParser();
		JsonObject jo = parser.parse(param).getAsJsonObject();
		System.out.println(jo.get("dateparam"));
		Map<String, Object> remap = new HashMap<String, Object>();
		try {
			Date plandate = null;
			if("0".equals(jo.get("dateparam").getAsString())){
				plandate = DateUtils.addMonths(DateUtils.parseDate(jo.get("dailydate").getAsString(), "yyyy-MM"), -1);
			}else{
				plandate = DateUtils.addMonths(DateUtils.parseDate(jo.get("dailydate").getAsString(), "yyyy-MM"), 1);
			}
			String dailydateStr = DateFormatUtils.format(plandate, "yyyy-MM");
			remap.put("dailydate", dailydateStr);
			
			Sort sort = null;
			if(DateFormatUtils.format(new Date(), "yyyy-MM").equals(dailydateStr)){
				sort = new Sort(Direction.ASC, "planDate");
			}else{
				sort = new Sort(Direction.DESC, "planDate");
			}
			// 获取计划列表
			List<PlanDetail> plandetails = familyCardService.getPlansByMonth(plandate, sort);
			remap.put("plandetails", plandetails);
			
		} catch (ParseException e) {
			e.printStackTrace();			
		}
		return remap;		
	}
	
	@RequestMapping("/mp/dailyplansave")
	public String dailyplansave(@RequestParam(name="planDetail",required=false) PlanDetail planDetail,Model model){
		model.addAttribute("title", "每日计划");
		System.out.println(new Gson().toJson(planDetail));
		return "fc/mp/dailyplan";
	}
	
	@RequestMapping("/mp/dailyplanday")
	public String dailyplanday(Model model){
		model.addAttribute("title", "每日计划(天)");
		model.addAttribute("dailydate", DateFormatUtils.format(new Date(), "yyyy-MM-dd"));
		return "fc/mp/dailyplanday";
	}
	@RequestMapping("/mp/userlist")
	public String userlist(Model model){
		model.addAttribute("title", "家庭卡用户列表");
		model.addAttribute("dailydate", DateFormatUtils.format(new Date(), "yyyy-MM-dd"));
		return "fc/mp/fcuserlist";
	}
}
