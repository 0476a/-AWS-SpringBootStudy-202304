select
	cm.csm_id,
	cm.ltm_id,
	cm.sdm_id,
	cm.registe_date,
	lm.ltm_id,
	lm.ltm_name,
	lm.ltm_price,
	lm.itm_id,
	im.itm_id,
	im.itm_name,
	im.itm_birth,
	sm.sdm_id,
	sm.sdm_name,
	sm.sdm_birth
	
from
	course_mst cm
	left outer join lecture_mst lm on(lm.ltm_id = cm.ltm_id)
	left outer join instructor_mst im on(im.itm_id = lm.itm_id)
	left outer join student_mst sm on(sm.sdm_id = cm.sdm_id)
where
	1 = 1
and lm.ltm_id < 3