package com.kosa.myapp;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface IEmpRepository {
	
	int getEmpCount(); 									// 모든 사원의 수 조회
	int getEmpCount(@Param("deptid") int deptid); 		// 지정한 부서의 사원 수 조회
	List<EmpVO> getEmpList(); 							// 모든 사원의 정보 조회
	EmpVO getEmpInfo(int empid); 						// 사원의 아이디로 사원의 모든 정보 조회	
	void updateEmp(EmpVO emp); 							// 지정한사원의 정보 수정
	void insertEmp(EmpVO emp); 							// 새로운 사원 정보 저장	
	void deleteJobHistory(int empid); 					// 사원의 직무 이력 변경내용 삭제 
	void deleteEmp(@Param("empid") int empid, @Param("email") String email); // 사원의 정보 삭제
	List<Map<String, Object>> getAllDeptId(); 			//모든 부서번호와 부서이름을 조회
	List<Map<String, Object>> getAllJobId(); 			//모든 직무아이디와 직무타이틀을 조회
	List<Map<String, Object>> getAllManagerId();		//모든 매니저아이디와 매니저 이름을 조회

}
