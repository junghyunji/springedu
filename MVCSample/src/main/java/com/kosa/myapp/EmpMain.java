package com.kosa.myapp;

import java.util.List;
import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class EmpMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new GenericXmlApplicationContext("application-config.xml");
		IEmpService empService = context.getBean(IEmpService.class);
		System.out.println("전체 사원의 수  : " + empService.getEmpCount());
		System.out.println("50번 부서의 사원 수 : " + empService.getEmpCount(50));
		
		System.out.println("-----사원 전체 정보 조회----- ");
		List<EmpVO> empList = empService.getEmpList();
		for(EmpVO emp : empList) {
			System.out.println(emp);
		}
//		System.out.println(empService.getEmpList());
		
		System.out.println("-----300번 사원의 정보----- ");
		EmpVO emp1 = empService.getEmpInfo(300);
		System.out.println(emp1);
//		
//		System.out.println("-----새로운 사원 정보 입력----- ");
//		EmpVO emp = new EmpVO();
//		emp.setEmployeeID(210);
//		emp.setFirstName("jinkyoung");
//		emp.setLastName("heo");
//		emp.setEmail("heojk");
//		emp.setPhoneNumber("222-222");
//		emp.setJobId("IT_PROG");
//		emp.setSalary(8000);
//		emp.setCommissionPct(0.2);
//		emp.setManagerId(100);
//		emp.setDepartmentId(10);
//		try {
//			empService.insertEmp(emp);
//			System.out.println("insert OK");
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//		
//		System.out.println("-----신규 사원 정보 조회/출력----- ");
//		EmpVO emp210 = empService.getEmpInfo(210);
//		System.out.println(emp210);
//		
//		System.out.println("-----210번 사원의 급여 10% 인상----- ");
//		emp210.setSalary(emp210.getSalary() * 1.1);
//		try {
//			empService.updateEmp(emp210);
//		} catch(RuntimeException e) {
//			System.out.println(e.getMessage()); // 트리거에 의해 두번 이상 업데이트 안됨
//		}
//		
//		System.out.println("-----수정된 사원 정보 조회----- ");
//		System.out.println(empService.getEmpInfo(210));
//		
//		System.out.println("-----210번 사원의 정보 삭제----- ");
//		try {
//			empService.deleteEmp(210, "heojk");
//		} catch(RuntimeException e) {
//			System.out.println(e.getMessage());
//		}
//		try {
//			System.out.println(empService.getEmpInfo(210));
//		}catch(RuntimeException e) {
//			System.out.println("삭제할 사원정보가 없습니다."); // 이 메세지가 떠야 제대로 삭제된거
//		}
//		
//		System.out.println("-----모든 부서번호와 부서이름 정보 출력----- ");
		List<Map<String, Object>> deptInfo = empService.getAllDeptId();
		for(Map<String, Object> deptId : deptInfo) {
			System.out.println(deptId);
		}
//		System.out.println(empService.getAllDeptId());
//		
//		System.out.println("-----모든 직무아이디와 직무타이틀 출력----- ");
//		System.out.println(empService.getAllJobId());
//		
//		System.out.println("-----모든 매니저번호와 매니저이름 출력----- ");
//		System.out.println(empService.getAllManagerId());
		
		context.close();
	}
}
