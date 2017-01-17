package com.emplaccess.controller;

import java.util.List;

import com.emplaccess.domain.Employee;
import com.emplaccess.domain.Machine;
import com.emplaccess.domain.NumberPlate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/numplate")
	public class CountryController {


	@Autowired
	EntityManagerFactory entityManagerFactory ;

	@RequestMapping(value="",method= RequestMethod.GET)
	public
	@ResponseBody
	String verifyAccess(HttpServletRequest request)  {
            
            String numPlate = request.getHeader("Numberplate");
            
            EntityManager em = entityManagerFactory.createEntityManager();
		Query query = entityManagerFactory.createEntityManager()
				.createQuery("SELECT DISTINCT e FROM NumberPlate AS e where e.number=:numPlate",
                                        NumberPlate.class);

        query.setParameter("numPlate",numPlate);
        List<NumberPlate> numberPlateList =query.getResultList();
        
        if(numberPlateList.size()==0) return "Car details not present";
        else return numberPlateList.get(0).getOwner();

//		  int mch_id=Integer.valueOf(request.getHeader("mch_id"));
//		  int emp_rfid=Integer.valueOf(request.getHeader("emp_rfid"));
//
//        System.out.println(mch_id +"mch"+ emp_rfid+"empl");
//
//
//		EntityManager em = entityManagerFactory.createEntityManager();
//		Query queryemp = entityManagerFactory.createEntityManager()
//				.createQuery("SELECT DISTINCT e FROM Employee AS e where e.emp_rfid=:emp_rfid", Employee.class);
//
//        queryemp.setParameter("emp_rfid",emp_rfid);
//        List<Employee> emplList;
//        emplList=queryemp.getResultList();
//
//
//
//       Query querymch=entityManagerFactory.createEntityManager()
//                .createQuery("SELECT DISTINCT m FROM Machine AS m where m.mch_id=:mch_id and m.emp_rfid=:emp_rfid", Machine.class);
//        querymch.setParameter("mch_id",mch_id);
//        querymch.setParameter("emp_rfid",emp_rfid);
//
//
//        List<Machine> mchList ;
//        mchList =querymch.getResultList();
//
//
//        boolean m=mchList.isEmpty();
//        boolean e =emplList.isEmpty();
//
//
//        System.out.println(m +"mch"+ e+"empl");
//
//
//      /// if((emplList.isEmpty()) || (mchList.isEmpty()))
//        if((emplList.isEmpty()) )
//       {
//           return false;
//
//       }
//       else if((mchList.isEmpty())){ return  false;}
//
//
//       else if((emplList.get(0).getEmp_active())!=1 ){return  false;}
//
//       else
      		

	}
}
