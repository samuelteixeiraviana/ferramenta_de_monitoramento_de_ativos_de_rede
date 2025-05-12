package br.edu.iff.ccc.bsi.controller.view;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.iff.ccc.bsi.entities.Device;
import br.edu.iff.ccc.bsi.service.AgendadorPing;
import br.edu.iff.ccc.bsi.service.DeviceService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping(path = "/") //URL DELE
public class MainViewController {
	
	@Autowired
	private DeviceService deviceService;
	
	@Autowired
	private AgendadorPing agendadorPing;
	
	@GetMapping("home")  //Era pra ser o GET http://localhost:8080/home/ mas está retornando 404 n sei pq
	public String getHome(Model model)  
	{
		Device device = new Device();
	    
	    Map<String, List<Device>> devices = agendadorPing.monitorDevices();
	    
	    model.addAttribute("Device", device);
	    model.addAttribute("devices", devices);
	    
		return "home.html"; 
	}
	
	@GetMapping("login") //GET pra tela de login
	public  String getLogin()
	{
		return "login.html";
	}
	
//	@GetMapping("teste") //GET de teste
//	public String getTeste(Model model)
//	{
//	    Device device = new Device();
//	    
//	    Map<String, List<Device>> devices = agendadorPing.monitorDevices();
//	    
//	    model.addAttribute("Device", device);
//	    model.addAttribute("devices", devices);
//	    
//	    return "teste.html";
//	}
	
//	@PostMapping("teste")
//    public String saveDevice(@Valid @ModelAttribute("Device") Device device, BindingResult result, Model model)
//	{
//        if (result.hasErrors())
//        {	
//        	model.addAttribute("Device", device);
//            return "teste"; // Retorna ao formulário se houver erros
//        }
//        System.out.println("Nome do device criado: "+device.getName()+"\n"+"Endereço do device criado: "+device.getAddress());
//        this.deviceService.insertDevice(device.getName(),device.getAddress());
//        return "redirect:/teste";
//    }	
	
	@PostMapping("home")
	public String saveDevice(@Valid @ModelAttribute("Device") Device device, BindingResult result, Model model)
	{
        if (result.hasErrors())
        {	
        	model.addAttribute("Device", device);
            return "teste"; // Retorna ao formulário se houver erros
        }
        System.out.println("Nome do device criado: "+device.getName()+"\n"+"Endereço do device criado: "+device.getAddress());
        this.deviceService.insertDevice(device.getName(),device.getAddress());
        return "redirect:/home";
    }
}