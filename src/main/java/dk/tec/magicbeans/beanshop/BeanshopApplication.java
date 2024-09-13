package dk.tec.magicbeans.beanshop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class BeanshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeanshopApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(BeanItemRepository repository) {
		return (args) -> {
			// Create dummy data
			BeanItem bean1 = new BeanItem();
			bean1.setPrice(12);
			bean1.setRarity(2);
			bean1.setName("Firebean");
			bean1.setDescription("A small red bean that boosts energy levels.");
			bean1.setSideEffects("Mild heat sensation");
			bean1.setColor(Colors.RED);

			BeanItem bean2 = new BeanItem();
			bean2.setPrice(25);
			bean2.setRarity(3);
			bean2.setName("MindBean");
			bean2.setDescription("A blue bean that enhances mental clarity.");
			bean2.setSideEffects("Slight headache");
			bean2.setColor(Colors.BLUE);

			BeanItem bean3 = new BeanItem();
			bean3.setPrice(9);
			bean3.setRarity(1);
			bean3.setName("HealBean");
			bean3.setDescription("A green bean with healing properties.");
			bean3.setSideEffects("Drowsiness");
			bean3.setColor(Colors.GREEN);

			BeanItem bean4 = new BeanItem();
			bean4.setPrice(40);
			bean4.setRarity(5);
			bean4.setName("PowerBean");
			bean4.setDescription("Increases magical powers for a short time.");
			bean4.setSideEffects("Temporary exhaustion");
			bean4.setColor(Colors.VIOLET);

			BeanItem bean5 = new BeanItem();
			bean5.setPrice(100);
			bean5.setRarity(6);
			bean5.setName("ShadowBean");
			bean5.setDescription("Grants invisibility for a limited time.");
			bean5.setSideEffects("Loss of balance");
			bean5.setColor(Colors.BLACK);

			// Save beans to the database
			repository.saveAll(List.of(bean1, bean2, bean3, bean4, bean5));

		};
	}
}
