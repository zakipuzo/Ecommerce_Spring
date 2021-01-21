package ma.pfa.springsecurity.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.pfa.springsecurity.service.model.Product;

/**
 * 
 * Ici, l'interface EmpRepository hérite de l'interface JpaRepository de Spring
 * DATA. Il faut juste préciser la classe "Modele" et le type de la classe qui
 * représente la clé primaire.
 * 
 * Spring Data prendra en charge l'implémentation des 04 méthode ci-dessous à
 * condition de réspecter la nomenclature supportée par Spring Data.
 * 
 * @Query offre la possibilité d'exécuter des requêtes plus complexes.
 *
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByPrice(Double salary);

	@Query(" SELECT e from Product e where e.name like %:search% ")
	List<Product> search(@Param("search")String string);

	List<Product> findByPriceAndName(Double salary, String fonction);

	@Query(" SELECT e from Product e where e.price=(select MAX(price) as price FROM Product)")
	Product getEmpHavaingMaxSalary();

	@Query(nativeQuery = true, value = " SELECT * from product LIMIT 8")
	List<Product> lastest();
}
