package com.service.impl;

import com.dao.IMomentDao;
import com.dao.impl.MomentDaoImpl;
import com.entity.Moment;
import com.service.IMomentService;

public class MomentServiceImpl implements IMomentService{

    IMomentDao iMomentdao= new MomentDaoImpl();
    Moment moment= new Moment();
	@Override
	public void insertMoment(int uid, String content, String img) {
		// TODO Auto-generated method stub
		
		moment.setContent(content);
		moment.setUid(uid);
		System.out.println("setContent(content)");
		if (img==null) {
			moment.setImg("");
		}else
		moment.setImg(img);
		iMomentdao.insert(moment);
		System.out.println("≤Â»Î≥…π¶"+uid+content+img);
	}

	
}
