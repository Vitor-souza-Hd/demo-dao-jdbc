package application;

import java.util.Date;
import java.util.List;

import db.DbException;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerdao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerdao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: seller findByDepartment ===");
		List<Seller>list = sellerdao.findByDepartment(seller.getDepartment());
		
		for(Seller e : list) {
			System.out.println(e);
		}
		
		System.out.println("\n=== TEST 3: seller findAll ===");
		List<Seller>listAll = sellerdao.findAll();
		
		for(Seller obj : listAll) {
			System.out.println(obj);
		}
		System.out.println("\n=== TEST 4: seller insert ===");
		Seller newSeller = new Seller(null,"s/n","s/n@email.com", new Date(),1000000.0,new Department(2,null));
		sellerdao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n=== TEST 5: seller update ===");
		seller = sellerdao.findById(1);
		seller.setName("MARTHA WAINE");
		sellerdao.update(seller);
		System.out.println("update completed");
		
	}

}
