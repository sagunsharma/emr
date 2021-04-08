package com.candela.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.candela.entity.ProcessEncounter;
import com.candela.entity.emp;
import com.candela.repository.EmrEncountersRepo;
import com.fasterxml.jackson.core.JsonParser;


@Controller
public class PortalController {
	
	@Autowired
	EmrEncountersRepo emrEncounterRepo;



	
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
    
    @GetMapping("/")
    public String home(Model model) {
    	ArrayList<Map<String, String>> apmnts = new ArrayList<Map<String, String>>();
    	Map<String, String> apmnt = new HashMap<String, String>();
    	apmnt.put("id", "1");
    	apmnt.put("patientname", "Mahesh Kumar");
    	apmnt.put("email", "test@gmail.com");
    	apmnt.put("phone", "8787676783");
    	apmnt.put("doctorname", "Rahul");
    	apmnt.put("department", "xyz");
    	apmnt.put("appointmenton", "29-Mar-2021");
    	apmnt.put("status", "inprogress");
    	apmnts.add(apmnt);
    	Map<String, String> apmnt2 = new HashMap<String, String>();
    	apmnt2.put("id", "2");
    	apmnt2.put("patientname", "Patient2");
    	apmnt2.put("email", "patient2@gmail.com");
    	apmnt2.put("phone", "8587676784");
    	apmnt2.put("doctorname", "Rahul");
    	apmnt2.put("department", "xyz");
    	apmnt2.put("appointmenton", "29-Mar-2021");
    	apmnt2.put("status", "inprogress");
    	apmnts.add(apmnt2);
    	Map<String, String> apmnt3 = new HashMap<String, String>();
    	apmnt3.put("id", "2");
    	apmnt3.put("patientname", "Patient3");
    	apmnt3.put("email", "patient2@gmail.com");
    	apmnt3.put("phone", "8887676764");
    	apmnt3.put("doctorname", "Rahul");
    	apmnt3.put("department", "xyz");
    	apmnt3.put("appointmenton", "29-Mar-2021");
    	apmnt3.put("status", "inprogress");
    	apmnts.add(apmnt3);
    	Map<String, String> apmnt4 = new HashMap<String, String>();
    	apmnt4.put("id", "2");
    	apmnt4.put("patientname", "Patient4");
    	apmnt4.put("email", "patient4@gmail.com");
    	apmnt4.put("phone", "6587676700");
    	apmnt4.put("doctorname", "Rahul");
    	apmnt4.put("department", "xyz");
    	apmnt4.put("appointmenton", "29-Mar-2021");
    	apmnt4.put("apmnt4", "inprogress");
    	apmnts.add(apmnt2);
        model.addAttribute("appointments", apmnts);

        return "home";
    }
	
    @GetMapping("/processencounter")
    public String processencounter(@RequestParam int id, Model model) {
    	
    	model.addAttribute("id",id);
    	if(emrEncounterRepo.findAllById(id)!=null)
    	{
	    	ProcessEncounter pe = emrEncounterRepo.findAllById(id);
	    	System.out.println("ProcessEncounter:"+pe);
	    	String details=pe.getDetails();
	    	System.out.println("details:"+details);
	    	if(details.isBlank() | details.isEmpty())
	    	{
	    		model.addAttribute("patientDetails", null);
	    	}
	    	else
	    	{
	    		JSONObject jobj= new JSONObject(details);
	    		model.addAttribute("tags", jobj.get("chief_complants"));
	    		model.addAttribute("tempreature", jobj.get("tempreature"));
	    		model.addAttribute("bloddpressure_dia", jobj.get("bloddpressure_dia"));
	    		model.addAttribute("bloddpressure_sys", jobj.get("bloddpressure_sys"));
	    		model.addAttribute("respiratory_rate", jobj.get("respiratory_rate"));
	    		model.addAttribute("pulse", jobj.get("pulse"));
	    		model.addAttribute("SPO2", jobj.get("SPO2"));
	    	}
    	}
        return "processencounter";
    }
    @GetMapping("/emrEncounter")
    public String emrEncounter( Model model,HttpServletRequest req) throws ParseException {
    	String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
    	System.out.println("timeStamp:"+timeStamp);
    	java.sql.Date date=java.sql.Date.valueOf(timeStamp);	
    	System.out.println(date);
    	JSONObject jobj=new JSONObject();
    		JSONArray jarr=new JSONArray();
    		String tags=req.getParameter("tags");
    		String sarr[]=tags.split(",");
    		for(String tag:sarr)
    		{
    			if(!tag.isEmpty())
    			{	
    			jarr.put("tag");
    			}
    		}
    		
    		jobj.put("chief_complants", jarr);
    		jobj.put("bloddpressure_sys",  req.getParameter("sys"));
    		jobj.put("bloddpressure_dia",  req.getParameter("dia"));
    		jobj.put("tempreature",  req.getParameter("temp"));
    		jobj.put("respiratory_rate",  req.getParameter("respiratory"));
    		jobj.put("pulse",  req.getParameter("pulse"));
    		jobj.put("SPO2",  req.getParameter("spo"));
    		System.out.println("Jonj:"+jobj);
    		System.out.println("ID:"+req.getParameter("id"));
    		ProcessEncounter processencounter=new ProcessEncounter();//    		
    		processencounter.setPatientid(req.getParameter("id"));
    		processencounter.setDetails(jobj.toString());
    		processencounter.setUpdatedat(date);
    		emrEncounterRepo.save(processencounter);
        model.addAttribute("patientname", "test");
        return "processencounter";
    }
    

}
