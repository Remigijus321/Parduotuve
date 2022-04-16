package net.parduotube.parduotuvespringbootbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.parduotube.parduotuvespringbootbackend.model.Product;
import net.parduotube.parduotuvespringbootbackend.model.ProductFromDatabase;
import net.parduotube.parduotuvespringbootbackend.repository.CartItemRepository;
import net.parduotube.parduotuvespringbootbackend.repository.ProductRepository;

@SpringBootApplication
public class ParduotuveSpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ParduotuveSpringbootBackendApplication.class, args);
	}
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		
		productRepository.save(new ProductFromDatabase("Nike Shoes 01",
				"https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/5218dd66-7865-48c9-b4d9-87ed201eed2b/zoomx-vaporfly-next-2-mens-road-racing-shoes-glWqfm.png",
				"UI/UX designing, html css tutorials",
				"Here you can learn web designing, UI/UX designing, html css tutorials, css animations and css effects, javascript and jquery tutorials and related so on.", 40));
		
		productRepository.save(new ProductFromDatabase("Nike Shoes 02",
				"https://static.nike.com/a/images/c_limit,w_592,f_auto/tb_product_v1/ac113d48-f387-4342-99ab-3b6615e28e23/adapt-auto-max-mens-shoes-LQF7vj.png",
				"UI/UX designing, html css tutorials", 
				"Here you can learn web designing, UI/UX designing, html css tutorials, css animations and css effects, javascript and jquery tutorials and related so on.", 50));
		
		productRepository.save(new ProductFromDatabase("Nike Shoes 03",
				"https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/f455c542-e69d-49b0-8de5-cf1e4e1c8099/react-infinity-run-flyknit-2-road-running-shoes-Qfh63N.png",
				"UI/UX designing, html css tutorials", 
				"Here you can learn web designing, UI/UX designing, html css tutorials, css animations and css effects, javascript and jquery tutorials and related so on.", 60));
		
		productRepository.save(new ProductFromDatabase("Nike Shoes 04",
				"https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/3de64b00-0714-426b-926b-e97cceb813bb/air-max-95-mens-shoes-95JNSF.png",
				"UI/UX designing, html css tutorials", 
				"Here you can learn web designing, UI/UX designing, html css tutorials, css animations and css effects, javascript and jquery tutorials and related so on.", 60));
		
		productRepository.save(new ProductFromDatabase("Nike Shoes 05",
				"https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/4fc0241c-9820-4fa7-8702-c2ccfb290059/air-force-1-shadow-womens-shoes-kTgn9J.png",
				"UI/UX designing, html css tutorials", 
				"Here you can learn web designing, UI/UX designing, html css tutorials, css animations and css effects, javascript and jquery tutorials and related so on.", 70));
		
		productRepository.save(new ProductFromDatabase("Nike Shoes 06",
				"https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/668d30af-b513-4a6f-b2e0-8eb89626166b/air-vapormax-2021-fk-mens-shoes-NpTfFz.png",
				"UI/UX designing, html css tutorials", 
				"Here you can learn web designing, UI/UX designing, html css tutorials, css animations and css effects, javascript and jquery tutorials and related so on.", 80));
				
//		this.phoneRepository.save(new Phone("Samsung")); 
//		this.phoneRepository.save(new Phone("iPhone"));
//		
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.properties");
//		this.phoneRepository.save(applicationContext.getBean("phone", Phone.class));

	}
}
