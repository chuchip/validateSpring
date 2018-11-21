package com.profesorp;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Component;

import com.profesorp.exception.BeanDuplicateException;


@Component
public class MiBeanService {
	private static  List<MiValidateBean> miBeans = new ArrayList<>();

	static {
		miBeans.add(new MiValidateBean(1, "valor uno"));
		miBeans.add(new MiValidateBean(2, "valor dos"));
		miBeans.add(new MiValidateBean(3, "valor tres"));
	}
	int nextCode=4;
	
	public MiValidateBean getBean(int id) {
		MiValidateBean miBean =
				miBeans.stream()
				 .filter(t -> t.getCodigo()==id)
				 .findFirst()
				 .get();
				
		return miBean;
	}
	public MiValidateBean addBean(MiValidateBean bean)
	{
		if (bean.getCodigo()==0)
		{
			bean.setCodigo(nextCode++);
		}
		else
		{
			if (miBeans.stream().anyMatch(t -> t.getCodigo()==bean.getCodigo()))
				throw new BeanDuplicateException("Duplicate ID: "+bean.getCodigo());
		}
		miBeans.add(bean);
		return bean;
	}
}
