package dk.tec.magicbeans.beanshop;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BeanItemRepository extends JpaRepository<BeanItem, Integer> {
}
