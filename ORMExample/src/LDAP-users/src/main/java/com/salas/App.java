package com.salas;
import java.net.ConnectException;
import java.nio.charset.StandardCharsets;
import  java.util.Properties;

import javax.naming.*;
import javax.naming.directory.*;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
public class App{
	DirContext connection;
	//Para conectarse con LDAP
	//
	public void NewConnection() throws CommunicationException {

		Properties env = new Properties();
		env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL,"ldap://localhost:10389");
		env.put(Context.SECURITY_PRINCIPAL,"uid=admin,ou=system");
		env.put(Context.SECURITY_CREDENTIALS,"secret");
		try {
			connection = new InitialDirContext (env);
		}
		catch(NamingException e) {
			e.printStackTrace();
		}
	}
	//Consultar todas los usuarios
	public void getAllUsers() throws NamingException {
		String searchFilter ="(objectClass=inetOrgPerson)";
		String[] reqAtt = { "cn", "sn", "userPassword" };
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
			byte[] passwordBytes = (byte[]) attr.get("userPassword").get();
			String password = new String(passwordBytes, StandardCharsets.UTF_8);
			//deleteUserFromGroup(name,"Administrators");
			//addUserToGroup(name, "Administrators");
			
			
		}
	}
	public void searchUsers(String cn,String sn) throws NamingException {
		//String searchFilter = "(cn=Salitas)"; //  for one user
		String searchFilter = "(&(sn="+sn+")(cn="+cn+"))"; // and condition
		//String searchFilter = "(|(uid=1)(uid=2)(cn=Smith))"; // or condition
		String[] reqAtt = { "cn", "sn", "userPassword" };
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
			byte[] passwordBytes = (byte[]) attr.get("userPassword").get();
			String password = new String(passwordBytes, StandardCharsets.UTF_8);
			System.out.println("Password: " + password);

		}

	}
	public String getUsername(String cn) throws NamingException {
		// Buscar el usuario en LDAP
		String searchFilter = "(cn=" + cn + ")";
		String[] reqAtt = { "cn" };
		SearchControls controls = new SearchControls();
		controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		controls.setReturningAttributes(reqAtt);

		NamingEnumeration users = connection.search("ou=users,ou=system", searchFilter, controls);

		if (users.hasMore()) {
			SearchResult result = (SearchResult) users.next();
			Attributes attr = result.getAttributes();

			// Devolver el atributo 'sn'
			return attr.get("cn").get(0).toString();
		}

		return null;
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
	/*public void addUser(String cn,String sn,String password) throws NamingException{
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
	        //addUserToGroup(cn,grupo);//Agrega el usuario al grupo que desee
	    } catch (NamingException e) {
	        e.printStackTrace();
	    }
	}*/
	public void addUser(String cn, String sn, String password) throws NamingException {
		Attributes attributes = new BasicAttributes();
		Attribute attribute = new BasicAttribute("objectClass");
		attribute.add("inetOrgPerson");
		attributes.put(attribute);

		// Add user details
		attributes.put("sn", sn);

		// Add user password
		Attribute passwordAttribute = new BasicAttribute("userPassword", password.getBytes(StandardCharsets.UTF_8));
		attributes.put(passwordAttribute);


			connection.createSubcontext("cn=" + cn + ",ou=users,ou=system", attributes);
			System.out.println("add user success");
			//addUserToGroup(cn,grupo);//Agrega el usuario al grupo que desee

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
	public void updateUserPassword(String username, String password) throws NamingException {
		String dnBase=",ou=users,ou=system";
		ModificationItem[] mods= new ModificationItem[1];
		mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, new BasicAttribute("userPassword", password));// if you want, then you can delete the old password and after that you can replace with new password
		connection.modifyAttributes("cn="+username +dnBase, mods);//try to form DN dynamically
		System.out.println("change password success");
	}
	//Para actualizar algun atributo


	public boolean verificarUsuario(String cn, String sn, String providedPassword) throws NamingException {
		// Buscar el usuario en LDAP
		String searchFilter = "(&(cn=" + cn + ")(sn=" + sn + "))";
		String[] reqAtt = { "userPassword" };
		SearchControls controls = new SearchControls();
		controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		controls.setReturningAttributes(reqAtt);

		NamingEnumeration users = connection.search("ou=users,ou=system", searchFilter, controls);

		if (users.hasMore()) {
			SearchResult result = (SearchResult) users.next();
			Attributes attr = result.getAttributes();

			// Recuperar la contraseña almacenada
			String storedPassword = new String((byte[]) attr.get("userPassword").get(), StandardCharsets.UTF_8);

			// Eliminar la etiqueta {SSHA} y decodificar la contraseña almacenada de Base64
			String base64Password = storedPassword.substring(6);  // Eliminar "{SSHA}"
			byte[] decodedPasswordBytes = Base64.getDecoder().decode(base64Password);

			// Extraer la sal de la contraseña almacenada
			byte[] salt = new byte[decodedPasswordBytes.length - 20];
			System.arraycopy(decodedPasswordBytes, 20, salt, 0, salt.length);

			// Codificar la contraseña proporcionada
			byte[] providedPasswordBytes = codificarPassword(providedPassword, salt);

			// Comparar las contraseñas
			return Arrays.equals(decodedPasswordBytes, providedPasswordBytes);
		}

		return false;
	}


	public byte[] codificarPassword(String password, byte[] salt) {
		try {
			// Crear un objeto MessageDigest para el algoritmo SHA-1
			MessageDigest md = MessageDigest.getInstance("SHA-1");

			// Agregar la contraseña y la sal al digest
			md.update(password.getBytes(StandardCharsets.UTF_8));
			md.update(salt);

			// Calcular el hash
			byte[] hashedPassword = md.digest();

			// Concatenar el hash y la sal
			byte[] hashedPasswordAndSalt = new byte[hashedPassword.length + salt.length];
			System.arraycopy(hashedPassword, 0, hashedPasswordAndSalt, 0, hashedPassword.length);
			System.arraycopy(salt, 0, hashedPasswordAndSalt, hashedPassword.length, salt.length);

			return hashedPasswordAndSalt;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}


	//El main de la aplicacion
	public static void main(String[]args ) throws NamingException {
		App app= new App();
		try {
			app.NewConnection();
		} catch (CommunicationException e) {
			throw new RuntimeException(e);
		}
		//System.out.println(app.verifyPassword("Francisque","Garcia","bueno"));
		//app.addUser("Francisque","Garcia","bueno");//nombre, apellido, contrasena
		//app.addUser("Francisco","Garcia","123");//nombre, apellido, contrasena
		//app.updateUserPassword("Francisco", "321");//Actualizo la contrasena
		//app.deleteUser("Francisco");//elimino el usuario
		//app.deleteUserFromGroup("Francisco", "Victimas");//Elimino el usuario del grupo (Victimas,Agresores,Administrators)
		//app.getAllUsers();
		app.searchUsers("Salitas","alejandro solas");
	}
}
	

