package com.venkatesh.runnable;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.venkatesh.entity.CitizenPlan;
import com.venkatesh.repo.reportservice;
@SpringBootApplication
public class dataLoder implements ApplicationRunner {
@Autowired	
private reportservice repo;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		repo.deleteAll();
		CitizenPlan p=new CitizenPlan();
	p.setCITIZEN_NAME("venkatesh");
	p.setGENDER("male");
	p.setPLAN_NAME("home");
	p.setPLAN_STATUS("approved");
	p.setBENEFIT_AMOUNT(4324);
	
	p.setPLAN_START_DATE(LocalDate.of(2022, 2, 23));
	p.setPLAN_END_DATE(LocalDate.of(2023, 3, 23));
	
	CitizenPlan p1=new CitizenPlan();
	p1.setCITIZEN_NAME("sai");
	p1.setGENDER("male");
	p1.setPLAN_NAME("vehicle");
	p1.setPLAN_STATUS("approved");
	p1.setBENEFIT_AMOUNT(432445);
	
	p1.setPLAN_START_DATE(LocalDate.of(2022, 2, 23));
	p1.setPLAN_END_DATE(LocalDate.of(2023, 3, 23));
	CitizenPlan p2=new CitizenPlan();
	p2.setCITIZEN_NAME("hari");
	p2.setGENDER("male");
	p2.setPLAN_NAME("home");
	p2.setPLAN_STATUS("denial");
	
	
	CitizenPlan p3=new CitizenPlan();
	p3.setCITIZEN_NAME("perry");
	p3.setGENDER("fe-male");
	p3.setPLAN_NAME("vehicle");
	p3.setPLAN_STATUS("approved");
	p3.setBENEFIT_AMOUNT(4324);
	
	p3.setPLAN_START_DATE(LocalDate.of(2022, 2, 23));
	p3.setPLAN_END_DATE(LocalDate.of(2023, 3, 23));
	p3.setTERMINATED_DATE(LocalDate.of(2023, 1, 23));
	p3.setTERMINATION_REASON("job");
	CitizenPlan p4=new CitizenPlan();
	p4.setCITIZEN_NAME("kajal");
	p4.setGENDER("fe-male");
	p4.setPLAN_NAME("medical");
	p4.setPLAN_STATUS("approved");
	p4.setBENEFIT_AMOUNT(4324);
	
	p4.setPLAN_START_DATE(LocalDate.of(2022, 2, 23));
	p4.setPLAN_END_DATE(LocalDate.of(2023, 3, 23));
	
	CitizenPlan p5=new CitizenPlan();
	p5.setCITIZEN_NAME("alex");
	p5.setGENDER("male");
	p5.setPLAN_NAME("home");
	p5.setPLAN_STATUS("denial");
	p5.setDENIAL_REASON("not proper documents");
	CitizenPlan p6=new CitizenPlan();
	p6.setCITIZEN_NAME("samantha");
	p6.setGENDER("fe-male");
	p6.setPLAN_NAME("vehicle");
	p6.setPLAN_STATUS("approved");
	p6.setBENEFIT_AMOUNT(4324);
	
	p6.setPLAN_START_DATE(LocalDate.of(2022, 2, 23));
	p6.setPLAN_END_DATE(LocalDate.of(2023, 3, 23));
	p6.setTERMINATED_DATE(LocalDate.of(2023, 1, 23));
	p6.setTERMINATION_REASON("job");
	CitizenPlan p7=new CitizenPlan();
	p7.setCITIZEN_NAME("ntr");
	p7.setGENDER("male");
	p7.setPLAN_NAME("home");
	p7.setPLAN_STATUS("approved");
	p7.setBENEFIT_AMOUNT(4324);
	
	p7.setPLAN_START_DATE(LocalDate.of(2022, 2, 23));
	p7.setPLAN_END_DATE(LocalDate.of(2023, 3, 23));
	
	
	CitizenPlan p8=new CitizenPlan();
	p8.setCITIZEN_NAME("Rolex");
	p8.setGENDER("male");
	p8.setPLAN_NAME("medical");
	p8.setPLAN_STATUS("denial");
	p8.setDENIAL_REASON("notproper doc");
	CitizenPlan p9=new CitizenPlan();
	p9.setCITIZEN_NAME("aish");
	p9.setGENDER("fe-male");
	p9.setPLAN_NAME("vehicle");
	p9.setPLAN_STATUS("approved");
	p9.setBENEFIT_AMOUNT(4324);
	
	p9.setPLAN_START_DATE(LocalDate.of(2022, 2, 23));
	p9.setPLAN_END_DATE(LocalDate.of(2023, 3, 23));
	p9.setTERMINATED_DATE(LocalDate.of(2023, 1, 23));
	p6.setTERMINATION_REASON("job");
	CitizenPlan p10=new CitizenPlan();
	p10.setCITIZEN_NAME("ntr");
	p10.setGENDER("male");
	p10.setPLAN_NAME("home");
	p10.setPLAN_STATUS("approved");
	p10.setBENEFIT_AMOUNT(4324);
	
	p10.setPLAN_START_DATE(LocalDate.of(2022, 2, 23));
	p10.setPLAN_END_DATE(LocalDate.of(2023, 3, 23));
	
	
	
List<CitizenPlan> citizenplan=		Arrays.asList(p,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10);
		repo.saveAll(citizenplan);
	}

}
