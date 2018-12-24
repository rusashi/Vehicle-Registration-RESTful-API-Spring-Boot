package kz.rusty;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VehicleRegistrationResTfulApiApplication {
	
	@Autowired
	private JdbcTemplate template;
	
	@RequestMapping("/vehicles")
	public List<Map<String,Object>> vehicles() {
		return template.queryForList("select * from vehicle");		
	}
	

	public static void main(String[] args) {
		SpringApplication.run(VehicleRegistrationResTfulApiApplication.class, args);
	}

}

