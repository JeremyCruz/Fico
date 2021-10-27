package com.pe.fico.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.fico.entities.TypeSavingAccount;
import com.pe.fico.repositories.ITypeSavingAccount;
import com.pe.fico.service.ITypeSavingAccountService;

@Service
public class TypeAccountImpl implements ITypeSavingAccountService{
	
	@Autowired
	private ITypeSavingAccount iT;

	@Override
	public Integer insert(TypeSavingAccount TipoCuentaAhorro) {
		int rpta=iT.buscarTipoCuentaAhorro(TipoCuentaAhorro.getNameTypeSavingAccount());
		if(rpta==0) {
			iT.save(TipoCuentaAhorro);
		}
		return rpta;
	}

	@Override
	public List<TypeSavingAccount> list() {
		// TODO Auto-generated method stub
		return iT.findAll();
	}


		
}
