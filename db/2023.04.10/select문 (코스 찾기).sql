select
			cm.id,
			cm.lecture_id,
			cm.student_id,
			cm.registe_date,
			lm.id,
			lm.lecture_name,
			lm.lecture_price,
			lm.lecturer_id,
			lrm.id,
			lrm.name,
			lrm.birth_date,
			sm.id,
			sm.name,
			sm.birth_date
			
		from
			course_mst cm
			left outer join lecture_mst lm on(lm.id = cm.lecture_id)
			left outer join lecturer_mst lrm on(lrm.id = lm.lecturer_id)
			left outer join student_mst sm on(sm.id = cm.student_id)