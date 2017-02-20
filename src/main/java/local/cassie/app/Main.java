package local.cassie.app;

import dao.UserDAO;
import java.io.Console;
import java.nio.charset.Charset;
import java.util.List;
import model.User;

public class Main{
	public static void main(String[] args){
		System.out.println("=================================");
		System.out.println("==============CASSIE=============");
		System.out.println("=================================");

		boolean menu = true;
		Console csl = System.console();

		while(menu){
			UserDAO dao;
			User usr = new User();
			System.out.println("===============MENU=============");
			System.out.println("1 - Create User \n"+
			"2 - All Users \n"+
			"3 - Search by ID \n"+
			"4 - Remove by ID \n"+
			"0 - EXIT");			
			int opt = Integer.parseInt(csl.readLine("Make your choice: "));
			switch(opt){
				case 1:
					dao = new UserDAO();
					System.out.println("================================");
					User usuario = new User();
					usuario.setUserId(csl.readLine("ID: "));
					usuario.setFirstName(csl.readLine("First Name: "));
					usuario.setLastName(csl.readLine("Last Name: "));
					usuario.setCity(csl.readLine("City: "));
					String stg = csl.readLine("String to Bytes: ");
					byte[] b = stg.getBytes();
					usuario.setB(b);

					dao.persist(usuario);
					
					break;
				case 2: 
					dao = new UserDAO();
					List<User> users = dao.getAll();
					for(int i = 0; i < users.size(); i++){
						System.out.println("==============USER=============");
						System.out.println("ID: "+users.get(i).getUserId());
						System.out.println("First Name: "+users.get(i).getFirstName());
						System.out.println("Last Name: "+users.get(i).getLastName());
						byte[] bytes = users.get(i).getB();
						String bString = new String(bytes, Charset.forName("UTF-8"));
						System.out.println("Bytes: "+bString);
						System.out.println("================================");
					}
					break;
				case 3:
					dao = new UserDAO();
					System.out.println("================================");
					usr = dao.getById(csl.readLine("User ID for search:"));
					System.out.println("=============RESULTS============");
					if(usr != null){
						System.out.println("==============USER=============");
						System.out.println("ID: "+usr.getUserId());
						System.out.println("First Name: "+usr.getFirstName());
						System.out.println("Last Name: "+usr.getLastName());
						System.out.println("Bytes: "+usr.getB());
						System.out.println("================================");
					}else{
						System.out.println("Not Found");
					}
					System.out.println("================================");
					break;
				case 4: 
					dao = new UserDAO();
					System.out.println("================================");
					dao.removeById(csl.readLine("User ID for search:"));
					System.out.println("=============RESULTS============");
					System.out.println("=============REMOVED============");
					System.out.println("================================");
					break;
				case 0:
					menu = false;
					break;
				default:
					System.out.println("==============Oops!=============");
					System.out.println("This is not an option!");
					System.out.println("================================");
					break;
			}
		}

		System.out.println("=================================");
		System.out.println("===============Bye===============");
		System.out.println("=================================");
		
		System.exit(0);
	}
}
