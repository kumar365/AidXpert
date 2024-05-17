package com.fossgen.healthcare.AidXpert.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fossgen.healthcare.AidXpert.Util.AppUtils;
import com.fossgen.healthcare.AidXpert.model.Medicine;
import com.fossgen.healthcare.AidXpert.repository.MedicineRepository;

@Service
@Transactional
public class MedicineService {

	@Autowired
	MedicineRepository medicineRepository;

	public void createMedicine(Medicine medicine) {
		medicine.setVersion(AppUtils.VERSION);
		medicine.setCreatedBy(AppUtils.getName());
		medicine.setCreatedDate(AppUtils.getTimestamp());
		medicineRepository.save(medicine);
	}

	public List<Medicine> getMedicines() {
		return medicineRepository.findAll();
	}

	public Medicine getMedicineById(int id) {
		return medicineRepository.findById(id).get();
	}

	public void deleteMedicineById(int id) {
		medicineRepository.deleteById(id);
	}
}
