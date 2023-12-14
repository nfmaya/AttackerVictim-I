package com.salas;
import  java.util.Properties;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;
public class App{
	DirContext connection;
	//Para conectarse con LDAP
	//
	public void NewConnection() {

		Properties env = new Properties();
		env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL,"ldap://localhost:10389");
		env.put(Context.SECURITY_PRINCIPAL,"uid=admin,ou=system");
		env.put(Context.SECURITY_CREDENTIALS,"secret");
		try {
			connection = new InitialDirContext (env);
			
			System.out.println("Hello world "+connection);
		}
		catch(AuthenticationException ex){
			System.out.println(ex.getMessage());
		}
		catch(NamingException e) {
			e.printStackTrace();
		}
	}
	//Consultar todas los usuarios
	public void getAllUsers() throws NamingException {
		String searchFilter ="(objectClass=inetOrgPerson)";
		String[] reqAtt= {"cn","sn"};
		SearchControls controls =new SearchControls();
		controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		controls.setReturningAttributes(reqAtt);
		
		NamingEnumeration users =connection.search("ou=users,ou=system",searchFilter ,controls);
	
		SearchResult result=null;
		while(users.hasMore())
		{
			result= (SearchResult) users.next();
			Attributes attr = result.getAttributes();
			String name = attr.get("cn").get(0).toString();
			System.out.println(attr.get("cn"));
			System.out.println(attr.get("sn"));
			//deleteUserFromGroup(name,"Administrators");
			//addUserToGroup(name, "Administrators");
			
			
		}
	}
	public void searchUsers() throws NamingException {
		//String searchFilter = "(uid=1)"; //  for one user
		//String searchFilter = "(&(uid=1)(cn=Smith))"; // and condition 
		String searchFilter = "(|(uid=1)(uid=2)(cn=Smith))"; // or condition
		String[] reqAtt = { "cn", "sn","uid" };
		SearchControls controls = new SearchControls();
		controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		controls.setReturningAttributes(reqAtt);

		NamingEnumeration users = connection.search("ou=users,ou=system", searchFilter, controls);

		SearchResult result = null;
		while (users.hasMore()) {
			result = (SearchResult) users.next();
			Attributes attr = result.getAttributes();
			String name = attr.get("cn").get(0).toString();
			//deleteUserFromGroup(name,"Administrators");
			System.out.println(attr.get("cn"));
			System.out.println(attr.get("sn"));
			System.out.println(attr.get("uid"));
		}

	}
	//agregar usuario sin contrasena
	/*public void addUser() {
		Attributes attributes= new BasicAttributes();
		Attribute attribute= new BasicAttribute("objectClass");
		attribute.add("inetOrgPerson");
		
		attributes.put(attribute);
		//user details
		attributes.put("sn","guevon");
		try {
			connection.createSubcontext("cn=Ricky,ou=users,ou=system",attributes);
			System.out.println("add user sucess");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	//Agrega el usuario con contrasena y grupo
	public void addUser(String cn,String sn,String password,String grupo) {
	    Attributes attributes = new BasicAttributes();
	    Attribute attribute = new BasicAttribute("objectClass");
	    attribute.add("inetOrgPerson");
	    attributes.put(attribute);

	    // Add user details
	    attributes.put("sn", sn);

	    // Add user password
	    String userPassword = password; //
	    Attribute passwordAttribute = new BasicAttribute("userPassword", userPassword);
	    attributes.put(passwordAttribute);

	    try {
	        connection.createSubcontext("cn="+cn+",ou=users,ou=system", attributes);
	        System.out.println("add user success");
	        addUserToGroup(cn,grupo);//Agrega el usuario al grupo que desee
	    } catch (NamingException e) {
	        e.printStackTrace();
	    }
	}
	public void addUserToGroup(String username, String groupName)
	{
		ModificationItem[] mods = new ModificationItem[1];
		Attribute attribute = new BasicAttribute("uniqueMember","cn="+username+",ou=users,ou=system");
		mods[0] = new ModificationItem(DirContext.ADD_ATTRIBUTE, attribute);
		try {
			connection.modifyAttributes("cn="+groupName+",ou=groups,ou=system", mods);
			System.out.println("Add user to Group success");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteUser(String cn) {
		try {
			connection.destroySubcontext("cn="+cn+",ou=users,ou=system");
			System.out.println("delete success");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteUserFromGroup(String username, String groupName)
	{
		ModificationItem[] mods = new ModificationItem[1];
		Attribute attribute = new BasicAttribute("uniqueMember","cn="+username+",ou=users,ou=system");
		mods[0] = new ModificationItem(DirContext.REMOVE_ATTRIBUTE, attribute);
		try {
			connection.modifyAttributes("cn="+groupName+",ou=groups,ou=system", mods);
			System.out.println("success delete user from Group");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/* actualizar la contrasena*/
	public void updateUserPassword(String username, String password) {
		try {
			String dnBase=",ou=users,ou=system";
			ModificationItem[] mods= new ModificationItem[1];
			mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, new BasicAttribute("userPassword", password));// if you want, then you can delete the old password and after that you can replace with new password 
			connection.modifyAttributes("cn="+username +dnBase, mods);//try to form DN dynamically
			System.out.println("change password success");
		}catch (Exception e) {
			System.out.println("failed: "+e.getMessage());
		}
	}
	//Para actualizar algun atributo
	public void updateUserDetails(String username, String employeeNumber) {
		try {
			String dnBase=",ou=users,ou=system";
			Attribute attribute = new BasicAttribute("employeeNumber", employeeNumber);
			ModificationItem[] mods= new ModificationItem[1];
			mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, attribute);
			connection.modifyAttributes("cn="+username +dnBase, mods);//try to form DN dynamically
			System.out.println("success");
		}catch (Exception e) {
			System.out.println("failed: "+e.getMessage());
		}
	}
	//El main de la aplicacion
	public static void main(String[]args ) throws NamingException {
		App app= new App();
		app.NewConnection();
		app.addUser("Francisco","Garcia","123","Victimas");//nombre, apellido, contrasena y en que grupo(Victimas,Agresores,Administrators)
		app.updateUserPassword("Francisco", "321");//Actualizo la contrasena
		app.deleteUser("Francisco");//elimino el usuario
		app.deleteUserFromGroup("Francisco", "Victimas");//Elimino el usuario del grupo (Victimas,Agresores,Administrators)
		app.getAllUsers();
	}
}
	

