package com.av.main.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.av.main.model.Usuarios;
import com.av.main.model.Admin;
import com.av.main.model.Catalogos;
import com.av.main.service.AdminService;
import com.av.main.service.CatalogoService;
import com.av.main.service.UsuarioService;

@Controller
@RequestMapping("/")
public class mainController {
	
	@Autowired
	UsuarioService userservice;
	
	@Autowired
	CatalogoService catservice;
	
	@Autowired
	AdminService adminservice;
	
	Usuarios usuarioLogin;
	
	public static String uploadDirectory = System.getProperty("user.dir")+"/Uploads";
	private boolean logout = false;
	
	
	@GetMapping("/")
	public String redirect() {
		return "redirect:/login";
	}
	
	@GetMapping("login")
	public String login(Model model) {
		model.addAttribute("usuario", usuarioLogin);
		if(logout) {
			model.addAttribute("logout", true);
			logout = false;
			return "login";
		}
		return "login";
	}
	
	@PostMapping("login")
	public String ValidateLogin(@RequestParam("username") String username , @RequestParam("pass") String pass, Model model) {
		System.out.println("user " + username + " pass " + pass);
		if(userservice.login(username, pass)) {
			usuarioLogin = userservice.findByUsername(username);
			return "redirect:/inicio/catalogos"; 			
		}
		model.addAttribute("error", true);
		return "login";
	}
	
	@GetMapping("inicio/catalogos")
	public String Catalogos(Model model) { 
		if(LoggedIn()) {
			List<Catalogos> listCata = catservice.findAll();
			model.addAttribute("catalogos", listCata);
			return "index"; 
		} 
		return "redirect:/login";
	} 
	
	@GetMapping("/inicio/usuarios")
	public String inicio(Model model) {
		if(LoggedIn()) {
			List<Usuarios> listUsers = userservice.findAll();
			model.addAttribute("listUsuarios", listUsers);
			return "index";
		}
		return "redirect:/login";
	}
	
	@GetMapping("inicio/usuarios/new")
	public String getsaveUser(Model model) {
		return "saveuser";
	}

	@PostMapping("inicio/usuarios/new")
	public String saveUser(@RequestBody Usuarios user) {
		
		System.out.println();
		return "redirect:/inicio/admin";
	}  

	@GetMapping("inicio/admin")
	public String Admins(Model model) {
		if(LoggedIn()) {
			List<Admin> listAdmins = adminservice.findByRole("admin");
			model.addAttribute("admins", listAdmins);
			return "admins";
		}
		return "redirect:/login"; 
	}
	 
	@GetMapping("inicio/admin/new") 
	public String getsaveadmin(Model model) {
		Admin admin = new Admin();
		model.addAttribute("admin", admin);
		return "adminnew";
	}
	
	@RequestMapping(value = "inicio/admin/new" ,method = RequestMethod.POST)
	public String saveAdmin(Admin admin, @RequestParam("admin_image") MultipartFile[] files) {
		StringBuilder fileName = new StringBuilder();
		for(MultipartFile file: files) {
			Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
			fileName.append(file.getOriginalFilename());
			try {
				Files.write(fileNameAndPath, file.getBytes());
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
		adminservice.save(admin);
		return "redirect:/inicio/admin";
	}  

	@GetMapping("inicio/admin/edit/{id}")
	public String AdminEdit(Model model, @PathVariable long id) {

		Admin admin = adminservice.findByAdmin_Id(id);
		System.out.println(id + admin.getName());
		model.addAttribute("admin", admin);	
		return "adminedit";
	}
	
	@RequestMapping(value = "inicio/admin/edit/{id}", method = RequestMethod.POST)
	public String postAdminEdit(Admin admin, @PathVariable long id) {
		adminservice.update(admin.getName(), admin.getLastname(), admin.getMail(), admin.getArea(), admin.getRole(), admin.isStatus(), id);
		return "redirect:/inicio/admin";
	}
	 
	@GetMapping("inicio/admin/delete/{id}") 
	public String getDeleteAdmin(Model model, @PathVariable long id) {
		Admin admin = adminservice.findByAdmin_Id(id);
		model.addAttribute("admin", admin);
		return "operaciones";
	} 
		
	@PostMapping("inicio/admin/delete/{id}")
	public String postDeleteAdmin(Model model, @PathVariable long id) {
		adminservice.deleteById(id);
		System.out.println(id);
		model.addAttribute("mensage", "Administrador Borrado Correctamente");
		return "redirect:/inicio/admin";
	}
	
	@GetMapping("inicio/admin/details/{id}")
	public String getAdminDetails(Model model, @PathVariable long id) {
		Admin admin = adminservice.findByAdmin_Id(id);
		model.addAttribute("admin", admin);
		return "admindetails";
	}
	
	private boolean LoggedIn() {
		if(usuarioLogin != null)
			return true;
		
		return false;
	}
	
	@GetMapping("logout")
	private String LoggedOut(Model model) {
		usuarioLogin = null;
		logout = true;
		return "redirect:/login";
	}
}
