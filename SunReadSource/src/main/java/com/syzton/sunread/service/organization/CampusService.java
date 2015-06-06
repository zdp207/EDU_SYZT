package com.syzton.sunread.service.organization;

import java.util.Map;

import javassist.NotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.syzton.sunread.dto.organization.CampusDTO;
import com.syzton.sunread.model.organization.Campus;

/**
 * @author Morgan-Leon
 * @Date 2015年4月6日
 * 
 */
public interface CampusService {

//	/**
//	 * @param add
//	 * @param region
//	 * @param school
//	 * @return
//	 */
//	Campus add(CampusDTO add, Long region, Long school);
	
    public Campus deleteById(Long id) throws NotFoundException;

    public Campus update(CampusDTO updated) throws NotFoundException;

    public Campus findById(Long id) throws NotFoundException;

    Page<Campus> findAll(Pageable pageable) throws NotFoundException;

	/**
	 * @param campusName
	 * @return
	 * @throws NotFoundException
	 */
	Campus findByCompusName(String campusName)
			throws com.syzton.sunread.exception.common.NotFoundException;

    public Map<Integer,String> batchSaveOrUpdateCampusFromExcel(Sheet sheet);

	/**
	 * @param add
	 * @param schoolDistrictId
	 * @return
	 */
	Campus addBySchoolDistrict(CampusDTO add, Long schoolDistrictId);

	/**
	 * @param add
	 * @param eduGroupId
	 * @return
	 */
	Campus addByEduGroup(CampusDTO add, Long eduGroupId);

	/**
	 * @param add
	 * @return
	 */
	Campus add(CampusDTO add);
    
    

}
