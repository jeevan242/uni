package com.saartha.kitchen;
import java.sql.SQLException;
import java.util.*;

import com.saartha.manager.cat_mgr;
import com.saartha.manager.item_mgr;
import com.saartha.manager.uom_mgr;

public class item_driver {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		int ch=0;
		do {
			System.out.println("1.add items 2. delete item 3. show items 4. add units 5. add category 6. exit");
			ch=sc.nextInt();
			switch(ch){
			case 1: System.out.println("enter item name");
			String name=sc.next();
			System.out.println("enter unit kg or something");
			String unit=sc.next();
			System.out.println("enter the quantity");
			int quantity=sc.nextInt();
			System.out.println("enter the category");
			String cat=sc.next();
			item_mgr.additem(name,unit,quantity,cat);
			break;
			case 2:
				System.out.println("enter item_id which you want to delete");
				int id=sc.nextInt();
				item_mgr.delete(id);
				break;
			case 3:
				item_mgr.display();
				break;
			case 4:
				System.out.println("enter the unit name you want to add");
				String unit_name=sc.next();
				uom_mgr.add(unit_name);
				break;
			case 5:
				System.out.println("enter the cat_name which you want to add");
				String cat_name=sc.next();
				cat_mgr.addcat(cat_name);
				break;
			case 6:ch=-1;
			break;
			default:System.out.println("invalid operation");
			break;
			}
		}while(ch!=-1);
		System.out.println("out...");
	}

}
